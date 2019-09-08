package com.bookingproject.bookingproject.controller;

import com.bookingproject.bookingproject.model.Room;
import com.bookingproject.bookingproject.service.RoomManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private RoomManager roomManager;

    public RoomController(RoomManager roomManager) { this.roomManager = roomManager;
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms () {
        List<Room> rooms = roomManager.getRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
}
