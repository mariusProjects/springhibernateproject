package com.sda.dao;

import com.sda.entities.Department;
import com.sda.util.HibernateUtil;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class DepartmentDao {

    public List<Department> displayAllDepartments() {

        List<Department> departmentList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "from Department";
            Query query = session.createQuery(hql);
            departmentList = query.list();
            session.getTransaction().commit();
        } catch (HibernateError e) {
            e.printStackTrace();
        }
        return departmentList;
    }

    public Department createDepartment(Department department) {
        Department department1 = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(department);
            session.getTransaction().commit();
            if (id != null) {
                department1 = session.get(Department.class, id);
            } else {
                System.out.println("Department was not created!");
            }
        }
        return department1;
    }

    public boolean deleteDepartment(Integer id) {
        boolean validator = false;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Department department = session.get(Department.class, id);
            if (department != null) {
                session.delete(department);
                session.getTransaction().commit();
                validator = true;
            } else {
                System.out.println("Department with id: " + id + " was not found in the database!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validator;
    }
}
