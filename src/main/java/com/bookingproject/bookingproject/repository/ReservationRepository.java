package com.bookingproject.bookingproject.repository;

import com.bookingproject.bookingproject.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

}
