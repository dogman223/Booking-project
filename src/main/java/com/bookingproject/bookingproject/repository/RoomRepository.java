package com.bookingproject.bookingproject.repository;

import com.bookingproject.bookingproject.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {

    List<Room> findRoomsById (Long id);
}
