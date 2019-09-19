package com.bookingproject.bookingproject.controller;

import com.bookingproject.bookingproject.model.RoomCategory;
import com.bookingproject.bookingproject.model.RoomStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;


@Getter
@Setter
public class EditRoomRequest {

    private RoomCategory roomCategory;

    private RoomStatus roomStatus;

    private Boolean vacOcc;

    private BigDecimal price;

}
