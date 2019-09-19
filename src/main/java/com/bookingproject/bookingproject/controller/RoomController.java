package com.bookingproject.bookingproject.controller;

import com.bookingproject.bookingproject.model.Room;
import com.bookingproject.bookingproject.service.RoomManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/editroom")
    String editRoomView(){return "editroom";}

    @GetMapping("/editroom/{id}")
    String editEmployeeProfileView (@PathVariable Long id , Model model) {
        Room foundRoom = roomManager.findById(id);
        model.addAttribute("room", foundRoom);
        return "editroom";
    }

    @PostMapping("/editroom/{asdf}")
    String editRoom(@PathVariable("asdf") Long asdf, EditRoomRequest editRoomRequest) {
        roomManager.editRoom(asdf, editRoomRequest);
        return "redirect:/employee/rooms";
    }
}
