package com.example.db_2.Services;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PackageService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Package> findALL(){
        return null;
    }
}
