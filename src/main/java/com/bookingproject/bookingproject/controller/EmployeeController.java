package com.bookingproject.bookingproject.controller;

import com.bookingproject.bookingproject.model.Employee;
import com.bookingproject.bookingproject.service.EmployeeManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping ("/employee")
public class EmployeeController {

    private EmployeeManager employeeManager;

    public EmployeeController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @GetMapping
    String employeeView () {
        return "employee";
    }
}
