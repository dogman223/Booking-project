package com.bookingproject.bookingproject.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class UpdateRoomRequest {


    private RoomStatus roomStatus;

    private Boolean vacOcc;

    public Boolean getVacOcc() {
        return vacOcc;
    }

    public void setVacOcc(Boolean vacOcc) {
        this.vacOcc = vacOcc;
    }
}
