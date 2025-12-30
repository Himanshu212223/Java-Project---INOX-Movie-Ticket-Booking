package org.Service;

import org.entity.Hall;
import org.entity.User;
import org.repository.ManageRepository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    //  Collection to store User db data after loading it from json file.
    public List<User> userDbData ;

    //  Defined in Persistence Package
    public ManageRepository manageRepository ;

    //  User to store active User details
    private String activeUserEmail = null;

    //  Booking Service to hadle Ticket Booking
    public BookingService bookingService ;

    //  Constructor to call the utility methods and load data on Collections

    public UserService() throws IOException {
        this.manageRepository = new ManageRepository();
        this.userDbData = manageRepository.getUsers();
//        System.out.println("Successfully loaded the Data");
    }


    //  Getter and Setter for Active User
    public void setActiveUser(String email){
        this.activeUserEmail = email;
    }

    public String getActiveUser(){
        return this.activeUserEmail ;
    }



    //  Method to create new User
    public String createUserAccount(String email, String password, String name) throws IOException {
        //  Check if the email, password, name is not empty
        if(email.isEmpty() || password.isEmpty() || name.isEmpty()){
            return "Invalid email or password or name";
        }

        //  Regex expression to check if email is valid.
        final String emailPattern = "[([a-z]*)([A-Z]*)]+[0-9]*[@]([a-z]{1,}[A-Z]*)[.]([a-z]{1,}[A-Z]*)" ;

        if(!email.matches(emailPattern)){
            return "Invalid Email" ;
        }

        //  check if User is present on the User list.
        for(User user : userDbData){
            if(user.getEmail().equals(email)){
                return "User already exists.";
            }
        }

        User newUser = new User(email, password, name);
        userDbData.add(newUser);
        manageRepository.updateUserList(userDbData);
        return "Successfully created the Account" ;
    }


    //  Login User
    public String loginUser(String email, String password){
        List<User> identifiedUser = userDbData.stream().filter(user -> {
            return user.getEmail().equals(email) && user.getPassword().equals(password);
        }).collect(Collectors.toList());

        if(identifiedUser.size() == 0){
            System.out.println("Invalid Credentials");
            return "Invalid Credentials";
        }

        System.out.println("Login Successfully");
        this.setActiveUser(identifiedUser.getFirst().getEmail());
        return "Login Successfully" ;
    }


    //  Logout User
    public void logoutUser(){
        this.setActiveUser(null);
        System.out.println("Logout Successfully");
    }


    //  Book Ticket
    public void bookMovieTicket() throws IOException{
        if(this.activeUserEmail == null){
            System.out.println("Please Login First");
            return ;
        }

        bookingService = new BookingService(this.getActiveUser());
        bookingService.bookTicket();
        bookingService = null ;
    }

    //  Booked Ticket Details
    public void bookedTicketDetails() throws IOException{
        if(this.activeUserEmail == null){
            System.out.println("Please Login First");
            return;
        }

        bookingService = new BookingService(this.getActiveUser());
        bookingService.getBookedTicket();
        bookingService = null ;

    }

}
