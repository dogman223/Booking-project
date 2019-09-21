package com.bookingproject.bookingproject.service;

import com.bookingproject.bookingproject.controller.CreateRoomRequest;
import com.bookingproject.bookingproject.model.Room;
import com.bookingproject.bookingproject.model.RoomCategory;
import com.bookingproject.bookingproject.model.RoomStatus;

public class RoomMapper {
    public static Room map (CreateRoomRequest roomRequest) {
        Room room = new Room();
        room.setBeds(roomRequest.getBeds());
        room.setRoomStatus(roomRequest.getRoomStatus());
        room.setPrice(roomRequest.getPrice());
        room.setRoomCategory(roomRequest.getRoomCategory());
        return room;
    }
}
