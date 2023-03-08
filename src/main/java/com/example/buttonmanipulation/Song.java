package com.example.buttonmanipulation;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Song{

    private static Media media;
    private static MediaPlayer mediaPlayer;
    private String ID;
    private String name;
    private String path;

    private String artistFirstName;
    private String artistLastName;
    boolean isChanged;

    static {
        media = null;
        mediaPlayer = null;
    }

    public Song(){
        this.ID = "";
        this.name = "";
        this.path = "";
        isChanged = false;
        artistFirstName = "";
        artistLastName = "";
    }
    public Song(String ID, String name, String path){
        this.ID = ID;
        this.name = name;
        this.path = path;
        isChanged = false;
        artistFirstName = "";
        artistLastName = "";
    }
    public void setID(String ID){
        this.ID = ID;
    }
    public void setArtistFirstName(String artistFirstName){
        if(artistFirstName != null) this.artistFirstName = artistFirstName;

    }
    public void setArtistLastName(String artistLastName){
        if(artistLastName != null) this.artistLastName = artistLastName;
    }
    public String getArtistFirstName(){
        return this.artistFirstName;
    }
    public String getArtistLastName(){
        return this.artistLastName;
    }

    public String getArtistName(){
        return this.artistFirstName + " " + artistLastName;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPath(String path){
        this.path = path;
    }
    public String getPath(){
        return this.path;
    }
    public String getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
    public void play()
    {
        //Instantiating Media class
        Media media = new Media(new File(path).toURI().toString());

        if(mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
        }

        //Instantiating MediaPlayer class
        mediaPlayer = new MediaPlayer(media);

        //by setting this property to true, the audio will be played
        mediaPlayer.play();
    }
    public void pause()
    {
        if(mediaPlayer != null) mediaPlayer.pause();
    }
    public MediaPlayer.Status getStatus()
    {
        return mediaPlayer.getStatus();
    }
    public void stop()
    {
        if(mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
        }
    }
}