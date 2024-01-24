/*
Starter Code for Assignment 1: Sports Scorekeeper - Arrays
Delaware Technical Community College
CSC164 - Computer Science II
Fall 2023
*/
import java.util.Random;

public class ScoreKeeperAssignment {
    public static void main(String[] args) {

        char[][] letterMatrix = new char[10][10];
        char[][] anotherLetterMatrix = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}
        };
        // second row, second letter
        System.out.println(anotherLetterMatrix[1][1]);

        // just the first letter directly
        // row 0, col 0
        System.out.println(anotherLetterMatrix[0][0]);

        // 2d arrays are arrays of arrays
        char[] justTheFirstRow = anotherLetterMatrix[0];

        // just the first letter
        char justTheFirstLetter = justTheFirstRow[0];

        // how many rows are there in my 2d array?
        System.out.println("There are: " + anotherLetterMatrix.length + " rows.");

        // how many columns are there???
        System.out.println("There are: " + anotherLetterMatrix[0].length + " columns.");


        final int NUM_GAMES = 10;
        final int NUM_PERIODS = 2;
        final int HIGH_SCORE_PER_PERIOD = 5;
        final int LOW_SCORE_PER_PERIOD = 0;

        int[][] teamScores = new int[NUM_GAMES][NUM_PERIODS];

        Random rng = new Random();
        // Set random number generator, so it provides the same random numbers every time
        // If you remove this line, the program will produce pseudorandom numbers that are different every time
        rng.setSeed(1);

        // Assign random scores to each period for each game
        for (int i = 0; i < NUM_GAMES; i++) {
        // for (int i = 0; i < teamScores.length; i++) {
            for (int j = 0; j < NUM_PERIODS; j++) {
                // for (int j = 0; j < teamScores[i].length; j++) {
                teamScores[i][j] = rng.nextInt(LOW_SCORE_PER_PERIOD, HIGH_SCORE_PER_PERIOD+1);
            }
        }

        // display scores for every game
        for (int i = 0; i < NUM_GAMES; i++) {
            System.out.println("\nThis team, in game # " + (i + 1));
            for (int j = 0; j < NUM_PERIODS; j++) {
                System.out.println("In period # " + (j+1) + " this team scored: " + teamScores[i][j]);
            }
        }

        // points scored in match #5
        System.out.println("First half: " + teamScores[4][0]);
        System.out.println("Second half: " + teamScores[4][1]);

        System.out.println("TOtal scored: " + teamScores[4][0] + teamScores[4][1]);


    }

}
