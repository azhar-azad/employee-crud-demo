package com.azad.learning.employeecruddemo.rest;

import com.azad.learning.employeecruddemo.dao.EmployeeDAO;
import com.azad.learning.employeecruddemo.entity.Employee;
import com.azad.learning.employeecruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employees" and return list of employees
    @GetMapping(path = "/employees")
    public List<Employee> findAll() {
        return employeeService.findAll(); 
    }
}
