package com.sda.repo;

import com.sda.dao.EmployeeDao;
import com.sda.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public class EmployeeRepo {

    @Autowired
    public EmployeeDao employeeDao;

    public List<Employee> displayAllEmployees() {
        List<Employee> employeeList = employeeDao.displayAllEmployees();
        return employeeList;
    }

    public Employee createEmployee(Employee employee) {
        Employee employee1 = employeeDao.createEmployee(employee);
        return employee1;
    }

    public boolean deleteEmployee(String name) {
        return employeeDao.deleteEmployee(name);
    }

    public List<Employee> displayEmployeesByName(String name) {
        List<Employee> employeeList = employeeDao.displayEmployeesByName(name);
        return employeeList;
    }

    public List<Employee> displayEmployeesByNameAndPosition(String name, String position) {
        List<Employee> employeeList = employeeDao.displayEmployeesByNameAndPosition(name, position);
        return employeeList;
    }

    public boolean deleteEmployeeByNameAndPosition(String name, String position) {
        return employeeDao.deleteEmployeeByNameAndPosition(name, position);
    }

    public Employee updateEmployee(String name, Employee employee) {
        return employeeDao.updateEmployee(name, employee);
    }
}
