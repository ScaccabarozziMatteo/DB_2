package com.example.db_2.Services;


import com.example.db_2.POJO.insolvent_user;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class insolvent_userService {
    @PersistenceContext
    private EntityManager entityManager;

    public List<insolvent_user> getAll(){
       return entityManager.createNamedQuery("InsolventfindAll", insolvent_user.class).getResultList();
    }

}
