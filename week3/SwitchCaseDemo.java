import java.util.Scanner;

public class SwitchCaseDemo {
    public static void main(String[] args) {


        /*
        switch/case
         */

        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("What direction do you want to go in?");
            System.out.println("A is for left");
            System.out.println("S is for down");
            System.out.println("D is for right");
            System.out.println("W is for up");
            char direction = keyboard.next().charAt(0); // sorry... will teach you later

            switch (direction) {
                case 'a':       // equivalent of doing
                case 'A':       // direction == 'a' || direction == 'A'
                    System.out.println("Traveling left...");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 5:
                    System.out.println("5");
                    break;
                default:
                    System.out.println("Didn't match any cases!");
                    break; // redundant
            }
//            if (track == 'a' || track == 'A') {
//                System.out.println("1");
//            } else if (track == 2) {
//                System.out.println("2");
//            }
        }
    }
}
