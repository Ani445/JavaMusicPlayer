package com.example.buttonmanipulation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

public class SignUpController {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;

    @FXML
    private Label success;
    @FXML
    protected void OnClickSubmit(ActionEvent event) throws IOException {
        try {
            User user = new User(username.getText(), password.getText());
            if(username.getText().equals("") || password.getText().equals("")) {
                success.setText("You must give username and password");
                success.setStyle("-fx-text-fill: red;");
                return;
            }
            user.setFirstName(firstName.getText());
            user.setLastName(lastName.getText());
            Database.signUp(user);
            System.out.println("Registration Successful");
        } catch (SQLIntegrityConstraintViolationException intExc) {
            success.setText("Username Taken");
            success.setStyle("-fx-text-fill: red;");
            return;
        } catch (Exception e) {
            success.setText("Some error occurred while sign-up.");
            success.setStyle("-fx-text-fill: red;");
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
        Node callingBtn=(Node)event.getSource();
        Stage myStage=(Stage)callingBtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        myStage.setScene(scene);
        myStage.show();
    }
}
