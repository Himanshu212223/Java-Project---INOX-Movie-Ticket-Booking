package org.entity;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;

public class Booking {
     private String id; //  UUID
     private String hallId;
     private String email ;
     private String dateTime;
     private String movieName;

     public Booking () {}

    public Booking(String id, String hallId, String email, String dateTime, String movieName){
         this.id = id ;
         this.hallId = hallId ;
         this.email = email;
         this.dateTime = dateTime ;
         this.movieName = movieName ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail (){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movie_name) {
        this.movieName = movie_name;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(String date_time) {
        this.dateTime = date_time;
    }

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hall_id) {
        this.hallId = hall_id;
    }
}
