package com.bookingproject.bookingproject.service;


import com.bookingproject.bookingproject.controller.CreateEmployeeRequest;

import com.bookingproject.bookingproject.exception.EmployeeNotFoundException;
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

    public void saveManager(){
        Employee employee = new Employee();
        employee.setEmployeeRole(EmployeeRole.MANAGER);
        employee.setSalary(BigDecimal.valueOf(8000));
        employee.setName("Vladislav");
        employee.setSurname("Kovalenko");
        employeeRepository.save(employee);
    }
    public void saveEmployee(){
        Employee employee = new Employee();
        employee.setEmployeeRole(EmployeeRole.WORKER);
        employee.setSalary(BigDecimal.valueOf(2000));
        employee.setName("Janusz");
        employee.setSurname("Wiecejniezarobi");
        employeeRepository.save(employee);
    }
    public void saveEmployeeWithHigherSalary(){
        Employee employee = new Employee();
        employee.setEmployeeRole(EmployeeRole.WORKER);
        employee.setSalary(BigDecimal.valueOf(4000));
        employee.setName("Andrzej");
        employee.setSurname("Superbogacz");
        employeeRepository.save(employee);
    }
    public void saveCharwoman(){
        Employee employee = new Employee();
        employee.setEmployeeRole(EmployeeRole.CHARWOMAN);
        employee.setSalary(BigDecimal.valueOf(1500));
        employee.setName("Jadzia ");
        employee.setSurname("Kowalska");
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

    public void saveEmployee(CreateEmployeeRequest employeeRequest) {
        Employee employee = EmployeeMapper.map(employeeRequest);
        employeeRepository.save(employee);
    }


    public void deleteEmployee (Long id) {
        employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        employeeRepository.deleteById(id);

    }

    public Employee findEmployeeById (Long id) {
        Employee employee = employeeRepository.getOne(id);
        return employee;
    }



    public void editEmployee(Long id, CreateEmployeeRequest createEmployeeRequest) {
        Employee editedEmployee = employeeRepository.getOne(id);
        editedEmployee.setName(createEmployeeRequest.getName());
        editedEmployee.setSurname(createEmployeeRequest.getSurname());
        editedEmployee.setEmployeeRole(createEmployeeRequest.getEmployeeRole());
        editedEmployee.setSalary(createEmployeeRequest.getSalary());
        employeeRepository.save(editedEmployee);
    }



}

