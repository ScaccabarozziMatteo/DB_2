package com.example.db_2.Services;


import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServiceService {

    @PersistenceContext
    private EntityManager entityManager;



    public int createNew(com.example.db_2.POJO.Service service){
        entityManager.persist(service);
        entityManager.flush();
        return service.getId();
    }

    public List<com.example.db_2.POJO.Service> findMobilePhone(){
        Query query = entityManager.createQuery("select s from Service s where s.type=?1" );
        query.setParameter(1,"mobile phone");
        return query.getResultList();
    }

    public List<com.example.db_2.POJO.Service> findFixedInternet(){
        Query query = entityManager.createQuery("select s from Service s where s.type=?1" );
        query.setParameter(1,"fixed internet");
        return query.getResultList();
    }

    public List<com.example.db_2.POJO.Service> findMobileInternet(){
        Query query = entityManager.createQuery("select s from Service s where s.type=?1" );
        query.setParameter(1,"mobile internet");
        return query.getResultList();
    }


}
