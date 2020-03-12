package com.azad.learning.employeecruddemo.dao;

import com.azad.learning.employeecruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();
}
