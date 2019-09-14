package com.bookingproject.bookingproject.controller;

import com.bookingproject.bookingproject.model.Reservation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CreateClientRequest {

    private String name;
    private String surname;
    private String email;
    private String phone;
    private String login;
    private String password;

    private List<Reservation> reservations;
}
