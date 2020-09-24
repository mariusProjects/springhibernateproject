package com.sda.dao;

import com.sda.entities.Employee;
import com.sda.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;



@Repository
public class EmployeeDao {

    public List<Employee> displayAllEmployees() {

        List<Employee> employeeList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "from Employee";
            Query query = session.createQuery(hql);
            employeeList = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }


    public Employee createEmployee(Employee employee) {
        Employee employee1 = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(employee);
            session.getTransaction().commit();
            if (id != null) {
                employee1 = session.get(Employee.class, id);
            } else {
                System.out.println("Employee was not created!");
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return employee1;
    }

    public boolean deleteEmployee(String name) {
        boolean isDeleted = false;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            String countHQL = "SELECT COUNT(*) FROM Employee where nameOfEmployee =: nameOfEmployee";
            Query countQuery = session.createQuery(countHQL);
            countQuery.setParameter("nameOfEmployee", name);
            Long countResult = (Long) countQuery.uniqueResult();
            if (countResult != 1) {
                isDeleted = false;
            } else {
                String deleteHQL = "DELETE FROM Employee WHERE nameOfEmployee =:nameOfEmployee";
                Query deleteQuery = session.createQuery(deleteHQL);
                deleteQuery.setParameter("nameOfEmployee", name);
                int result = deleteQuery.executeUpdate();
                if (result != 0) {
                    isDeleted = true;
                } else {
                    isDeleted = false;
                }
            }


            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    public boolean deleteEmployeeByNameAndPosition(String name, String position) {
        boolean isDeleted = false;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            String countHQL = "SELECT COUNT(*) FROM Employee where nameOfEmployee =: nameOfEmployee AND position=:position";
            Query countQuery = session.createQuery(countHQL);
            countQuery.setParameter("nameOfEmployee", name);
            countQuery.setParameter("position", position);
            Long countResult = (Long) countQuery.uniqueResult();
            if (countResult != 1) {
                isDeleted = false;
            } else {
                String deleteHQL = "DELETE FROM Employee WHERE nameOfEmployee =:nameOfEmployee AND position=:position";
                Query deleteQuery = session.createQuery(deleteHQL);
                deleteQuery.setParameter("nameOfEmployee", name);
                deleteQuery.setParameter("position", position);
                int result = deleteQuery.executeUpdate();
                if (result != 0) {
                    isDeleted = true;
                } else {
                    isDeleted = false;
                }
            }
            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }


    public List<Employee> displayEmployeesByName(String name) {
        List<Employee> employeeList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "FROM Employee WHERE nameOfEmployee LIKE:nameOfEmployee";
            Query query = session.createQuery(hql);
            query.setParameter("nameOfEmployee", "%" + name + "%");
            employeeList = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public List<Employee> displayEmployeesByNameAndPosition(String name, String position) {
        List<Employee> employeeList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "FROM Employee WHERE nameOfEmployee LIKE:nameOfEmployee AND position=:position";
            Query query = session.createQuery(hql);
            query.setParameter("nameOfEmployee", "%" + name + "%");
            query.setParameter("position", position);
            employeeList = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            ;
        }
        return employeeList;
    }

    public Employee updateEmployee(String name, Employee employee) {
        Employee employeeUpdated = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            String countHQL = "SELECT COUNT(*) FROM Employee WHERE nameOfEmployee=:nameOfEmployee";
            Query queryCount = session.createQuery(countHQL);
            queryCount.setParameter("nameOfEmployee", name);
            Long countResult = (Long) queryCount.uniqueResult();
            System.out.println("Count Result: " + countResult);
            if (countResult != 1) {
                return null;
            } else {
                String updateHQL = "UPDATE Employee SET position=:position, age=:age WHERE nameOfEmployee=:nameOfEmployee";
                Query queryUpdate = session.createQuery(updateHQL);
                queryUpdate.setParameter("position", employee.getPosition());
                queryUpdate.setParameter("age", employee.getAge());
                queryUpdate.setParameter("nameOfEmployee", name);
                int resultUpdate = queryUpdate.executeUpdate();
                System.out.println("Result Update: " + resultUpdate);
                if (resultUpdate == 0) {
                    return null;
                } else {
                    employeeUpdated = new Employee();
                    String hql = "FROM Employee WHERE nameOfEmployee=:nameOfEmployee";
                    Query querySelect = session.createQuery(hql);
                    querySelect.setParameter("nameOfEmployee", name);
                    List<Employee> employeeList = querySelect.list();
                    employeeUpdated = employeeList.get(0);
                }
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return employeeUpdated;
    }
}