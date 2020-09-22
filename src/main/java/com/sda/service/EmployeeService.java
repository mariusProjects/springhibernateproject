package com.sda.service;

import com.sda.dto.EmployeeDTO;
import com.sda.entities.Employee;
import com.sda.repo.EmployeeRepo;
import com.sda.transfer.EmployeeMapper;
import com.sda.validator.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeValidator employeeValidator;

    public List<EmployeeDTO> displayEmployeeDTO() {

        List<Employee> employeeList = employeeRepo.displayAllEmployees();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        for (Employee employee : employeeList) {
            employeeDTOList.add(employeeMapper.convertEmployeeToEmployeeDTO(employee));
            System.out.println(employee);
        }

        return employeeDTOList;
    }

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        EmployeeDTO employeeDTO1 = null;
        if (employeeValidator.isDTOValid(employeeDTO)) {
            Employee employee = employeeMapper.convertEmployeeDTOToEmployee(employeeDTO);

            Employee employee1 = employeeRepo.createEmployee(employee);
            employeeDTO1 = employeeMapper.convertEmployeeToEmployeeDTO(employee1);
        } else {
            System.out.println("Employee not valid!");
        }
        return employeeDTO1;
    }

    public boolean deleteEmployee(String name) {
        boolean isDeleted = false;
        if (employeeValidator.isNameValid(name)) {
            isDeleted = employeeRepo.deleteEmployee(name);
        }
        if (isDeleted) {
            System.out.println("Employee was deleted!");
        } else {
            System.out.println("Employee was not deleted!");
        }
        return isDeleted;
    }

    public boolean deleteEmployeeByNameAndPosition(String name, String position) {
        boolean isDeleted = false;
        if (employeeValidator.isNameValid(name) && employeeValidator.isPositionValid(position)) {
            isDeleted = employeeRepo.deleteEmployeeByNameAndPosition(name, position);
        }

        if (isDeleted) {
            System.out.println("Employee was deleted!");
        } else {
            System.out.println("Employee was not deleted!");
        }
        return isDeleted;
    }

    public List<EmployeeDTO> displayEmployeesDTOByName(String name) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        if (employeeValidator.isNameValid(name)) {
            List<Employee> employeeList = employeeRepo.displayEmployeesByName(name);
            for (Employee employee : employeeList) {
                employeeDTOList.add(employeeMapper.convertEmployeeToEmployeeDTO(employee));
            }
        } else {
            System.out.println("Name is not valid!");
        }
        return employeeDTOList;
    }

    public List<EmployeeDTO> displayEmployeeDTOByNameAndPosition(String name, String position) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        if (employeeValidator.isNameValid(name) && employeeValidator.isPositionValid(position)) {
            List<Employee> employeeList = employeeRepo.displayEmployeesByNameAndPosition(name, position);
            for (Employee employee : employeeList) {
                employeeDTOList.add(employeeMapper.convertEmployeeToEmployeeDTO(employee));
            }
        } else {
            System.out.println("Name or position or both are not valid!");
        }
        return employeeDTOList;
    }

    public EmployeeDTO updateEmployee(String name, EmployeeDTO employeeDTO) {
        EmployeeDTO employeeDTOUpdated = null;
        if (employeeValidator.isNameValid(name) && employeeValidator.isPositionValid(employeeDTO.getPosition()) &&
                employeeValidator.isAgeValid(employeeDTO.getAge())) {
            Employee employee = employeeMapper.convertEmployeeDTOToEmployee(employeeDTO);
            employeeDTOUpdated = employeeMapper.convertEmployeeToEmployeeDTO(employeeRepo.updateEmployee(name, employee));
        } else {
            System.out.println("Data entered are not valid!");
        }
        return employeeDTOUpdated;
    }
}
