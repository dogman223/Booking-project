package com.bookingproject.bookingproject.service;

import com.bookingproject.bookingproject.model.Employee;
import com.bookingproject.bookingproject.model.EmployeeRole;
import com.bookingproject.bookingproject.repository.EmployeeRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeManager implements InitializingBean {

    private EmployeeRepository employeeRepository;

    public EmployeeManager(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveEmployee(){
        Employee employee = new Employee();
        employee.setEmployeeRole(EmployeeRole.MANAGER);
        employee.setEarnings(BigDecimal.valueOf(8000));
        employee.setName("Vladislav");
        employee.setLastname("Kovalenko");
        employeeRepository.save(employee);
    }

    public List <Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        saveEmployee();
    }
}
