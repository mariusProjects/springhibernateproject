package com.sda.dto;

import com.sda.entities.Department;

public class EmployeeDTO {

    private String nameOfEmployee;
    private String position;
    private Integer age;
   /* private Department department;*/

    public String getNameOfEmployee() {
        return nameOfEmployee;
    }

    public void setNameOfEmployee(String nameOfEmployee) {
        this.nameOfEmployee = nameOfEmployee;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

   /* public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }*/

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "name='" + nameOfEmployee + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                '}';
    }
}
