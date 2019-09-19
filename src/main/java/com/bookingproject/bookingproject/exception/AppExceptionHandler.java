package com.bookingproject.bookingproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity handleClientNotFoundException() {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity handleRoomNotFoundException() {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ReservationNotFoundException.class)
        public ResponseEntity handleReservationNotFoundException() {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
        public ResponseEntity handleEmployeeNotFoundException(){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}