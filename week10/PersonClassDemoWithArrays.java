
public class Main {
    public static void main(String[] args) {
        Person mrAn = new Person();
        mrAn.setAge(99);
        mrAn.setName("Jin An");
        // this works, but it's a little
        // weird/unintuitive
//        String[] pets = {"Dixie", ""};
//        mrAn.setPets(pets);

        // this is better
        // moves the complexity
        // and abstracts it from main
        // and puts it into the Person class
        mrAn.adoptPet("Dixie");

        mrAn.adoptPet("Garfield");

        mrAn.adoptPet("Mimi");
    }
}
class Person {
    private String name;
    private int age;

    private String[] pets = new String[2];

    public void adoptPet(String petName) {
        if (pets[0] == null) {
            // this person doesn't have a first pet
            pets[0] = petName;
        }
        else if (pets[1] == null) {
            // this person doesnt have a second pet
            pets[1] = petName;
        } else {
            // this person has 2 pets already
            System.out.println("Can't adopt!  Already have 2 pets!");
        }
    }

    public String[] getPets() {
        return pets;
    }

    public void setPets(String[] pets) {
        this.pets = pets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
