package com.example.db_2.Services;

import com.example.db_2.POJO.auditingTable;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuditingTableService {
    @PersistenceContext
    private EntityManager entityManager;

    public List<auditingTable> getAuditingTable(){
        return entityManager.createQuery("select a from auditingTable a").getResultList();
    }


}
