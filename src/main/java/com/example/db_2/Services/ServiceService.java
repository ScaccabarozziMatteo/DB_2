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


    public List<com.example.db_2.POJO.Service> findAllServices(){
        Query query = entityManager.createQuery("select s from Service s" );
        return query.getResultList();
    }

    public int createNew(com.example.db_2.POJO.Service service) throws MessageException {
        List<com.example.db_2.POJO.Service> s=new ArrayList();
    Integer minutes=null, sms, internet;
    Float minutes_fee,sms_fee, internet_fee;
        internet=service.getInternet();
        internet_fee = service.getInternet_fee();
        minutes =service.getMinutes();
        minutes_fee=service.getMinutes_fee();
        sms =service.getSms();
        sms_fee=service.getSms_fee();
        Query query=entityManager.createQuery("select s from Service s");
        switch (service.getType()) {
            case ("fixed internet"):
            case ("mobile internet"):
                query = entityManager.createQuery("select s from Service s where (s.type=?1 and s.internet=?2 and s.internet_fee=?3 and s.minutes is null and s.minutes_fee is null and s.sms is null and s.sms_fee is null)" );
                query.setParameter(1,service.getType());
                query.setParameter(2,internet);
                query.setParameter(3,internet_fee);
                break;
            case ("mobile phone"):
                query = entityManager.createQuery("select s from Service s where (s.type=?1 and s.internet is null and s.internet_fee is null and s.minutes=?2 and s.minutes_fee=?3 and s.sms=?4 and s.sms_fee=?5)" );
                query.setParameter(1,service.getType());
                query.setParameter(2,minutes);
                query.setParameter(3,minutes_fee);
                query.setParameter(4,sms);
                query.setParameter(5,sms_fee);
                break;
            case ("fixed phone"):
                query = entityManager.createQuery("select s from Service s where (s.type=?1 )" );
                query.setParameter(1,service.getType());
                break;
        }
        s= query.getResultList();
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
