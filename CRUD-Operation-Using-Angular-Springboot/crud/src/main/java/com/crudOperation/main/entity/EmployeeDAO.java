package com.crudOperation.main.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees_db")
public class EmployeeDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empName;
    private int salary;
    private String address;
    private String job_profile;

    public EmployeeDAO(){}

    public EmployeeDAO(Long id, String empName, int salary, String address, String job_profile) {
        this.id = id;
        this.empName = empName;
        this.salary = salary;
        this.address = address;
        this.job_profile = job_profile;
    }

    public String getJob_profile() {
        return job_profile;
    }
    public void setJobProfile(String job_profile){
        this.job_profile = job_profile;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
