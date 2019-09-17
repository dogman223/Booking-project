package com.bookingproject.bookingproject.service;

import com.bookingproject.bookingproject.controller.CreateReservationRequest;
import com.bookingproject.bookingproject.model.Reservation;
import com.bookingproject.bookingproject.model.ReservationStatus;

public class ReservationMapper {
    public static Reservation map(CreateReservationRequest createReservationRequest) {
        Reservation reservation = new Reservation();
        reservation.setGuestsNumber(2);
        reservation.setRoom(createReservationRequest.getRoom());
        reservation.setDeparture(createReservationRequest.getDeparture());
        reservation.setArrival(createReservationRequest.getArrival());
        reservation.setStatus(ReservationStatus.PROVISIONAL);
        reservation.setHotel(null);
        reservation.setRents(null);
        return reservation;
    }
}
