package com.example.db_2.Services;

import com.example.db_2.POJO.Package_Report;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PackageReportService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Package_Report> getAll(){
        return entityManager.createNamedQuery("findAll",Package_Report.class).getResultList();
    }

    public Package_Report getByPackage(int PackageID) throws MessageException {
        Package_Report pr = new Package_Report();
        pr = entityManager.createNamedQuery("findByPackage",Package_Report.class).setParameter(1,PackageID).getSingleResult();
        if (pr==null){
            throw new MessageException("No info about Package "+ PackageID + "are available.");
        }
        return pr;
    }
}
