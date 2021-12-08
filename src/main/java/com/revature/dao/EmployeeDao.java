package com.revature.dao;

import com.revature.entities.Employee;
import org.springframework.orm.hibernate5.HibernateTemplate;
import javax.transaction.Transactional;

import javax.management.Query;
import java.util.List;

public class EmployeeDao {

    private HibernateTemplate hibernateTemplate;

    public EmployeeDao() {
        super();
    }

    public EmployeeDao(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Transactional
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public int insert(Employee employee) {
        Integer integer = (Integer) this.hibernateTemplate.save(employee);
        return integer;
    }

    @Transactional
    public void update(Employee employee) {
        this.hibernateTemplate.update(employee);
    }

    @Transactional
    public void delete(int id) {
        Employee employee = this.getById(id);
        this.hibernateTemplate.delete(employee);
    }

    @Transactional
    public Employee getById(int id) {
        Employee employee = this.hibernateTemplate.get(Employee.class, id);
        return employee;
    }

    @Transactional
    public List<Employee> getAllEmployees() {
        List<Employee> employees = this.hibernateTemplate.loadAll(Employee.class);
        return employees;

    }


}
