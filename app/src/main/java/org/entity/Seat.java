package org.entity;

import java.util.Date;

public class Seat {
    private String id;
    private String bookingId;
    private Integer seatNumber;
    private String hallId;
    private String dateTime ;

    public Seat(){}

    public Seat(String id, String bookingId, Integer seatNumber, String hallId, String dateTime){
        this.id = id ;
        this.bookingId = bookingId ;
        this.seatNumber = seatNumber ;
        this.hallId = hallId ;
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getSeatNumber() {
        return this.seatNumber;
    }

    public void setSeatNumber(Integer seatDetails) {
        this.seatNumber = seatDetails;
    }

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
