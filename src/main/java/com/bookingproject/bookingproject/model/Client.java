package com.bookingproject.bookingproject.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "clients")
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String surname;
    private String email;
    private String phone;

    @OneToMany
    @JoinColumn(name = "id_client")
    private List<Reservation> reservations;
}