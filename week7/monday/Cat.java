// public class must match name of the file
// so this one has to be Cat.java
public class Cat {
    int age;
    String name;
    Cat() {
        this("Fluffy");
        age = 1;
    }

    Cat(String name) {
        //this();
        this.name = name;
    }

    Cat (String name, int age) {

    }

    //setters
    void setAge(int age) {
        // there's a parameter called
        // age that's passed into this method
        // there's also an instance variable
        // called age for this object
        this.age = age;
        // by adding this.age
        // we can differentiate this cat
        // object's age (aka instance variable)
        // from the parameter age
    }

    void birthday() {
        //this.age = 5;
        age++;
    }

}

// but, I can have as many OTHER classes as I want in here
// but they can't be marked "public"
// this is my driver/test/Main application
class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat();

        Cat[] allMyCats = new Cat[2];
        allMyCats[0] = new Cat();

        Cat cat2 = new Cat();

        Cat garfield = new Cat();
        garfield.birthday();
        Cat mimi = new Cat();
        mimi.birthday();

        Cat fifi = new Cat("Fifi");
    }
}
