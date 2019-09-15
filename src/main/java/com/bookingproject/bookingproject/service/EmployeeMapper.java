package com.bookingproject.bookingproject.service;

import com.bookingproject.bookingproject.controller.CreateEmployeeRequest;
import com.bookingproject.bookingproject.model.Employee;

public class EmployeeMapper {

    public static Employee map(CreateEmployeeRequest employeeRequest) {



        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setSurname(employeeRequest.getSurname());
        employee.setEmployeeRole(employeeRequest.getEmployeeRole());
        employee.setSalary(employeeRequest.getSalary());

        return employee;

    }


}
