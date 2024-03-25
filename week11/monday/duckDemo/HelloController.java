package com.example.week11lab;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;

public class HelloController {

    @FXML
    private Text duckCaptionText;

    @FXML
    private TextField input;

    @FXML
    void clearButtonHandler(MouseEvent event) {
        input.setText("");
        System.out.println("Clear button pressed!");

    }

    @FXML
    void submitButtonHandler(MouseEvent event) {
        System.out.println("Submit button pressed!");
        duckCaptionText.setText("This ducky's name is now..." + input.getText());
    }
    @FXML
    void initialize() {

    }
}
