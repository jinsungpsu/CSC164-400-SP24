// public class must match name of the file
// so this one has to be Cat.java
public class Cat {
    int age;


}

// but, I can have as many OTHER classes as I want in here
// but they can't be marked "public"
// this is my driver/test/Main application
class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
    }
}
