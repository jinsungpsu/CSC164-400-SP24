package com.example.personalfinanceapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ExpenseDetailsController {

    @FXML
    private Text expenseDetailsText;

    @FXML
    void initialize() {
        if (ExpenseApplication.selectedExpenseItem != null) {
            expenseDetailsText.setText(ExpenseApplication.selectedExpenseItem.toString());
        } else {
            expenseDetailsText.setText("No item was selected!");
        }
    }

    @FXML
    void closeWindow(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        thisStage.close();
    }

}
