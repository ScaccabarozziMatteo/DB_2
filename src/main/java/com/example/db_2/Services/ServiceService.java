package com.example.db_2.Services;


import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ServiceService {

    @PersistenceContext
    private EntityManager entityManager;


    public int createNew(com.example.db_2.POJO.Service service) throws MessageException {
        List<com.example.db_2.POJO.Service> s=new ArrayList();
        Query query = entityManager.createQuery("select s from Service s where s.type=?1 and s.internet=?2 and s.internet_fee=?3 and s.minutes=?4 and s.minutes_fee=?5 and s.sms=?6 and s.sms_fee=?7" );
        query.setParameter(1,service.getType());
        query.setParameter(2,service.getInternet());
        query.setParameter(3,service.getInternet_fee());
        query.setParameter(4,service.getMinutes());
        query.setParameter(5,service.getMinutes_fee());
        query.setParameter(6,service.getSms());
        query.setParameter(7,service.getSms_fee());
        System.out.println(query);
        s= query.getResultList();
        System.out.println(query.getResultList());
        if(!s.isEmpty())
            throw new MessageException("service already exists!!");

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
