package com.bookingproject.bookingproject.controller;

import com.bookingproject.bookingproject.model.Client;
import com.bookingproject.bookingproject.model.Reservation;
import com.bookingproject.bookingproject.service.ClientManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {

    private ClientManager clientManager;

    public ClientController(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    @GetMapping
    String clientView () {
        return "client";
    }

    @GetMapping("/new_profile")
    String createProfileView () {
        return "new_profile";
    }

    @PostMapping
    String createProfile (CreateClientRequest clientRequest) {
        clientManager.saveClient(clientRequest);
        return "redirect:client";
    }

    @GetMapping("/new_reservation")
    String newResView () {
        return "new_reservation";
    }

}
