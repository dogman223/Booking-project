package com.bookingproject.bookingproject.controller;

import com.bookingproject.bookingproject.model.RoomCategory;
import com.bookingproject.bookingproject.model.RoomStatus;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
@Data
@NoArgsConstructor
public class CreateRoomRequest {

    @Enumerated(EnumType.STRING)
    private RoomCategory roomCategory;

    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;

    private Boolean vacOcc;

    private BigDecimal price;

    private String beds;

}
