package com.bookingproject.bookingproject.controller;

import com.bookingproject.bookingproject.model.RoomCategory;
import com.bookingproject.bookingproject.model.RoomStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

public class CreateRoomRequest {

    @Enumerated(EnumType.STRING)
    private RoomCategory roomCategory;

    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;

    private Boolean vacOcc;

    private BigDecimal price;

    private String beds;

    public Boolean getVacOcc() {
        return vacOcc;
    }

    public void setVacOcc(Boolean vacOcc) {
        this.vacOcc = vacOcc;
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
