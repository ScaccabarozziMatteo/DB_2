package com.example.db_2.Services;


import com.example.db_2.POJO.Employee;
import com.example.db_2.POJO.User;
import com.example.db_2.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @PersistenceContext
    private EntityManager entityManager;

    public Employee findEmployeeByEmail(String email){
        return entityManager.createNamedQuery("Employee.findByEmail",Employee.class).setParameter(1,email).getSingleResult();
    }

    public boolean isEmailPresent(String email){
        Query query = entityManager.createQuery( "select count (e) from Employee e where e.email =?1");

        query.setParameter(1,email);
        Long i = (Long) query.getSingleResult();
        return ((i.equals(0L))? false:true);
    }

    public Employee checkCredentials(String email, String pwd) throws NonUniqueResultException, MessageException {
        List<Employee> employeeList = null;
        try {
            employeeList = entityManager.createNamedQuery("Employee.checkCredentials", Employee.class).setParameter(1, email).setParameter(2, pwd)
                    .getResultList();
        } catch (PersistenceException e) {
            throw new MessageException("Could not verify credentials");
        }
        if (employeeList.isEmpty())
            return null;
        else if (employeeList.size() == 1)
            return employeeList.get(0);
        throw new NonUniqueResultException("Multiple user registered with same credentials!");

    }

    public int createEmployee(String email, String password) throws MessageException{
        if(isEmailPresent(email)){
            throw new MessageException("This email is already registered!");
        }

        if(email==null|| password==null||email.equals("")||  password.equals("") ||email.isEmpty()|| password.isEmpty() || email.length() > 31 || password.length() > 61){
            throw new MessageException("Can't register empty strings, insert valid credentials");
        }

        Employee e= new Employee(email,password);
        entityManager.persist(e);
      /*  u.setEmail(email);
        u.setUsername(username);
        u.setPassword(password);*/
        entityManager.flush();
        return e.getId();
    }
}
