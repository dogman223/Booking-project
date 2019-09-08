package com.bookingproject.bookingproject.controller;

import com.bookingproject.bookingproject.service.EmployeeManager;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
        private EmployeeManager employeeManager;

    public EmployeeController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }
}
