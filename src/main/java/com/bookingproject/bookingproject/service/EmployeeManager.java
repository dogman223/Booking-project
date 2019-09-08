package com.bookingproject.bookingproject.service;

import com.bookingproject.bookingproject.model.Employee;
import com.bookingproject.bookingproject.repository.EmployeeRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EmployeeManager implements InitializingBean {
    private EmployeeRepository employeeRepository;

    public EmployeeManager(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveEmployee() {
        Employee employee = new Employee();
        employee.setName("Adam");
        employee.setLastname("Nowak");
        employee.setRole("Manager");
        employee.setSalary(BigDecimal.valueOf(2000));
        employeeRepository.save(employee);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        saveEmployee();
    }

}
