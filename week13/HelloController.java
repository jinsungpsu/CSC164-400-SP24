package com.example.week13;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;

public class HelloController {
    private String fileName = "dessertList.txt";

    private ArrayList<Dessert> allDessertList = new ArrayList<>();
    @FXML
    private ListView<Dessert> dessertListView;

    @FXML
    private TextField dessertNameTextField;

    @FXML
    void initialize() {
        try {
            FileReader dessertFile = new FileReader(fileName);
            BufferedReader br = new BufferedReader(dessertFile);

            String dessertFileInput;
            while ((dessertFileInput = br.readLine())!=null) {
                System.out.println(dessertFileInput);
                Dessert dessert = new Dessert();
                dessert.setName(dessertFileInput);
                addDessertToBothLists(dessert);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Trouble with the dessert input file!");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void addDessertToBothLists(Dessert dessert) {
        allDessertList.add(dessert);
        dessertListView.getItems().add(dessert);
    }
    @FXML
    void addDessert(ActionEvent event) {
        String dessertName = dessertNameTextField.getText();
        Dessert dessert = new Dessert();
        dessert.setName(dessertName);
        addDessertToBothLists(dessert);
        addDessertToFile(dessert);
    }

    void addDessertToFile(Dessert dessert) {
        File file = new File(fileName);
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write("\n"+dessert.getName());
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Dessert {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dessert{" +
                "name='" + name + '\'' +
                '}';
    }
}
