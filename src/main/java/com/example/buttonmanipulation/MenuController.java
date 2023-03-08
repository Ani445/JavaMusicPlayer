package com.example.buttonmanipulation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    @FXML
    protected void onclickSongList(ActionEvent event) throws Exception {
        Node callingBtn=(Node)event.getSource();
        Stage myStage=(Stage)callingBtn.getScene().getWindow();

        SongsController.initialize(myStage);

//        FXMLLoader fxmlLoader = new FXMLLoader(SongsController.class.getResource("songs-view.fxml"));
//
//        Scene scene = new Scene(fxmlLoader.load());
//        myStage.setScene(scene);
//        myStage.show();
    }
    @FXML
    protected void onClickEditUser(ActionEvent event) throws IOException {
        Node callingBtn = (Node)event.getSource();
        Stage myStage = (Stage)callingBtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("EditMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        myStage.setScene(scene);
        myStage.show();
    }

    @FXML
    protected void onclickBack(ActionEvent event) throws IOException {
        Node callingBtn=(Node)event.getSource();
        Stage myStage=(Stage)callingBtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        myStage.setScene(scene);
        myStage.show();
    }
}
