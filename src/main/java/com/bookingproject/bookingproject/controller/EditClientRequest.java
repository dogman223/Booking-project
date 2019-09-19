package com.bookingproject.bookingproject.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditClientRequest {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String login;
    private String password;
}
