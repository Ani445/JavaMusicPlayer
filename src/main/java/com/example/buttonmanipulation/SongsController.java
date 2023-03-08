package com.example.buttonmanipulation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SongsController {
   private static ArrayList<Button> buttons;
   private static ArrayList<Song> songList;
   private static Label label;

    @FXML
    static void initialize(Stage myStage) throws Exception {
        FXMLLoader fxmlLoader=new FXMLLoader(HelloController.class.getResource("songs-view.fxml"));
        ScrollPane layout1=fxmlLoader.load();
        VBox layout2=(VBox) layout1.getContent();
        initButtonArray();
        addButtons(layout2);
        //layout2.setStyle("-fx-background-color: blue;");
        setLayoutHeight(layout2);
        Scene scene=new Scene(layout1);
        //scene.setFill(Color.);
        myStage.setScene(scene);
        myStage.show();
    }
    private static void addButtons(VBox layout){
        label=new Label("Song List:");
        layout.getChildren().add(label);
        for(int i=0;i<buttons.size();i++){
            layout.getChildren().add(buttons.get(i));
        }
    }

    private static void initButtonArray(/*ArrayList<Button> b*/) throws Exception {
        buttons=new ArrayList<Button>();
//        for(int i=0;i<b.size();i++){
//            buttons.add(b.get(i));
//        }
        Database DB = new Database();

        songList = DB.getAllSongs();

          for(int i=0;i<songList.size();i++)
          {
              Button b2=new Button(songList.get(i).getName());
              b2.setMinWidth(400);
              buttons.add(b2);
              buttons.get(i).setOnAction(new EventHandler<ActionEvent>() {
                  @Override
                  public void handle(ActionEvent event) {
                      Button callingBtn=(Button)event.getSource();
                      //Stage myStage=(Stage)callingBtn.getScene().getWindow();
                      int id = 0;
                      int prevID = 0;
                      for(int i=0;i<buttons.size();i++){
                          if(buttons.get(i)==callingBtn){
                              id=i;
                              break;
                          }
                      }
                      songList.get(id).play();
                  }
              });
          }
    }
    private static void setLayoutHeight(VBox layout){
        double x=layout.getPadding().getBottom();
        double y=layout.getSpacing();
        layout.setPrefHeight(2*x+y*(buttons.size()-1)+buttons.size());
    }
//    private static void OnClickButton(ActionEvent event){
//        Button callingBtn=(Button)event.getSource();
//
//        //Stage myStage=(Stage)callingBtn.getScene().getWindow();
//        int id=0;
//        for(int i = 0; i <  buttons.size(); i++){
//            if(buttons.get(i) == callingBtn){
//                id = i;
//                break;
//            }
//        }
//        System.out.println(songList.get(id).getName());
//        songList.get(id).play();
//    }
}
