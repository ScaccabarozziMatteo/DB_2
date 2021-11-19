package com.example.db_2.Repository;

import com.example.db_2.POJO.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


public class EmployeeRepositoryImpl implements CustomEmployeeRepository{

    @PersistenceContext
    public EntityManager entityManager;


    @Override
    @Transactional
    public Employee getOne() {
        return entityManager.find(Employee.class,1);
    }
}
