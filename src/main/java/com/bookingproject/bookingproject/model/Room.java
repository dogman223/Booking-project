package com.bookingproject.bookingproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity(name = "rooms")
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoomCategory roomCategory;

    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;

    private Boolean vacOcc;

    private BigDecimal price;

    private String beds;


}