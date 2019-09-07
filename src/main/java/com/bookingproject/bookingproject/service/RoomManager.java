package com.bookingproject.bookingproject.service;

import com.bookingproject.bookingproject.model.Room;
import com.bookingproject.bookingproject.model.RoomCategory;
import com.bookingproject.bookingproject.model.RoomStatus;
import com.bookingproject.bookingproject.repository.RoomRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RoomManager implements InitializingBean {
    private RoomRepository roomRepository;

    public RoomManager(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void saveRoom() {
        Room room = new Room();
        room.setRoomCategory(RoomCategory.DELUXE);
        room.setPrice(BigDecimal.valueOf(299.99));
        room.setBeds("king");
        room.setRoomStatus(RoomStatus.CLEAN);
        roomRepository.save(room);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        saveRoom();
    }

    public List<Room> getRooms() {
        return roomRepository.findAll();
    }
}
