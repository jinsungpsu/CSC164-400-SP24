package com.example.personalfinanceapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddExpenseController {
    @FXML
    private TextField newExpenseItemAmount;

    @FXML
    private TextField newExpenseItemTextField;

    @FXML
    void addExpense(ActionEvent event) {
        double expenseAmount = Double.parseDouble(newExpenseItemAmount.getText());
        Expense newExpense = new Expense(newExpenseItemTextField.getText(), expenseAmount);
        ExpenseApplication.expenseList.add(newExpense);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ExpenseApplication.class.getResource("expense-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            ExpenseApplication.mainStage.setTitle("Hello!");
            ExpenseApplication.mainStage.setScene(scene);
        } catch (IOException e) {
            System.out.println("Error loading the add expense scene!");
            throw new RuntimeException(e);
        }
    }

    @FXML
    void cancelAddingExpense(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ExpenseApplication.class.getResource("expense-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            ExpenseApplication.mainStage.setTitle("Hello!");
            ExpenseApplication.mainStage.setScene(scene);
        } catch (IOException e) {
            System.out.println("Error loading the add expense scene!");
            throw new RuntimeException(e);
        }
    }
}
