package com.bookingproject.bookingproject.controller;

import com.bookingproject.bookingproject.model.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditClientRequest {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String login;
    private String password;
    private List<Reservation> reservations;
}
