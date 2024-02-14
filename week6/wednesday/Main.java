class Main {
    public static void main(String[] args) {
        Pokemon[] ashPokemons = new Pokemon[1000];
        for ( int i = 0; i < ashPokemons.length; i++) {
            ashPokemons[i] = new Pokemon();
        }









        Pokemon p1 = new Pokemon("Pikachu");
        // p1.setName("Pikachu");
        p1.setAttack(50);
        p1.setHp(100);
        p1.setDefense(30);

        Pokemon p2 = new Pokemon("Charizard", 200);
        p2.setDefense(40);
        p2.setAttack(75);

        Battle pokemonGymBattle = new Battle(p1, p2, 5);

        pokemonGymBattle.fight();
    }
}

class Battle {
    private Pokemon p1;
    private Pokemon p2;

    private int rounds; // max # of rounds

    private int currentRound = 1;

    public Battle(Pokemon firstPokemon, Pokemon secondPokemon, int numRounds) {
        p1 = firstPokemon;
        p2 = secondPokemon;
        rounds= numRounds;
    }

    public void fight() {
        for (int i = 0; i < rounds; i++) {
            fightRound();
        }
    }

    public void fightRound() {
        System.out.println("#### ROUND " + currentRound + " ######");
        if (currentRound != rounds+1) {
            currentRound++;
//            // p2 attacks p1
//            int p1currentHp = p1.getHp();
//            int p1def = p1.getDefense();
//            int p2atk = p2.getAttack();
//            int p1newHp = p1currentHp - (p2atk - p1def);
//            p1.setHp(p1newHp);
//
//            // p1 attacks p2
//            int p2currentHp = p2.getHp();
//            int p2def = p2.getDefense();
//            int p1atk = p1.getAttack();
//            int p2newHp = p2currentHp - (p1atk - p2def);
//            p2.setHp(p2newHp);

            p1.attack(p2);
            if (p2.getHp() < 0) {
                System.out.println(p2.getName() + " has fainted.");
                return;
            }

            p2.attack(p1);
            if (p1.getHp() < 0) {
                System.out.println(p1.getName() + " has fainted.");
            }

        } else {
            System.out.println("The battle is finished... we already finished max number of rounds");
        }
    }
}

class Pokemon {
    // THESE ARE ALL INSTANCE VARIABLES
    // every object I create from this class
    // each one will have its own version of these
    private String name;
    private int attack, defense, hp;

    // static variables
    // all objects of this class will share the same version of it
    final static int MAX_HP = 300;
    private static int pokemonPopulation = 0;

    public Pokemon() {

    }

    // as soon as there's at least ONE explicit constructor
    // there's no longer an implicit no arg default constructor
    // included
    // this overloaded constructor
    // at minimum, in order to create a pokemon
    // I need to include a name...
    // b/c there's no way to do Pokemon() anymore
    public Pokemon(String pokemonName) {
        name = pokemonName;
        pokemonPopulation++;
    }

    public Pokemon(String pokemon, int startingHp) {
        name = pokemon;
        hp = startingHp;
        pokemonPopulation++;
    }

    public void attack(Pokemon enemy) {
        System.out.println(name + " is attacking " + enemy.name);
        enemy.hp = enemy.hp - (attack - enemy.defense);
        System.out.println(enemy.name + "'s HP is now: " + enemy.hp);
    }

    //setters, mutators
    public void setName(String newName) {
        name = newName;
    }
    public void setAttack(int newAttack) {
        attack = newAttack;
    }

    public void setDefense(int newDefense) {
        defense = newDefense;
    }

    public void setHp(int newHp) {
        if (newHp < 0 || newHp > MAX_HP) {
            System.out.println("Can't set negative HP");
        } else {
            hp = newHp;
        }
    }

    // getters
    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    // this is a static method
    // doesn't belong to a single pokemon
    // so the way you call it (by the class name)
    // is Pokemon.getPopulation()
    static public int getPopulation() {
        return pokemonPopulation;
    }

    public void die() {
        hp = 0;
        pokemonPopulation--;
    }
}
