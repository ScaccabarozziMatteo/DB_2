package com.example.db_2.Services;

import com.example.db_2.POJO.auditingTable;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuditingTableService {
    @PersistenceContext
    private EntityManager entityManager;

    public List<auditingTable> getAuditingTable(){
        Query query = entityManager.createQuery("select o from auditingTable o" );
        return query.getResultList();
    }


}
