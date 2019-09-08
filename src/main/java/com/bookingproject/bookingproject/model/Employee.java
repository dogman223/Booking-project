package com.bookingproject.bookingproject.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "employees")
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    @JoinColumn(name = "id_rent")
    private List<Rent> rents;

    private String name;
    private String lastname;
    @Enumerated(EnumType.STRING)
    private EmployeeRole employeeRole;
    private BigDecimal salary;

}
