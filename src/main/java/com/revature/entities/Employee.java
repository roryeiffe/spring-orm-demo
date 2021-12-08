package com.revature.entities;

import javax.persistence.*;

@Entity
@Table(name="emp_table")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name="emp_id")
    private int empId;
    @Column(name="emp_name")
    private String name;
    @Column(name="emp_email")
    private String email;

    public Employee() {
        super();
    }

    public Employee(int empId, String name, String email) {
        this.empId = empId;
        this.name = name;
        this.email = email;
    }

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
