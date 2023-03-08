package com.example.buttonmanipulation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    protected void OnClickSignIn(ActionEvent event) throws IOException {
        Node callingBtn=(Node)event.getSource();
        Stage myStage=(Stage)callingBtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Sign-in.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        myStage.setScene(scene);
        myStage.show();
    }
    @FXML
    protected void OnClickSignUp(ActionEvent event) throws IOException {
        Node callingBtn=(Node)event.getSource();
        Stage myStage=(Stage)callingBtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Sign-up.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        myStage.setScene(scene);
        myStage.show();
    }
}