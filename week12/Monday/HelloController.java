package com.example.week12;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.security.spec.RSAOtherPrimeInfo;

public class HelloController {

    // this has broader scope
    // variable available to this whole class!
    private Person[] pitchers = new Person[2];

    private final int AGE_CUTOFF = 30;

    @FXML
    private Text playerInfoArea;

    // The ListView class is used for
    // viewing lists
    // it's a parameterized class similar to ArrayList
    // we need to say WHAT is it going to view
    @FXML
    private ListView<Person> playerListView;

    @FXML
    void initialize() {
        // like hardcoding a very inflexible application
        // playerInfoArea.setText("Wheeler\nNola");

        // this is a lot more useful
        // OOP
        // where should this information/data go???
        // Person player1 = new Person(25, "Aaron Nola");
        // Person player2 = new Person(28, "Zack Wheeler");

        // these are instance variables of the controller
        // are available in the whole class!
        pitchers[0] = new Person(30, "Aaron Nola");
        pitchers[1] = new Person(33, "Zack Wheeler");

        String pitcherData = "";
        // display this in the GUI
        for (int i = 0; i < pitchers.length; i++) {
            pitcherData += "Name: " + pitchers[i].getName() + " Age: " + pitchers[i].getAge() + "\n";

            // the general idea of using listview
            // is that we want to add things to the GUI
            // that are list-like in nature
            // this is "wrong"
            // playerListView.add(pitchers[i]);
            playerListView.getItems().add(pitchers[i]);
        }

        playerInfoArea.setText(pitcherData);
    }

    @FXML
    void showOldPlayers(MouseEvent event) {
        playerListView.getItems().clear();

        for (int i = 0; i < pitchers.length; i++) {
            if (pitchers[i].getAge() > AGE_CUTOFF) {
                playerListView.getItems().add(pitchers[i]);
            }
        }
    }

    @FXML
    void showYoungPlayers(MouseEvent event) {
        playerListView.getItems().clear();

        for (int i = 0; i < pitchers.length; i++) {
            if (pitchers[i].getAge() <= AGE_CUTOFF) {
                playerListView.getItems().add(pitchers[i]);
            }
        }
    }
    @FXML
    void showPlayerInfo(MouseEvent event) {
        System.out.println("Someone clicked and the argument was: " + event);

        // how can i tell which player/object was selected???
        // https://docs.oracle.com/javafx/2/api/javafx/scene/control/SelectionModel.html
        // there is a selection model INSIDE the listview class
        // we GET the selection model
        // then we can figure out which item is actually selected
        // by using the getSelectedItem getter
        Person selectedPerson = playerListView.getSelectionModel().getSelectedItem();

        System.out.println("The person selected is: " + selectedPerson);

    }
}
