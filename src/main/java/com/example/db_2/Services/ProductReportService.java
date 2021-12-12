package com.example.db_2.Services;

import com.example.db_2.POJO.ProductReport;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductReportService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ProductReport> getAll(){
        return entityManager.createQuery("select pr from ProductReport pr").getResultList();
    }

}
