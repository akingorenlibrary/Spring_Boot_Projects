package com.RestEmployee.RestEmployee.dao;

import com.RestEmployee.RestEmployee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImlp implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImlp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> typedQuery=entityManager.createQuery("FROM Employee",Employee.class);
        List<Employee> employees=typedQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee employee=entityManager.find(Employee.class,theId);
        return employee;
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        Employee employee=entityManager.merge(theEmployee);
        return employee;
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        Employee employee=entityManager.find(Employee.class,theId);
        entityManager.remove(employee);
    }
}
