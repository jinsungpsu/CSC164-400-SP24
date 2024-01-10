// CSC164, Thursday 1/10
// Class code examples

// similar to #include <iostream>
import java.util.Scanner;

// class Main
// don't worry about it =D
// EVERYTHING MUST BE INSIDE this Main class block
class Main {

  // basically same as int main() from c++
  public static void main(String[] args) {
    /*
     * Different data types available:
     * float, double
     * int, long, short
     * char
     * string
     * boolean
     */

    int pikachuHp = 100;
    int pikachuAttack = 20;
    int pikachuDefense = 10;
    int charmanderHp = 100;
    int charmanderAttack = 20;
    int charmanderDefense = 10;

    // in order to get input...
    // I need to declare a keyboard "variable"
    Scanner keyboard = new Scanner(System.in);

    // if i wanted to get some information from the keyboard aka user input
    // int something;
    // we used to do cin >> something
    // something = keyboard.nextInt();

    while (pikachuHp > 0 && charmanderHp > 0) {
      pikachuHp -= charmanderAttack - pikachuDefense;
      charmanderHp -= pikachuAttack - charmanderDefense;
      // cout << "Pokemon now has: " << pikachuHp << "HP" << endl;
      // you can "add" each part of the output together using the + operator for the string data type
      System.out.print("Pikachu now has: " + pikachuHp + "HP");

      /*
      Could also do it separately in 3 different statements:
      System.out.print("Pikachu now has: ");
      System.out.print(pikachuHp);
      System.out.print(" HP\n\n");
      */

      System.out.println("\nCharmander now has: " + charmanderHp + "HP");

      System.out.println("\n\nCheat system: how much additional damage should we give charmander?");
      int cheat = keyboard.nextInt();

      charmanderHp -= cheat;
      System.out.println("Charmander now has: " + charmanderHp + "HP (after cheating... you cheat... that's messed up.");
    }

    //System.out.println("What's up!");
    /*
     * this is the same as print.. but at the end, it's going to add a "\n"
     * exactly equivalnet to System.out.print("What's up!\n");
     */
  }

}
