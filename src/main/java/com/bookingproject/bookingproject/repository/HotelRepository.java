package com.bookingproject.bookingproject.repository;

import com.bookingproject.bookingproject.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
