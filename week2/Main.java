import java.util.*;

/*
Deltech Demo
Pokemon game app without AI
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to my pokemon battle app");

        final int MAX_HP = 120;
        // the values correspond to health point
        // starts at a 100, to represent 100%
        // https://www.w3schools.com/java/java_data_types.asp
        // using int, because we are only doing whole numbers
        int pikachuHp = MAX_HP;
        int charmanderHp = MAX_HP;

        int pikachuDef = 20;
        int pikachuAttack;
        int charmanderAttack = 30;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter pikachu's attack value: ");
        pikachuAttack = keyboard.nextInt();

        // no need to create multiple Scanner objects
        // just reuse the one you have
        System.out.println("Enter pikachu's def value: ");
        pikachuDef = keyboard.nextInt();

        float bonusHealth;

        while (pikachuHp > 100 && charmanderHp > 100) {
            pikachuHp -= (charmanderAttack - pikachuDef);
            System.out.println("Pikachu HP is now: " + pikachuHp);

            if (pikachuHp == 50) {
                System.out.println("You're at half health... do you want to eat a berry.");
            }


            System.out.println("Do you want to change pikachu's HP?");
            bonusHealth = keyboard.nextFloat();

            pikachuHp *= bonusHealth;
        }

        // this is a runtime error
        // System.out.println(1/0);

        // kind of optional
        // close the input stream
        keyboard.close();
    }
}
