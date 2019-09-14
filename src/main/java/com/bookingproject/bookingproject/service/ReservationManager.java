package com.bookingproject.bookingproject.service;

import com.bookingproject.bookingproject.model.Reservation;
import com.bookingproject.bookingproject.repository.ReservationRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationManager implements InitializingBean {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
