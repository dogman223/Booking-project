package com.bookingproject.bookingproject.repository;

import com.bookingproject.bookingproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

        List<Employee> findAllById (Long id);

}
