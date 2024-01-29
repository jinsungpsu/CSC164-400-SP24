weeimport java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int[] array = {1,2,3,4,5};
        printArrayItems(array);
        change3rdValue(array);
        printArrayItems(array);


        int someNumber = 1;
        printVal(someNumber);
        changeVal(someNumber);
        printVal(someNumber);

        System.out.println();

        printMenu(keyboard);


    }
    static void printMenu(Scanner keyboard) {
        System.out.println("1: Login using pin.");
        System.out.println("2: Exit");
        System.out.println("What do you want to do? ");
        int choice = keyboard.nextInt();
    }

    static void printVal(int num) {
        System.out.println(num);
    }

    static void changeVal(int num) {
      // num is passed by value, meaning this int num is
      // a completely different copy than the one in main
      // this change will NOT be reflected in main
        num = 99;
    }

    static void change3rdValue(int[] arr) {
        // pass by reference
        // arrays are ALWAYS passed by reference
        // because... they take up a lot of space
        // and so the creators of java decided...
        // arrays will always be passed by reference
        arr[3] = 99;
        // arr variable is the SAME address as the one in main
        // so any changes here will be reflected in main as well
    }

    static void printArrayItems(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
