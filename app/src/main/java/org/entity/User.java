package org.entity;

public class User {

    private String email ;
    private String password ;
    private String name ;

    public User(){}

    public User(String email, String password, String name){
        this.email = email ;
        this.password = password ;
        this.name = name ;
    }

    //  Getter - Setter
    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email ;
    }

    public String getPassword(){
        return this.password ;
    }

    public void setPassword(String password){
        this.password = password;
    }


    public String getName(){
        return this.name ;
    }

    public void setName(String name){
        this.name = name;
    }

//    public String getUser(){
//        return "name : " + this.name + ", email : " + this.email + ", password : " + this.password ;
//    }


}
