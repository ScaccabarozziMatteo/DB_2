package com.example.db_2.Services;

import com.example.db_2.POJO.Employee;
import com.example.db_2.POJO.OptionalProduct;
import com.example.db_2.POJO.Package;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PackageService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Package> findALL(){
        Query query = entityManager.createQuery("select p from Package p" );
        return query.getResultList();
    }



    public int createPackage2(Package aPackage,List<Integer> prods_id) throws MessageException {
        OptionalProduct op =new OptionalProduct();

        Query query = entityManager.createQuery("select p from Package p where p.name = ?1", Package.class);
        query.setParameter(1,aPackage.getName());

        if(!query.getResultList().isEmpty()){
            throw new MessageException("Package " + aPackage.getName() + " alredy exists!");
        }

        if(prods_id!=null) {
            for (int prod_id : prods_id) {
                op = entityManager.find(OptionalProduct.class, prod_id);
                if (op == null) {
                    throw new MessageException("Optional product " + prod_id + " is not avaiable!");
                }
            }
        }
        for(com.example.db_2.POJO.Service ss : aPackage.getServices()){
            entityManager.persist(ss);
        }
        entityManager.persist(aPackage);
        entityManager.flush();
        return aPackage.getId();
    }

    public int createPackage(String name, Float fee12, Float fee24, Float fee36, int employee_id, List<Integer> services_id,List<Integer> prods_id) throws MessageException {

        List<OptionalProduct> optionalProducts = new ArrayList<>();
        OptionalProduct op = new OptionalProduct();


        List<com.example.db_2.POJO.Service> services = new ArrayList<>();
        com.example.db_2.POJO.Service sv = new com.example.db_2.POJO.Service();
        for(int service_id : services_id){
            sv = entityManager.find(com.example.db_2.POJO.Service.class,service_id);

            if(sv == null){
                throw new MessageException("Service "+ service_id + "is not avaiable!");
            }
            services.add(sv);
        }

        Employee employee =new Employee();
        employee = entityManager.find(Employee.class,employee_id);

        if(employee==null)
        {
            throw new MessageException("Permission denied: employee " + employee_id +" not found!");
        }

        Package aPackage = new Package();
        aPackage.setServices(services);
        if(prods_id!=null) {
            for (int prod_id : prods_id) {
                op = entityManager.find(OptionalProduct.class, prod_id);
                if (op == null) {
                    throw new MessageException("Optional product " + prod_id + " is not avaiable!");
                }
                optionalProducts.add(op);
            }
            aPackage.setOptionalProducts(optionalProducts);
        }

        aPackage.setEmployee(employee);
        aPackage.setFee12(fee12);
        aPackage.setFee24(fee24);
        aPackage.setFee36(fee36);
        aPackage.setName(name);
        entityManager.persist(aPackage);
        entityManager.flush();
        return aPackage.getId();
    }


}
