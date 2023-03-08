package com.example.buttonmanipulation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EditNameController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField secondName;
//    @FXML
//    private Label res;
//    @FXML
//    protected void onCalculateDifBtnClicked(){
//        String num1=firstName.getText();
//        String num2=secondName.getText();
//
//    }
    @FXML
    protected void saveButton() {
       String num1 = firstName.getText();
       String num2 = secondName.getText();

        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Information Updated");
        alert1.setHeaderText("Well Done!");
        alert1.setContentText("Information is saved!");
        alert1.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
        try {
            User user = new User(Database.getCurrentUser());
            user.setFirstName(num1);
            user.setLastName(num2);
            Database.updateCurrentUserInfo(user);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    protected void onbackButton(ActionEvent event) throws IOException {
        Node callButton=(Node)event.getSource();
        Stage myStage= (Stage) callButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EditMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Stage myStage=new Stage();
        myStage.setScene(scene);
        myStage.show();
    }

    public void initialize() {
        firstName.setText(Database.getCurrentUser().getFirstName());
        secondName.setText(Database.getCurrentUser().getLastName());
    }
}
