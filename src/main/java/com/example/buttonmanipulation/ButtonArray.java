package com.example.buttonmanipulation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class ButtonArray {
    private ArrayList<Button> buttons;

    @FXML
    private GridPane grid;

    @FXML
    private void initialize() {
        buttons = new ArrayList<>();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button();
                // configure button...
                buttons.add(button);
                grid.add(button, col, row);
            }
        }
    }
}
