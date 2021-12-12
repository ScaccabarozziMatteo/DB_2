package com.example.db_2.Services;

import com.example.db_2.POJO.suspendedOrder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class suspendedOrderService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<suspendedOrder> getAll()
    {
        return entityManager.createQuery("select OS from suspendedOrder OS").getResultList();
    }
}
