package com.bookingproject.bookingproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn (name = "id_hotel")
    private Hotel hotel;

    @OneToMany
    @JoinColumn(name = "id_rent")
    private List<Rent> rents;

    @ManyToOne
    @JoinColumn (name = "id_room")
    private Room room;

    private LocalDateTime arrival;
    private LocalDateTime departure;
    private Integer guestsNumber;
    private ReservationStatus status;

}
