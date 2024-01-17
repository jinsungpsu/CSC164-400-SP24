/*
Completely copied from chatGPT
 */
public class PokemonBattle {
    public static void main(String[] args) {
        String pikachu = "Pikachu";
        int pikachuHealth = 100;

        String charmander = "Charmander";
        int charmanderHealth = 100;

        System.out.println("Let the battle begin!\n");

        while (pikachuHealth > 0 && charmanderHealth > 0) {
            int pikachuDamage = 10;
            System.out.println(pikachu + " attacks " + charmander + " and deals " + pikachuDamage + " damage.");
            charmanderHealth -= pikachuDamage;
            System.out.println(charmander + " now has " + charmanderHealth + " health remaining.\n");

            if (charmanderHealth <= 0) {
                System.out.println(charmander + " fainted. " + pikachu + " wins!");
                break;
            }

            int charmanderDamage = 8;
            System.out.println(charmander + " attacks " + pikachu + " and deals " + charmanderDamage + " damage.");
            pikachuHealth -= charmanderDamage;
            System.out.println(pikachu + " now has " + pikachuHealth + " health remaining.\n");

            if (pikachuHealth <= 0) {
                System.out.println(pikachu + " fainted. " + charmander + " wins!");
                break;
            }
        }
    }
}
