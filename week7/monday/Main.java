import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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

        menu[2] = new Food();
        menu[2].setName("Sandwich");
        menu[2].setCalories(1000);
        menu[2].setIngredients("Bread, Ham, Salami, Cheese");

        System.out.println("Welcome - here's our food menu: ");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i].getName());
            System.out.println(menu[i].getIngredients());
            System.out.println(menu[i].getCalories());
        }


        Smoothie[] smoothieMenu = new Smoothie[2];
        smoothieMenu[0] = new Smoothie("Strawberry Banana Blast", "Strawberries, bananas, milk, sugar", 450, 'L');
        smoothieMenu[1] = new Smoothie("Peanut Butter Pineapple", "Peanut Butter, Pineapple, Crushed Ice, Oat Milk", 700, 'M');

        System.out.println("Welcome - here's our smoothie menu: ");
        for (int i = 0; i < smoothieMenu.length; i++) {
            System.out.println(smoothieMenu[i].getName());
            System.out.println(smoothieMenu[i].getIngredients());
            System.out.println(smoothieMenu[i].getCalories());
            System.out.println(smoothieMenu[i].getCupSize());

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

    }
}

class Food {
    private int calories;
    private String ingredients;

    private String name;

    Food() {
        System.out.println("Food constructor!");
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
}

class Smoothie extends Food {

    Smoothie(String name, String ingredients, int calories, char cupSize) {
        super();
        System.out.println("Smoothie constructor!");
        this.setName(name);
        this.setIngredients(ingredients);
        this.setCalories(calories);
        this.cupSize = cupSize;
    }

    private char cupSize; // S, M, or L

    void setCupSize(char cupSize) {
        this.cupSize = cupSize;
    }

    char getCupSize() {
        return cupSize;
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
}
