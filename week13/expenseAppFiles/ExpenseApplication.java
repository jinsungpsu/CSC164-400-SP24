package com.example.personalfinanceapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ExpenseApplication extends Application {

    // Fake database
    // anything that your WHOLE application needs access to
    // just put in here as a static and public variable
    public static Stage mainStage;
    public static ArrayList<Expense> expenseList = new ArrayList<>();
    public static Expense selectedExpenseItem;
    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(ExpenseApplication.class.getResource("expense-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}