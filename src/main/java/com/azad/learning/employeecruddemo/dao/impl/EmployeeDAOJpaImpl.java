package com.azad.learning.employeecruddemo.dao.impl;

import com.azad.learning.employeecruddemo.dao.EmployeeDAO;
import com.azad.learning.employeecruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        Query query = entityManager.createQuery("from Employee");

        // execute query and get result list
        List<Employee> employeeList = query.getResultList();

        // return the results
        return employeeList;
    }

    @Override
    public Employee findById(int id) {

        // get employee
        Employee employee = entityManager.find(Employee.class, id);

        // return employee
        return employee;
    }

    @Override
    public void save(Employee employee) {

        // save or upload the employee
        Employee dbEmployee = entityManager.merge(employee);

        // update with id from db ... so we can get generated id for save/inser
        employee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int id) {

        // delete object with primary key
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");

        query.setParameter("employeeId", id);

        query.executeUpdate();
    }
}
