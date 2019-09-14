package com.bookingproject.bookingproject.model;

import com.bookingproject.bookingproject.exception.RoomNotFoundException;
import com.bookingproject.bookingproject.repository.RoomRepository;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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


