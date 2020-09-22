package com.sda.repo;

import com.sda.dao.DepartmentDao;
import com.sda.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class DepartmentRepo {

    @Autowired
    private DepartmentDao departmentDao;

    public List<Department> displayAllDepartments() {
        List<Department> departmentList = new ArrayList<>();
        departmentList = departmentDao.displayAllDepartments();
        return departmentList;
    }

    public Department createDepartment(Department department) {
        Department department1 = departmentDao.createDepartment(department);
        return department1;
    }

    public boolean deleteDepartment(Integer id) {
        return departmentDao.deleteDepartment(id);
    }
}

