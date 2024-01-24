import java.util.Scanner;

public class ArrayPractice {
    public static void main(String[] args) {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};

        /*
        for loop
        check if h or i is in there...
        letters[i] == 'h'
         */

        boolean containsH = false, containsI = false;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == 'h') {
                containsH = true;
            }
            else if (letters[i] == 'i') {
                containsI = true;
            }
        }
        if (containsH && containsI) {
            System.out.println("You can spell HI with those letters!");
        }


        int[] nums = new int[1000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 5 == 0)
                System.out.println(nums[i]);
        }

        for (int i = 4; i < nums.length; i+=5) {
            System.out.println(nums[i]);
        }

        int count = 0;
        while (count < 1000) {
            /*
            nums[4]
            nums[9]
            nums[14]
            ...
            nums[999]
             */
            System.out.println(nums[count+4]);

            count+=5;
        }









    }
}
