package com.bookingproject.bookingproject.controller;

import com.bookingproject.bookingproject.model.EmployeeRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
public class CreateEmployeeRequest {
    private String name;
    private String surname;
    private EmployeeRole employeeRole;
    private BigDecimal salary;
}
