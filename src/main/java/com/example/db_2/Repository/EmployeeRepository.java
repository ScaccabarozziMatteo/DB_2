package com.example.db_2.Repository;

import com.example.db_2.POJO.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>, CustomEmployeeRepository {

}
