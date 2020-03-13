package com.azad.learning.employeecruddemo.dao.impl;

import com.azad.learning.employeecruddemo.dao.EmployeeDAO;
import com.azad.learning.employeecruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public List<Employee> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employeeList = query.getResultList();

        // return the result
        return employeeList;
    }

    @Override
    public Employee findById(int id) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the employee
        Employee employee = currentSession.get(Employee.class, id);

        // return the employee
        return employee;
    }

    @Override
    public void save(Employee employee) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save employee
        currentSession.saveOrUpdate(employee); // if id=0 then save, else update
    }

    @Override
    public void deleteById(int employeeId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query query = currentSession.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", employeeId);
        query.executeUpdate();
    }
}
