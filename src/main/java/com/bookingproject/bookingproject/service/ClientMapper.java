package com.bookingproject.bookingproject.service;

import com.bookingproject.bookingproject.controller.CreateClientRequest;
import com.bookingproject.bookingproject.model.Client;

public class ClientMapper {
    public static Client map (CreateClientRequest clientRequest) {
        Client client = new Client();
        client.setName(clientRequest.getName());
        client.setSurname(clientRequest.getSurname());
        client.setPhone(clientRequest.getPhone());
        client.setEmail(clientRequest.getEmail());
        client.setReservations(null);
        return client;
    }
}
