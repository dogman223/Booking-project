package com.bookingproject.bookingproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue
    private long reservation_ID;

    private long hotel_ID;
    private long client_ID;

    private long room_ID;
    private LocalDateTime arrival;
    private LocalDateTime departure;


}
