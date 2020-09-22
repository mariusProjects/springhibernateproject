package com.sda.transfer;

import com.sda.dto.EmployeeDTO;
import com.sda.entities.Employee;
import org.springframework.stereotype.Component;


@Component
public class EmployeeMapper {

    public EmployeeDTO convertEmployeeToEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setNameOfEmployee(employee.getNameOfEmployee());
        employeeDTO.setPosition(employee.getPosition());
        employeeDTO.setAge(employee.getAge());
        /*  employeeDTO.setDepartment(employee.getDepartment());*/
        return employeeDTO;
    }

    public Employee convertEmployeeDTOToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setNameOfEmployee(employeeDTO.getNameOfEmployee());
        employee.setAge(employeeDTO.getAge());
        employee.setPosition(employeeDTO.getPosition());
        /*employee.setDepartment(employeeDTO.getDepartment());*/
        return employee;
    }
}
