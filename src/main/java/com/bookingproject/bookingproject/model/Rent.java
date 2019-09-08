
    package com.bookingproject.bookingproject.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

    @Entity(name= "rent")
    public class Rent {

        @Id
        @GeneratedValue
        private long Id;



        private long employeeId;


        private long reservationId;


        private LocalDateTime reservationDate;



        private BigDecimal finalPrice;


        public Rent(long employeeId, long reservationId, LocalDateTime reservationDate, BigDecimal finalPrice) {
            this.employeeId = employeeId;
            this.reservationId = reservationId;
            this.reservationDate = reservationDate;
            this.finalPrice = finalPrice;
        }

        public Rent() {
        }

        public long getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(long employeeId) {
            this.employeeId = employeeId;
        }

        public long getReservationId() {
            return reservationId;
        }

        public void setReservationId(long reservationId) {
            this.reservationId = reservationId;
        }

        public LocalDateTime getReservationDate() {
            return reservationDate;
        }

        public void setReservationDate(LocalDateTime reservationDate) {
            this.reservationDate = reservationDate;
        }

        public BigDecimal getFinalPrice() {
            return finalPrice;
        }

        public void setFinalPrice(BigDecimal finalPrice) {
            this.finalPrice = finalPrice;
        }
    }


