package com.example.buttonmanipulation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
//import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ChangePwdController {
    @FXML
    private TextField newPwd;
    @FXML
    private TextField currPwd;
    @FXML
    private TextField confirmPwd;
    @FXML
    protected void onSaveBtnClicked()  {
        String num2 = newPwd.getText();
        String num1 = currPwd.getText();
        String num3 = confirmPwd.getText();


        if (!Objects.equals(num3, num2)) {
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("Alert");
            alert2.setHeaderText("Warning!");
            alert2.setContentText("Passwords don't match!");
            alert2.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        } else if (!Objects.equals(num1, Database.getCurrentUser().getPassword())) {
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("Alert");
            alert2.setHeaderText("Warning!");
            alert2.setContentText("Incorrect current password!");
            alert2.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Password Updated");
            alert.setHeaderText("Well done!");
            alert.setContentText("Password is updated.");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });

            try {
                User user = new User(Database.getCurrentUser());
                user.setPassword(num2);
                Database.updateCurrentUserInfo(user);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    @FXML
    protected void onBackButton(ActionEvent event) throws IOException {
        Node callButton=(Node)event.getSource();
        Stage myStage= (Stage) callButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EditMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        myStage.setScene(scene);
        myStage.show();
    }
}


