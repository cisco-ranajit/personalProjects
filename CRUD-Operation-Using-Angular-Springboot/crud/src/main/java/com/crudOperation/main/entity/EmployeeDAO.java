package com.crudOperation.main.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees_db")
public class EmployeeDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String empName;
    private int salary;
    private String address;

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
