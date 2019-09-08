package com.bookingproject.bookingproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name = "employees")
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String lastname;
    private String role;
    private BigDecimal salary;

    public Employee() {
    }

    public Employee(String name, String lastname, String role, BigDecimal salary) {
        this.name = name;
        this.lastname = lastname;
        this.role = role;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
