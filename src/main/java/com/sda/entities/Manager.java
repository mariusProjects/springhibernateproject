package com.sda.entities;

import javax.persistence.*;



public class Manager{
    @Column(name = "department_managed")
    private String departmentManaged;

    public Manager() {
    }

    public String getDepartmentManaged() {
        return departmentManaged;
    }

    public void setDepartmentManaged(String departmentManaged) {
        this.departmentManaged = departmentManaged;
    }
}
