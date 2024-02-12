public class Password {
    static boolean hasMinLetters;
    static boolean hasMinNumbers;
    static boolean hasMinCharacters;

    static String pw;
    public static void main(String[] args) {
        pw = "blahblah123";
        if (hasMinCharacters && hasMinLetters && hasMinNumbers) {
            System.out.println("PW is valid!");
        }

    }

    static void checkChars() {
        // blah blah
        hasMinCharacters = true;
    }

    static void checkNums() {
        hasMinNumbers = true;
    }

    static void checkMinLength() {
        hasMinCharacters = true;

        hasMinNumbers = true;
    }
}
