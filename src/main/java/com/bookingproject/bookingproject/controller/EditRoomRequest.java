package com.bookingproject.bookingproject.controller;

import com.bookingproject.bookingproject.model.RoomCategory;
import com.bookingproject.bookingproject.model.RoomStatus;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class EditRoomRequest {

    private RoomCategory roomCategory;

    private RoomStatus roomStatus;

    private Boolean vacOcc;

    private BigDecimal price;

}
