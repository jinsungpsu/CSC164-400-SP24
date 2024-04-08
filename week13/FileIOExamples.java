package com.example.week12;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.io.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class HelloController {

    @FXML
    private Slider sliderBottom;

    @FXML
    private Circle ball;

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

        File newFile = new File("creating_a_file.txt");

        try {
            newFile.createNewFile();
            FileWriter fw = new FileWriter(newFile, true);
            fw.write("now I'm not overwriting anymore!!");
            fw.close();
        } catch (IOException e) {
            System.out.println("Error creating the file!");
        }



        /*
        Using buffered reader instead
         */

        try {
            System.out.println("Trying out buffered reader instead!");
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));

            int someNumberFromTheFile = Integer.parseInt(br.readLine());

//            String inputString;
//
//            while ((inputString = br.readLine()) != null) {
//
//            }

//            String inputString = br.readLine();
//
//            while (inputString != null) {
//                System.out.println(inputString);
//
//                inputString = br.readLine();
//            }

            String inputString;

            do {

                inputString = br.readLine();
            } while (inputString != null);

        } catch (FileNotFoundException error) {
            // deal with the problem
            System.out.println("File not found!!");
        } catch (IOException error) {
            System.out.println("Some issues with the buffered reader!");
        }catch (NumberFormatException error) {
            System.out.println("The file had some strings that weren't actually numbers....");
        } catch (Exception error) {
            System.out.println("An unexpected has occurred!");
            System.out.println(error);
        }


        int[] arr = {1,2,3};
        try {
            Scanner anotherfile = new Scanner(new File("hello.txt"));
            System.out.println(arr[3]);
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("Problem!  Noob!");
        } catch(FileNotFoundException error) {

        } catch (Exception error) {
            System.out.println("This is a really general exception.");
            System.out.println("You can continue at your own risk... we don't know what went wrong...");
            System.exit(404);
        }

        File myfile = new File("Z:/csc164file.txt");
        Scanner keyboard = new Scanner(System.in);
        try {
            Scanner fileScanner = new Scanner(myfile);
            String firstName = fileScanner.next();
            String lastName = fileScanner.next();
            int homeRuns = fileScanner.nextInt();
            double battingAverage = fileScanner.nextDouble();
            System.out.println(firstName);
            System.out.println(lastName);
            System.out.println(homeRuns);
            System.out.println(battingAverage);
        }catch(FileNotFoundException error) {
            System.out.println(error);
            System.out.println("Uh oh... file not found!");

            return;
        }
        // this was just an example
        // String name = keyboard.next();




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

    @FXML
    void sliderChangedHandler(MouseEvent event) {
        //System.out.println("Something happened");
        //System.out.println("Current value is: " + sliderBottom.getValue());

        ball.setCenterX(sliderBottom.getValue());
    }

    @FXML
    void ballMove(MouseEvent event) {
        System.out.println("Hi");
        System.out.println("Mouse x: " + event.getX());
        System.out.println("Mouse y: " + event.getY());

        ball.setCenterX(event.getX());
        ball.setCenterY(event.getY());
    }
}
