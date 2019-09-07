package com.bookingproject.bookingproject.model;

import javax.persistence.*;

@Entity(name = "rooms")
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoomCategory roomCategory;

    public Room() {
    }

    public Room(RoomCategory roomCategory) {
        this.roomCategory = roomCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomCategory getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(RoomCategory roomCategory) {
        this.roomCategory = roomCategory;
    }
}
