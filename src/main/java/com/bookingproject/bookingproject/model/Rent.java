
    package com.bookingproject.bookingproject.model;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name= "rent")
public class Rent {

    @Id
    @GeneratedValue
    private Long Id;

    @ManyToOne
    @JoinColumn (name = "id_employee")
    private Employee employee;

    private LocalDateTime reservationDate;
    private BigDecimal totalPrice;
    private BigDecimal finalPrice;

}

