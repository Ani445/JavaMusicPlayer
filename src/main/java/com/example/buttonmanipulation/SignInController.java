package com.example.buttonmanipulation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

//import javafx.scene.media.*;

import java.io.IOException;

public class SignInController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    private Label wrong;

    @FXML
    protected void OnClickSubmit(ActionEvent event) throws Exception {
        try {
            User user = Database.signIn(username.getText(), password.getText());
            if(user != null) user.showInfo();
            else {
                wrong.setText("Wrong Credentials!");
                wrong.setStyle("-fx-text-fill: red;");
                return;
            }
        } catch (Exception e) {
            wrong.setText("Some error occurred while login.");
            wrong.setStyle("-fx-text-fill: red;");
            return;
        }

        Node callingBtn=(Node)event.getSource();
        Stage myStage=(Stage)callingBtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        myStage.setScene(scene);
        myStage.show();
    }
    @FXML
    protected void OnClickBack(ActionEvent event) throws IOException {
        Node callingBtn = (Node)event.getSource();
        Stage myStage=(Stage)callingBtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        myStage.setScene(scene);
        myStage.show();
    }

    @FXML
    private void togglePasswordHide() {
        password.textProperty().set("Hello");
    }
}
