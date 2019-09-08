package com.bookingproject.bookingproject.model;

import javax.persistence.*;

@Entity(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue
    private long id;

    private String name;

}
