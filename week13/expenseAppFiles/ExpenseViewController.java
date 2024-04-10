package com.example.personalfinanceapp;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.ListView;

import java.io.IOException;

public class ExpenseViewController {
    @FXML
    private ListView<Expense> expenseListView;

    @FXML
    private Text titleText;

    @FXML
    void initialize() {
        expenseListView.getItems().clear();
        for (int i = 0; i < ExpenseApplication.expenseList.size(); i++) {
            // expenseListView.getItems().add(ExpenseApplication.expenseList.get(i));
            Expense currentExpense = ExpenseApplication.expenseList.get(i);
            expenseListView.getItems().add(currentExpense);
        }
    }
    @FXML
    void loadDetailsWindow(ActionEvent event) {
        ExpenseApplication.selectedExpenseItem = expenseListView.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ExpenseApplication.class.getResource("expense-details-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage newStage = new Stage();
            newStage.setTitle("Expense details");
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException e) {
            System.out.println("Error loading the add expense scene!");
            throw new RuntimeException(e);
        }
    }

    @FXML
    void loadAddExpenseScene(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ExpenseApplication.class.getResource("add-expense-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
//            ExpenseApplication.mainStage.setTitle("Hello!");
//            ExpenseApplication.mainStage.setScene(scene);
            Node node = (Node) event.getSource();
            Stage thisStage = (Stage) node.getScene().getWindow();
//            Stage thisStage = (Stage) titleText.getScene().getWindow();
            thisStage.setScene(scene);
        } catch (IOException e) {
            System.out.println("Error loading the add expense scene!");
            throw new RuntimeException(e);
        }

    }

    @FXML
    void loadAddExpenseSceneNewWindow(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ExpenseApplication.class.getResource("add-expense-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage newStage = new Stage();
            newStage.setTitle("Add a new expense item");
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException e) {
            System.out.println("Error loading the add expense scene!");
            throw new RuntimeException(e);
        }

    }

}
