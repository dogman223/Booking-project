package com.bookingproject.bookingproject.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "rooms")
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoomCategory roomCategory;

    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;

    private BigDecimal price;

    private String beds;

    public Room() {
    }

    public Room(RoomCategory roomCategory, RoomStatus roomStatus, BigDecimal price, String beds) {
        this.roomCategory = roomCategory;
        this.roomStatus = roomStatus;
        this.price = price;
        this.beds = beds;
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

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }
}
