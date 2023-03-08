package com.example.buttonmanipulation;

import java.util.Date;

public class User{
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Date joinDate;
    public User(){
        this.username = "";
        this.firstName = "";
        this.lastName = "";
        this.password = "";
    }
    public User(User user){
        this.username = user.username;
        this.password = user.password;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
    }
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.firstName = "";
        this.lastName = "";
    }
    public void setFirstName(String firstName){
        if(firstName != null) this.firstName = firstName;
    }
    public void setLastName(String lastName){
        if(lastName != null) this.lastName = lastName;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getName(){
        return this.firstName + " " + this.lastName;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    void setJoinDate(Date date) {
        this.joinDate = date;
    }
//     <delete after>
     void showInfo() {
        System.out.println("Username: " + this.username);
        System.out.println("Name: " + this.getName());
        System.out.println("Joined since: " + this.joinDate);
    }
//     <\delete after>
}