package com.bookingproject.bookingproject.service;

import com.bookingproject.bookingproject.model.Employee;
import com.bookingproject.bookingproject.model.EmployeeRole;
import com.bookingproject.bookingproject.repository.EmployeeRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Service
public class EmployeeManager implements InitializingBean {

    private EmployeeRepository employeeRepository;

    public EmployeeManager(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveManager(){
        Employee employee = new Employee();
        employee.setEmployeeRole(EmployeeRole.MANAGER);
        employee.setSalary(BigDecimal.valueOf(8000));
        employee.setName("Vladislav");
        employee.setLastname("Kovalenko");
        employeeRepository.save(employee);
    }
    public void saveEmployee(){
        Employee employee = new Employee();
        employee.setEmployeeRole(EmployeeRole.WORKER);
        employee.setSalary(BigDecimal.valueOf(2000));
        employee.setName("Janusz");
        employee.setLastname("Wiecejniezarobi");
        employeeRepository.save(employee);
    }
    public void saveEmployeeWithHigherSalary(){
        Employee employee = new Employee();
        employee.setEmployeeRole(EmployeeRole.WORKER);
        employee.setSalary(BigDecimal.valueOf(4000));
        employee.setName("Andrzej");
        employee.setLastname("Superbogacz");
        employeeRepository.save(employee);
    }
    public void saveCharwoman(){
        Employee employee = new Employee();
        employee.setEmployeeRole(EmployeeRole.CHARWOMAN);
        employee.setSalary(BigDecimal.valueOf(1500));
        employee.setName("Jadzia ");
        employee.setLastname("Kowalska");
        employeeRepository.save(employee);
    }

    public List <Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        saveManager();
        saveEmployee();
        saveEmployee();
        saveEmployeeWithHigherSalary();
        saveEmployeeWithHigherSalary();
        saveEmployee();
        saveCharwoman();
        saveEmployee();
    }
}
