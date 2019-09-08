package com.bookingproject.bookingproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@Entity(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    private String name;

}
