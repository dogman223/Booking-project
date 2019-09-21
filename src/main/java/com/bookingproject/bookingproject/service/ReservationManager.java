package com.bookingproject.bookingproject.service;

import com.bookingproject.bookingproject.controller.CreateReservationRequest;
import com.bookingproject.bookingproject.model.Reservation;
import com.bookingproject.bookingproject.model.Room;
import com.bookingproject.bookingproject.repository.ReservationRepository;
import com.bookingproject.bookingproject.repository.RoomRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationManager implements InitializingBean {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        Reservation reservation = new Reservation();
        reservation.setArrival(LocalDate.of(2019, 9, 17));
        reservation.setDeparture(LocalDate.of(2019, 9, 18));
        reservation.setGuestsNumber(2);
        reservation.setRoom(roomRepository.getOne(17L));
        reservationRepository.save(reservation);
    }

    public Reservation saveReservation (CreateReservationRequest reservationRequest) {
        Reservation reservation = ReservationMapper.map(reservationRequest);
        reservationRepository.save(reservation);
        return reservation;
    }

    public List<Room> findAvailableRoomsByDates (LocalDate arrival, LocalDate departure) {
        List<Reservation> allReservations = reservationRepository.findAll();
        List<Room> allRooms = roomRepository.findAll();
        List<Reservation> reservationsWithinDates = new ArrayList<>();
        for (Reservation reservation: allReservations) {
            if (reservation.getArrival().isAfter(departure)
                    || reservation.getDeparture().isBefore(arrival)
                    || reservation.getArrival().isEqual(arrival)) {
                reservationsWithinDates.add(reservation);
            }
        }
        for (Reservation reservation: reservationsWithinDates) {
            Room roomInReservation = reservation.getRoom();
            allRooms.remove(roomInReservation);
        }
        return allRooms;
    }
}
