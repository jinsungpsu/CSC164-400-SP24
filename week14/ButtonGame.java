package com.example.buttonpressgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ButtonGameApp extends Application {
    public static int correctAnswers = 0, incorrectAnswers = 0;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ButtonGameApp.class.getResource("start-screen-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Button Pressing Game!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

package com.example.buttonpressgame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {

    @FXML
    void correctAnswer(MouseEvent event) {
        ButtonGameApp.correctAnswers++;
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(ButtonGameApp.class.getResource("game-over-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setTitle("Button Pressing Game!");
            stage.setScene(scene);
            stage.show();
        } catch(IOException e) {
            System.out.println("Error loading new scene from FXML file!");
        }
    }

    @FXML
    void incorrectAnswer(MouseEvent event) {
        ButtonGameApp.incorrectAnswers++;
    }

    @FXML
    void initialize() {
        ButtonGameApp.correctAnswers = 0;
        ButtonGameApp.incorrectAnswers = 0;
    }

}

package com.example.buttonpressgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GameOverController {

    @FXML
    private Text correctCountText;

    @FXML
    private Text incorrectCountText;

    @FXML
    private TextField nameTextField;

    @FXML
    void saveScore(ActionEvent event) {
        String name = nameTextField.getText();
        boolean nameExists = false;
        //int existingScore = -999999999;
        int existingScore = Integer.MIN_VALUE;
        String currentHighScores = "";
        int previousCorrect=0;
        int previousIncorrect=0;

        try {
            /*
            check if your name is already in the file
            if it is, check if your score is better than existing
            then write the new high score if necessary
             */

            /*
            read in current file... see what the score is...
             */
            Scanner fileInput = new Scanner(new File("highscores.txt"));
            while(fileInput.hasNext()) {
                // keep looping as long as there's another
                // string in that file left to "read"
                String nextPieceOfData = fileInput.next();
                System.out.println(nextPieceOfData + " ");

                if (nextPieceOfData.equals(name)) {
                    // it means the name is already in the highscores file
                    nameExists = true;
                    previousCorrect = Integer.parseInt(fileInput.next());
                    previousIncorrect = Integer.parseInt(fileInput.next());
                    existingScore = previousCorrect - previousIncorrect;
                } else {
                    currentHighScores += nextPieceOfData + " ";
                }

            }

            /*
            check if previous score is better than current score
             */
            FileWriter fw = new FileWriter("highscores.txt");
            fw.write(currentHighScores);

            int currentScore = ButtonGameApp.correctAnswers - ButtonGameApp.incorrectAnswers;
            if (currentScore > existingScore) {
                // current game is better than score in file
                fw.write(name + " " + ButtonGameApp.correctAnswers + " " + ButtonGameApp.incorrectAnswers + "\n");
            } else {
                // score in file is better than current game...
                fw.write(name + " " + previousCorrect + " " + previousIncorrect + "\n");
            }


            fw.close();
        } catch (IOException error) {

        }

        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(ButtonGameApp.class.getResource("start-screen-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setTitle("Button Pressing Game!");
            stage.setScene(scene);
            stage.show();
        } catch(IOException e) {
            System.out.println("Error loading new scene from FXML file!");
        }
    }

    @FXML
    void initialize() {
        // correctCountText.setText(Integer.toString(ButtonGameApp.correctAnswers));
        correctCountText.setText(ButtonGameApp.correctAnswers + "");
        incorrectCountText.setText(ButtonGameApp.incorrectAnswers + "");

    }

}


package com.example.buttonpressgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScreenController {

    @FXML
    private Label welcomeText;

    @FXML
    void startGame(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(ButtonGameApp.class.getResource("game-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setTitle("Button Pressing Game!");
            stage.setScene(scene);
            stage.show();
        } catch(IOException e) {
            System.out.println("Error loading new scene from FXML file!");
        }
    }

}
