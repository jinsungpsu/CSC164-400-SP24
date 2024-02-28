import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        ARRAYLIST
         */
        String[] menu5 = new String[5];
        ArrayList<String> stuff = new ArrayList<>();
        // the generic parameter... or
        // the KIND of stuff I want to store
        // MUST BE a class!!!

        // not allowed to do this
        // can't do polymorphism with primitive types
        // because primitive types don't have
        // inheritance
        // ArrayList<int> mylist = new ArrayList<>();


        // in order for us to be able to do this..
        // java has wrapper classes for all primitive types
        /*
        int > Integer
        float > Float
        double > Double
        char > Character
        boolean > Boolean

        String... is already a class
         */

        int num1 = 5;
        Integer num2 = 5; // same as Integer num2 = new Integer(5)

        String name = "Sam"; // new String();

        ArrayList<Integer> mylist = new ArrayList<>();

        /*
        HERE'S SOMETHING REALLY WEIRD...
        You can... but not very useful...
         */
        Object[] collectionOfAnythingEver = new Object[5];
        collectionOfAnythingEver[0] = 5;
        collectionOfAnythingEver[1] = new Food();
        collectionOfAnythingEver[2] = "Hello World";
        collectionOfAnythingEver[3] = 1.5;
        collectionOfAnythingEver[4] = 'c';

        for (int i = 0; i < collectionOfAnythingEver.length; i++) {
            if (collectionOfAnythingEver[i] instanceof Food == true) {
                System.out.println("This is a food!");
            }
            System.out.println(collectionOfAnythingEver[i]);
        }

        /*
        POLYMORPHISM
        a var of supertype can refer to subtype object
         */

        Food drink = new Food();
        Food drink2 = new Smoothie();
        Food drink3 = new CoffeeSmoothie();
        Object drink4 = new Food();
        Object drink5 = new Smoothie();
        Object drink6 = new CoffeeSmoothie();

        //Smoothie something = new Food();
        // can't do this, because not every food is a smoothie



        Food[] menu = new Food[3];

        menu[0] = new Food();
        menu[0].setName("Bread");
        menu[0].setCalories(150);
        menu[0].setIngredients("Butter, Milk, Flour, Salt");

        Food spaghetti = new Food();
        menu[1] = spaghetti;
        spaghetti.setName("Spaghetti Marinara");
        spaghetti.setCalories(600);
        menu[1].setIngredients("Tomatoes, EVOO, Salt, Pasta");

        System.out.println(spaghetti); // implicitly call toString method

        menu[2] = new Food();
        menu[2].setName("Sandwich");
        menu[2].setCalories(1000);
        menu[2].setIngredients("Bread, Ham, Salami, Cheese");

        menu[2].superSize();

        System.out.println("Welcome - here's our food menu: ");
        for (int i = 0; i < menu.length; i++) {
//            System.out.println(menu[i].getName());
//            System.out.println(menu[i].getIngredients());
//            System.out.println(menu[i].getCalories());
            System.out.println(menu[i]);
        }


        Smoothie[] smoothieMenu = new Smoothie[2];
        smoothieMenu[0] = new Smoothie("Strawberry Banana Blast", "Strawberries, bananas, milk, sugar", 450, 'L');
        smoothieMenu[1] = new Smoothie("Peanut Butter Pineapple", "Peanut Butter, Pineapple, Crushed Ice, Oat Milk", 700, 'M');

        smoothieMenu[0].superSize();

        System.out.println("Welcome - here's our smoothie menu: ");
        for (int i = 0; i < smoothieMenu.length; i++) {
            System.out.println(smoothieMenu[i].getName());
            System.out.println(smoothieMenu[i].getIngredients());
            System.out.println(smoothieMenu[i].getCalories());
            System.out.println(smoothieMenu[i].getCupSize());

        }


        /*
        CREATING A MENU OF BOTH FOOD AND SMOOTHIES
         */
        Food[] fullMenu = new Food[menu.length+smoothieMenu.length];

        for (int i = 0; i < menu.length; i++) {
            fullMenu[i] = menu[i];
        }
        for (int i = 0; i < smoothieMenu.length; i++) {
            fullMenu[i + menu.length] = smoothieMenu[i];
        }

        System.out.println("HERE'S ALL MY FOOD & SMOOTHIES!");
        for (int i = 0; i < fullMenu.length; i++) {
            System.out.println(fullMenu[i]);
        }

        Scanner keys = new Scanner(System.in);
        System.out.println("Max Calories wanted:");
        int maxCalories = keys.nextInt();

        System.out.println("Welcome - here's our smoothie menu: Only showing drinks with a max calorie count of: " + maxCalories);
        for (int i = 0; i < smoothieMenu.length; i++) {
            if (smoothieMenu[i].getCalories() <= maxCalories) {
                System.out.println(smoothieMenu[i].getName());
                System.out.println(smoothieMenu[i].getIngredients());
                System.out.println(smoothieMenu[i].getCalories());
                System.out.println(smoothieMenu[i].getCupSize());
            }
        }

        System.out.println("Welcome - here's our smoothie menu: - medium drinks only! ");
        for (int i = 0; i < smoothieMenu.length; i++) {
            if (smoothieMenu[i].getCupSize() == 'M') {
                System.out.println(smoothieMenu[i].getName());
                System.out.println(smoothieMenu[i].getIngredients());
                System.out.println(smoothieMenu[i].getCalories());
                System.out.println(smoothieMenu[i].getCupSize());
            }
        }


        CoffeeSmoothie orangeMochaFrap = new CoffeeSmoothie();

        System.out.println(orangeMochaFrap.toString());

    }
}

