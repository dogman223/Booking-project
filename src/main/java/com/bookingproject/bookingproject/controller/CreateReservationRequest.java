package com.bookingproject.bookingproject.controller;

import com.bookingproject.bookingproject.model.Hotel;
import com.bookingproject.bookingproject.model.Rent;
import com.bookingproject.bookingproject.model.ReservationStatus;
import com.bookingproject.bookingproject.model.Room;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CreateReservationRequest {
    private LocalDate arrival;
    private LocalDate departure;
    private Integer guestsNumber;
    private ReservationStatus status;
    private Room room;
    private List<Rent> rents;
    private Hotel hotel;
}
