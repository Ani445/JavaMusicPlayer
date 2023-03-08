package com.example.buttonmanipulation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    protected void onSongsButtonClick(ActionEvent event) throws Exception {
        Node callingBtn=(Node)event.getSource();
        Stage myStage=(Stage)callingBtn.getScene().getWindow();
        SongsController.initialize(myStage);
//        FXMLLoader fxmlLoader=new FXMLLoader(HelloController.class.getResource("songs-view.fxml"));
//        Button b=new Button("Hi");
//        VBox layout1=new VBox();
//        layout1.getChildren().add(b);
//        Scene scene=new Scene(fxmlLoader.load(),500,500);
//        myStage.setScene(scene);
//        myStage.show();
    }
}