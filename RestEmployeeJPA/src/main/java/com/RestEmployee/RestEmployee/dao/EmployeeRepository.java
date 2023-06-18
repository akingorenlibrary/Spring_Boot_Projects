package com.RestEmployee.RestEmployee.dao;

import com.RestEmployee.RestEmployee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
