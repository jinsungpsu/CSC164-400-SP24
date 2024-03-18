package com.example.helloworld;

import javafx.scene.input.KeyEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;

public class HelloController {

    public HelloController() {
        // constructor
        // usually used to initialize object
        System.out.println("Creating an object!");

        // textInCircle.setText("Hello World");
        // this doesn't work
        // constructor will NOT have access
        // to the objects created in the FXML file
    }

    // this is a special method
    // notice the @FXML annotation
    @FXML
    void initialize() {
        // this occurs AFTER everything is loaded
        // from fxml

//        String name = nameTextArea.getText();
//        textInCircle.setText("Hello, " + name);

    }

    @FXML
    void changeNameOfCircleText(KeyEvent event) {
        // this code will run
        // any time the "on key pressed" event
        // occurs on that textarea object
        // in the fxml UI
        String name = nameTextArea.getText();
        textInCircle.setText("Hello, " + name);
    }

    @FXML
    private Button button1;


    @FXML
    private TextField nameTextArea;

    @FXML
    private Circle circle1;

    @FXML
    private Text copyrightText;

    @FXML
    private Text textInCircle;

    @FXML
    private Text titleTextOnTop;

}
