package org.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.entity.Booking;
import org.entity.Hall;
import org.entity.Seat;
import org.entity.User;

import java.io.*;
import java.util.List;
import java.util.Optional;

public class ManageRepository {

    private final String DirectoryPath = System.getProperty("user.dir") + "\\Data\\" ;

    private final String UserJsonPath = DirectoryPath + "User.json";
    private final String HallJsonPath = DirectoryPath + "Hall.json";
    private final String BookingJsonPath = DirectoryPath + "Booking.json";
    private final String SeatJsonPath = DirectoryPath + "Seat.json";


    //  Method to get User Detail list from JSON
    public List<User> getUsers () throws IOException {
        //  FileInputStream to read the file.
        InputStream inpStream = new FileInputStream(UserJsonPath) ;
        //  Object Mapper to map the json data to class object.
        ObjectMapper objMapper = new ObjectMapper() ;
        //  optional to read the data else null
        Optional<List<User>> optionalUserList = Optional.ofNullable(objMapper.readValue(inpStream, new TypeReference<List<User>>(){}));

        List<User> userList = optionalUserList.orElse(null) ;

        objMapper = null ;
        inpStream = null ;

        return userList ;
    }


    //  Method to get Hall Detail List from JSON
    public List<Hall> getHalls () throws IOException {
        InputStream inpStream = new FileInputStream(HallJsonPath);

        ObjectMapper objMapper = new ObjectMapper();

        Optional<List<Hall>> optionalHallList = Optional.ofNullable(objMapper.readValue(inpStream, new TypeReference<List<Hall>>(){}));

        List<Hall> hallList = optionalHallList.orElse(null) ;

        objMapper = null ;
        inpStream = null ;

        return hallList ;
    }

    //  Method to get Booking Detail List fron JSON
    public List<Booking> getBookings () throws IOException {
        InputStream inpStream = new FileInputStream(BookingJsonPath);
        ObjectMapper objMapper = new ObjectMapper() ;

        Optional<List<Booking>> optionalBookings = Optional.ofNullable(objMapper.readValue(inpStream, new TypeReference<List<Booking>>(){}));

        List<Booking> bookingList = optionalBookings.orElse(null);

        objMapper = null ;
        inpStream = null ;
        return bookingList ;
    }


    //  Method to get Seat Detail List from JSON
    public List<Seat> getSeats() throws IOException {
        InputStream inpStream = new FileInputStream(SeatJsonPath);
        ObjectMapper objMapper = new ObjectMapper();

        Optional<List<Seat>> optionalSeats = Optional.ofNullable(objMapper.readValue(inpStream, new TypeReference<List<Seat>>(){}));

        List<Seat> seatList = optionalSeats.orElse(null) ;
        objMapper = null ;
        inpStream = null ;

        return seatList ;
    }




    //  Method to Update the Data on UserJson file
    public String updateUserList(List<User> userList) throws IOException {
        OutputStream outStream = new FileOutputStream(UserJsonPath);

        ObjectMapper objMapper = new ObjectMapper();

        objMapper.writeValue(outStream, userList);
        objMapper = null ;
        outStream = null ;
        return "Successfully updated the User Data List";
    }




    //  Method to Update the Hall on HallJson file
    public String updateHallList(List<Hall> hallList) throws IOException {
        OutputStream outStream = new FileOutputStream(HallJsonPath);
        ObjectMapper objMapper = new ObjectMapper();
        objMapper.writeValue(outStream, hallList);
        objMapper = null ;
        outStream = null ;
        return "Successfully update the Hall Data List" ;
    }


    //  Method to Book movie tickets
    public Boolean createBooking(List<Booking> newBookingList) throws IOException {
        OutputStream outStream = new FileOutputStream(BookingJsonPath);
        ObjectMapper objMapper = new ObjectMapper();

        objMapper.writeValue(outStream, newBookingList);

        objMapper = null ;
        outStream = null ;

        return true;
    }


    //  Method to Book Seat
    public Boolean bookSeat(List<Seat> newSeatList) throws IOException {
        OutputStream outputStream = new FileOutputStream(SeatJsonPath);
        ObjectMapper objMapper = new ObjectMapper();

        objMapper.writeValue(outputStream, newSeatList);

        objMapper = null ;
        outputStream = null ;

        return true;
    }
}
