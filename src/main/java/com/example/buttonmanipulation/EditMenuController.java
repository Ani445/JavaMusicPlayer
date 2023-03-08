package com.example.buttonmanipulation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EditMenuController {

    @FXML
    protected void onChangeNameClicked(ActionEvent event) throws IOException {
        Node callButton=(Node)event.getSource();
        Stage myStage= (Stage) callButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EditName.fxml"));

        Parent root = fxmlLoader.load();

        EditNameController editNameController = fxmlLoader.getController();
        editNameController.initialize();

        Scene scene = new Scene(root);
        //Stage myStage=new Stage();
        myStage.setScene(scene);
        myStage.show();
    }
    @FXML
    protected void onChangePwdClicked(ActionEvent event) throws IOException {
        Node callButton=(Node)event.getSource();
        Stage myStage= (Stage) callButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ChangePwd.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Stage myStage=new Stage();
        myStage.setScene(scene);
        myStage.show();
    }

    @FXML
    protected void onClickBack(ActionEvent event) throws IOException {
        Node callButton = (Node)event.getSource();
        Stage myStage = (Stage) callButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Stage myStage=new Stage();
        myStage.setScene(scene);
        myStage.show();
    }
}