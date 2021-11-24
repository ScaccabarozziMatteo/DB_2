package com.example.db_2.Services;


import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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

}
