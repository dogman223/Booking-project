
    package com.bookingproject.bookingproject.model;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
    @Entity(name= "rent")
    public class Rent {

    @Id
    @GeneratedValue
    private long Id;


    private long employeeId;


    private long reservationId;


    private LocalDateTime reservationDate;


    private BigDecimal finalPrice;


}

