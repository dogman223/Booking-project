package com.bookingproject.bookingproject.controller;

import com.bookingproject.bookingproject.service.ClientManager;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    private ClientManager clientManager;

    public ClientController(ClientManager clientManager) {
        this.clientManager = clientManager;
    }
}
