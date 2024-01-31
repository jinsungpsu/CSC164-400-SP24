import java.util.Scanner;

public class BankApp {
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        /*
        format specifiers
         */
        System.out.printf("Hi %s, your total today is $%.2f, you elected to tip %.2f", "Johnny", 1.50, 0.50);



        final int CORRECT_PIN = 1234;
        System.out.println("Enter your pin: ");
        int userEnteredPin = getUserInput(0000, 9999);

        if(isCorrectPin(userEnteredPin, CORRECT_PIN)) {
            // they entered the correct pin!
        }
    }

    // methods
    // static return type name (parameters) {
    // inputs?
    // correct pin #
    // receive a pin
    static boolean isCorrectPin(int userPinTry, int correctPin) {
        // int userPinTry = keyboard.nextInt();
        if (userPinTry == correctPin)
            return true;
        else
            return false;
    }

    static boolean isValidNumber(int number, int upperLimit, int lowerLimit) {
        if (number >= lowerLimit && number <= upperLimit) {
            return true;
        } else {
            return false;
        }
    }

    /*
    this method
    will get user input
    from the keyboard
    and make sure it is above the low threshold
    and below the high threshold

    @params high is the upper threshold
    @params low is the lower threshold

    @returns the value that is between the low/high

    ** this is in javadoc style documentation
     */
    static int getUserInput(int high, int low) {
        int userInput;
        do {
            System.out.println("Enter a number between " + low + " and " + high + ".");
            userInput = keyboard.nextInt();
        } while (!isValidNumber(userInput, high, low));

        return userInput;
    }

    // method that sums up all rows in a 2d int array

    static int sumRow(int[][] arr, int row) {
        return 150;
    }

    static int getSpecificMatchTotal(int[][] teamScores, int matchNumber) {
        return sumRow(teamScores, matchNumber-1);
    }

}