class Food {
    // implied to be class Food extends Object
    private int calories;
    private String ingredients;

    private String name;

    Food() {
        //System.out.println("Food constructor!");
    }

    void superSize() {
        name = "Super size " + name;
        calories += 1000;
    }


    void setCalories(int calories) {
        this.calories = calories;
    }
    void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    void setName(String name) {
        this.name = name;
    }

    int getCalories() {
        return calories;
    }

    String getIngredients() {
        return ingredients;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  "\nName: " + name +
                "\nCalories: " + calories +
                "\nIngredients: " + ingredients;
    }
}
class Smoothie extends Food {



    Smoothie() {
        // adding cuz i'm annoyed
    }
    Smoothie(String name, String ingredients, int calories, char cupSize) {
        super();
        //System.out.println("Smoothie constructor!");
        this.setName(name);
        this.setIngredients(ingredients);
        this.setCalories(calories);
        this.cupSize = cupSize;
    }

    //@Override
    void miniSize() {
        this.setCalories(this.getCalories() - 500);
        this.setName("Mini size smoothie " + this.getName());
    }

    @Override
    void superSize() {
        this.setCalories(this.getCalories() + 500);
        this.setName("Super size smoothie " + this.getName());
    }

    private char cupSize; // S, M, or L

    void setCupSize(char cupSize) {
        this.cupSize = cupSize;
    }

    char getCupSize() {
        return cupSize;
    }

    @Override
    public String toString() {
//        return "Name: " + this.getName() +
//                "\nIngredients: " + this.getIngredients() +
//                "\nCalories: " + this.getCalories() +
//                "\nCup size: " + cupSize;
        return super.toString() +
                "\nCup size: " + cupSize;

    }
}

class CoffeeSmoothie extends Smoothie{

    CoffeeSmoothie() {
        super("Unnamed Coffee Smoothie", "Coffee, Sugar", 300, 'M');
    }
    private int caffeine;

    void setCaffeine() {
        this.caffeine = caffeine;
    }

    int getCaffeine(int caffeine) {
        return caffeine;
    }

    @Override
    public String toString() {
//        return "Name: " + this.getName() +
//                "\nIngredients: " + this.getIngredients() +
//                "\nCalories: " + this.getCalories() +
//                "\nCup size: " + cupSize;
        return super.toString() +
                "\nCaffeine : " + caffeine;

    }
}
