package com.sda.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "employees")
public class Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_of_employee")
    private String nameOfEmployee;

    @Column(name = "position")
    private String position;

    @Column(name = "age")
    private Integer age;

   /* @ManyToOne
    @JoinTable(name = "employees_departments", joinColumns = {@JoinColumn(name = "employees_id")},
               inverseJoinColumns = {@JoinColumn(name = "departments_id")})
    private Department department;*/

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
    /*public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }*/

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", nameOfEmployee='" + nameOfEmployee + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
              /*  ", department=" + department +*/
                '}';
    }

}
