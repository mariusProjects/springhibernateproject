package com.sda.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_of_department")
    private String nameOfDepartment;

  /*  @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Employee> employeeList;*/

   /* @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "department_manager_id") // foreign key
    private Manager manager;*/

    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfDepartment() {
        return nameOfDepartment;
    }

    public void setNameOfDepartment(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }

    /*public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }*/

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", nameOfDepartment='" + nameOfDepartment + '\'' +
                /*", employeeList=" + employeeList +*/
                '}';
    }
}
