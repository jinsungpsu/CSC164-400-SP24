import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        /*
        ArrayList practice from https://www.w3resource.com/java-exercises/collection/index.php#arraylist
         */

        // #1
        ArrayList<String> colorList = new ArrayList<>();
        colorList.add("Pink");
        colorList.add("Blue");
        colorList.add("Fuchsia");
        System.out.println(colorList);

        // #2
        for (int i  = 0; i < colorList.size(); i++) {
            System.out.println(colorList.get(i));
        }

        // #3, add something to position 0...
        // how do we do this???
        // read the documentation??
        // chatgpt?  that's ok.. ish
        // google?  that's ok... ish... too

        colorList.add(0, "Green");
        System.out.println(colorList);

        ArrayList<String> menu = new ArrayList<>();
        menu.add("hI");

        System.out.println("A integer takes this number of bytes in memory: " + Integer.BYTES);

        int result = Integer.compare(9, 5);

        int[] arr = {1,2,3};
        // arr[3] = 4; // trying to add an item at the end
                        // can't do that, though...
        int[] newArr = new int[4];
        newArr[0] = 4;
        for (int i = 1; i < arr.length+1; i++) {
            newArr[i] = arr[i-1];
        }

        ArrayList<Integer> arrList = new ArrayList<>(5);

        for (int i = 0; i < 5; i++) {
            arrList.add(0);
        }

        System.out.println("After creating and adding 0's to first 5 spots" + arrList);

        arrList.set(0, 1);
        arrList.set(1, 2);
        arrList.set(2, 3);
        arrList.add(4); // add a 6th item

        System.out.println("Array list contents at the end: " + arrList);
        for (int i = 0; i < arrList.size(); i++) {
            // not .length as when we work with arrays
            System.out.println(arrList.get(i));
            // instead of
            // arrList[i] we use the getter
        }



    }
}
