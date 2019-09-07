package com.bookingproject.bookingproject.service;

import com.bookingproject.bookingproject.model.Room;
import com.bookingproject.bookingproject.model.RoomCategory;
import com.bookingproject.bookingproject.repository.RoomRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoomManager {
    private RoomRepository roomRepository;

    public RoomManager(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void saveRoom() {
        Room room = new Room();
        room.setRoomCategory(RoomCategory.DELUXE);
        roomRepository.save(room);
    }

}
