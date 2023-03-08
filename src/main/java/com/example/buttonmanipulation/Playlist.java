package com.example.buttonmanipulation;

public class Playlist{
    private String ID;
    private String name;

    public Playlist(){
        this.ID = "";
        this.name = "";
    }
    public Playlist(String ID, String name){
        this.ID = ID;
        this.name = name;
    }
    public void setID(String ID){
        this.ID = ID;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
}