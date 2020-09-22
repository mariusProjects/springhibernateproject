package com.sda.dto;

import com.sda.entities.Employee;

public class DepartmentDTO {
    private String nameOfDepartment;
    //private Employee employee;

    public String getNameOfDepartment() {
        return nameOfDepartment;
    }

    public void setNameOfDepartment(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }

    /*public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }*/

    /*@Override
    public String toString() {
        return " Numele departamentului este " + nameOfDepartment +
                " si managerul este " + employee.getNameOfEmployee();
    }*/
}
