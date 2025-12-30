package org.Service;

import jdk.jshell.execution.Util;
import org.Utility.Utility;
import org.entity.Booking;
import org.entity.Hall;
import org.entity.Seat;
import org.repository.ManageRepository;

import java.awt.print.Book;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class BookingService {

    private Utility utility ;

    //  Load Data from Json File using ManageRepository

    private ManageRepository manageRepository ;

    //  List collections to store Booking and Seat Details
    private List<Hall> hallList ;
    private List<Booking> bookingList ;
    private List<Seat> seatList ;

    private String currentUser ;

    BookingService(String user) throws IOException {
        this.manageRepository = new ManageRepository();
        this.hallList = manageRepository.getHalls();
        this.bookingList = manageRepository.getBookings();
        this.seatList = manageRepository.getSeats();
        this.currentUser = user ;
    }


    //  Book Movie Ticket
    public void bookTicket() throws IOException {

        Scanner scan = new Scanner(System.in);

        //  Show Hall Lists
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("------------------------ Below are the Mall Details --------------------------");

        for(int i = 0 ; i <hallList.size() ; i++){
            System.out.println("----- Hall Detail :- " + i+1  + "----------");
            System.out.println("Hall - " + hallList.get(i).getName());
            System.out.println("Location - " + hallList.get(i).getLocation());
            System.out.println("Movie - " + hallList.get(i).getMovieName());
            System.out.println("------------------------------------------------------------------------------");
        }

        // User Input to select Hall
        System.out.println("------------------------------------------------------------------------------");
        System.out.print("Select Hall Number from above list :- ");
        int hallNo = scan.nextInt();

        //  Check if the user input is valid or not
        if(hallNo < 1 || hallNo > hallList.size()){
            System.out.println("Invalid Input");
        }

        Hall selectedHall = hallList.get(hallNo-1) ;

        //  Show the details of Selected Hall
        System.out.println("Selected Hall - " + selectedHall.getName());
        System.out.println("Location - " + selectedHall.getLocation());
        System.out.println("Movie Name - " + selectedHall.getMovieName());
        System.out.println("Total number of Seats - " + selectedHall.getMaxSeat());

        System.out.println("------------------------------------------------------------------------------");

        //  Select the Date for which you want to book ticket - For Today or For Tomorrow
        System.out.println("Do you want to book ticket for Today or for Tomorrow ..??");
        System.out.println("1 - for Today");
        System.out.println("2 - for Tomorrow");

        //  User Input for booking Date.
        System.out.println("Enter your input :- ");
        int ticketDate = scan.nextInt();

        System.out.println("------------------------------------------------------------------------------");

        String dateTime = "";

        //  Set Date based on User input.
        if(ticketDate == 1){
            dateTime = String.valueOf(LocalDate.now());
        }
        else{
            dateTime = LocalDate.now().getYear() + "-" + LocalDate.now().getMonthValue() + "-" + (LocalDate.now().getDayOfMonth() + 1);
        }

        //  Check and show available seats
        String finalDateTime = dateTime;
        List<Seat> bookedSeatList = seatList.stream().filter(eachSeat -> {return eachSeat.getHallId().equals(selectedHall.getId()) && eachSeat.getDateTime().equals(finalDateTime) ;}).collect(Collectors.toList());

        //  Display booked Seats -
        System.out.println("Already Booked Seats are - " + bookedSeatList.size());
        List<Integer> unavailableSeatNumbers = new ArrayList<>();
        for(Seat seat : bookedSeatList){
            unavailableSeatNumbers.add(seat.getSeatNumber());
            System.out.println(seat.getSeatNumber());
        }


        //  Enter the Seat Numbers you want to book -
        System.out.println("Enter the seat numbers separated by comma (like 12,13,14) :- ");
        String seatInput = scan.next();

        //  extract each set from User input
        String [] seatInpArr = seatInput.split(",") ;

        //  Validate if User is not trying to book seat which is already booked
        for(String seatNo : seatInpArr){
            Integer expectedSeat = Integer.valueOf(seatNo) ;
            if(unavailableSeatNumbers.contains(expectedSeat)){
                System.out.println("The Seat you are trying to book is already booked");
                return ;
            };
        }

        //  If everything is fine, then proceed with contents required to create booking.
        String bookingId = Utility.getUUID();
        String bookingUser = this.currentUser ;
        String bookingHallId = selectedHall.getId();
        String bookingMovieName = selectedHall.getMovieName();


        for(String val : seatInpArr){
            String seatId = Utility.getUUID();
            String booking_Id = bookingId;
            Integer seatNo = Integer.valueOf(val);
            String seatBookingHallId = selectedHall.getId();
            String seatDate = dateTime ;

            Seat seat = new Seat(seatId, booking_Id, seatNo, seatBookingHallId, seatDate);
            seatList.add(seat);
        }

        manageRepository.bookSeat(seatList);

        //  Once the seat is booked, creating the booking details
        Booking bookingNewTicket = new Booking(bookingId, bookingHallId, bookingUser, dateTime, bookingMovieName) ;

        bookingList.add(bookingNewTicket) ;

        manageRepository.createBooking(bookingList) ;
        System.out.println("--------------------- Successfully Booked the Ticket -------------------------");
        System.out.println("------------------------------------------------------------------------------");
    }


    // Get Booked Ticket Details
    public void getBookedTicket(){
        System.out.println("Please enter the Date (YYYY-MM-DD) for which you want to check the ticket - ");

        Scanner scan = new Scanner(System.in);

        String date = scan.next();

        List<Booking> bookingDetails = bookingList.stream().filter(booking -> booking.getDateTime().equals(date)).collect(Collectors.toList());

        if(bookingDetails.isEmpty()){
            System.out.println("-------- No Booking Details Exists ------");
            return;
        }

        for(Booking booking : bookingDetails){
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("Booking Id :-" + booking.getId());
            System.out.println("Hall Id :-" + booking.getHallId());
            System.out.println("User :- " + booking.getEmail());
            System.out.println("Date :- " + booking.getDateTime());
            System.out.println("Movie :- " + booking.getMovieName());

            List<Seat> bookedSeats = seatList.stream().filter(seats -> seats.getBookingId().equals(booking.getId())).collect(Collectors.toList());
            System.out.println("Seats are - ");
            for(Seat seat : bookedSeats){
                System.out.println(seat.getSeatNumber());
            }
        }

        System.out.println("------------------------------------------------------------------------------");
    }

}
