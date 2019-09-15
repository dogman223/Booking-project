package com.bookingproject.bookingproject.controller;

import com.bookingproject.bookingproject.model.Room;
import com.bookingproject.bookingproject.service.RoomManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private RoomManager roomManager;

    public RoomController(RoomManager roomManager) {
        this.roomManager = roomManager;
    }

    public ResponseEntity<List<Room>> getAllRooms () {
        List<Room> rooms = roomManager.getRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping
    String roomView (Model model) {
        List<Room> rooms = roomManager.getRooms();
        model.addAttribute("room", rooms);
        return "rooms";
    }

    @GetMapping("/add")
    String addView () {
        return "addroom";
    }

}
