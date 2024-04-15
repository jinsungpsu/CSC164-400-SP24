import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Tiger t1 = new Tiger();
        System.out.println(t1.toString());

        Cat cat = new Tiger();
        Tiger tiger = new Tiger();

        Cat cat2 = new Cat(7);

        ArrayList<Cat> allAnimals = new ArrayList<>();
        allAnimals.add(cat);
        allAnimals.add(tiger);
        allAnimals.add(cat2);

        for (int i = 0; i < allAnimals.size(); i++) {
            System.out.println(allAnimals.get(i));

            if (allAnimals.get(i) instanceof Tiger) {
                // then this is a tiger...
            }
        }

    }
}

class Cat {
    int age;
    Cat (int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "this is a cat " + age + " years old.";
    }
}

class Tiger extends Cat {
    int stripes;

    Tiger() {
        super(5);
    }

    @Override
    public String toString() {
        return "this is a tiger " + age + " years old that has " + stripes + " many stripes.";
    }
}
