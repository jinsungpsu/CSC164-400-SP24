// CSC164, Thursday 1/10
// Class code examples

// #include <iostream>

import java.util.Scanner;

// class Main
// don't worry about it =D
class PokemonBattle {

  // basically same as int main() from c++
  public static void main(String[] args) {
    /*
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
      System.out.print("Pokemon now has: " + pikachuHp + "HP");
      System.out.print("Pokemon now has: ");
      System.out.print(pikachuHp);
      System.out.print(" HP\n\n");

      System.out.println("Charmander now has: " + charmanderHp + "HP");

      System.out.println("\n\nCheat system: how much additional damage should we give charmander?");
      int cheat = keyboard.nextInt();

      charmanderHp -= cheat;
      System.out.println("Charmander now has: " + charmanderHp + "HP (after cheating... you cheat... that's messed up.");
    }

    System.out.println("What's up!");
    /*
     * this is the same as print.. but at the end, it's going to add a "\n"
     * exactly equivalnet to System.out.print("What's up!\n");
     */
  }

  // @Test
  // void addition() {
  // assertEquals(2, 1 + 1);
  // }
}
