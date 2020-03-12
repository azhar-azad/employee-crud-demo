package com.azad.learning.employeecruddemo.dao.impl;

import com.azad.learning.employeecruddemo.dao.EmployeeDAO;
import com.azad.learning.employeecruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    // define field for EntityManager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired // optional, as spring boot does that automatically
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employeeList = theQuery.getResultList();

        // return the result
        return employeeList;
    }
}