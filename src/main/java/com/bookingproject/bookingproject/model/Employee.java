package com.bookingproject.bookingproject.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "employees")
public class Employee {

    public Employee() {
    }

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String lastname;

    @Enumerated(EnumType.STRING)
    private EmployeeRole employeeRole;

    private BigDecimal earnings;

    public Employee(String name, String lastname, EmployeeRole employeeRole, BigDecimal earnings) {
        this.name = name;
        this.lastname = lastname;
        this.employeeRole = employeeRole;
        this.earnings = earnings;
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

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) { this.employeeRole = employeeRole; }

    public BigDecimal getEarnings() {
        return earnings;
    }

    public void setEarnings(BigDecimal earnings) {
        this.earnings = earnings;
    }
}
