import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // String is a class
        // which means... no different than a BankAccount

        // if String is a class...
        // how do you create objects?
        // need to call a constructor
        String name = "Johnny";

        // what is this really doing?
        String name2 = new String();



        printMenu();
        // int[] arr = new int[5];
        // owner is default
        BankAccount account1;
        account1 = new BankAccount();

        account1.pin = 2424;

        // owner is Alex
        BankAccount account2 = new BankAccount("Alex");
        account2.accountNumber = 11111112;

        // this is a reference variable
        // meaning...
        // it can only hold 2 types of information..
        // 1: null (nowhere)
        // 2: an address in ram (reference)
        BankAccount account3 = null;

        if (account3 != null)
            System.out.println(account3.balance);

        Scanner keyboard = new Scanner(System.in);

        // this is not good
        // a seasoned programmer's brain
        // is really confused
        // because class names
        // should start with a upper case letter
        // other variable names start with lower case
        user person1 = new user();

        AutomatedTellerMachine atm1 = new AutomatedTellerMachine();


        System.out.println("Account 1's info: ");
        System.out.println("Name: " + account1.name);
        System.out.println("Acct #: " + account1.accountNumber);
        System.out.println("Pin #: " + account1.pin);
        System.out.println("Owner name: " + account1.ownerName);
        System.out.println("Balance: $" + account1.balance);

        System.out.println("Account 2's info: ");
        System.out.println("Name: " + account2.name);
        System.out.println("Acct #: " + account2.accountNumber);
        System.out.println("Pin #: " + account2.pin);
        System.out.println("Owner name: " + account2.ownerName);
        System.out.println("Balance: $" + account2.balance);

        System.out.println("Please enter pin#: ");
        int enteredPin = keyboard.nextInt();
        if (enteredPin == account2.pin) {
            account2.deposit(150);
        }

        // can't call these methods using dot notation
        // using the name of the class...
        // like we did with Math.random
        // because if there's no bank account
        // where does the money go?
        // there's literally no memory allocated
        // for the balance variable
        // unless you create a BankAccount object
        // BankAccount.deposit(150);

        System.out.println("#################################");
        System.out.println("After deposit: ");

        System.out.println("Account 1's info: ");
        System.out.println("Name: " + account1.name);
        System.out.println("Acct #: " + account1.accountNumber);
        System.out.println("Pin #: " + account1.pin);
        System.out.println("Owner name: " + account1.ownerName);
        System.out.println("Balance: $" + account1.balance);

        System.out.println("Account 2's info: ");
        System.out.println("Name: " + account2.name);
        System.out.println("Acct #: " + account2.accountNumber);
        System.out.println("Pin #: " + account2.pin);
        System.out.println("Owner name: " + account2.ownerName);
        System.out.printf("Balance: $%.2f", account2.balance);
    }
    static void printMenu() {
        System.out.println("1. Deposit money: ");
        System.out.println("2. Withdraw money: ");
    }
}

class AutomatedTellerMachine {

}

// do not do this
// class names should start with capital
class user {

}

class BankAccount {
    // what it is
    // variables
    // define what this class' data is
    double balance;
    String name;
    String ownerName;
    int pin;
    int accountNumber;

    // constructors
    // same name as class
    // no return type
    // they are used to "initialize" the object
    BankAccount() {
        System.out.println("Creating and initializing a new bank account...");
        balance = 0;
        pin = 1234;
        name = "Basic Checking Account";
        ownerName = "default";
        accountNumber = 11111111;
    }

    // overloaded constructor
    // all the theory behind constructors is the same...
    // constructors with parameters
    // are usually used... because you want to initialize it
    // with some extra information that is "passed in"
    BankAccount(String customerName) {
        System.out.println("Creating and initializing a new bank account...");
        balance = 0;
        pin = 1234;
        name = "Basic Checking Account";
        accountNumber = 11111111;
        ownerName = customerName;
    }

    // what it does...
    // methods will define what this class'
    // behaviors are
    void deposit(double money) {
        balance += money;
    }

    void withdrawn(double money) {
        balance -= money;
    }
}
