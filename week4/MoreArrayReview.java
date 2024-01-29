/*
Create a 2D array (5x5) with values 1 through 1, 25 (each “row” will have 5 numbers in it… so the first row would be {1,2,3,4,5}, second row would be {6,7,8,9,10}, etc.
Print the sum of each row
Print the sum of each column
Print the average of ALL values
 */

public class MoreArrayReview {

    public static void main(String[] args) {
//        int[][] arr = {
//                {1,2,3,4,5},
//                {6,7,8,9,10}
//        };

        int[][] arr2 = new int[5][5];

        // 99% of all programmers will write loops using i and j
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                //arr2[i][j] = ??;
            }
        }

        int val = 1;

        System.out.println(val++); // this will show 1
                                    // then increment

        System.out.println(--val);  // will show 1
                                    // because decrement
                                    // THEN output

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                arr2[row][col] = val++;
                // pre vs post increment operation
                // ++val would add 1 to val and THEN
                // preform the instruction
                // val++ would use the current value
                // in the variable, and THEN add 1
            }
        }

        for (int row = 0; row < 5; row++) {
            System.out.print("Row #" + row + ": ");
            for (int col = 0; col < 5; col++) {
                System.out.print(arr2[row][col] + " ");
            }
            System.out.println();
        }

        // sum rows
        // sum first row
        int firstRowSum = 0;
        for (int col = 0; col < 5; col++) {
            firstRowSum += arr2[0][col];
        }

        for (int row = 0; row < 5; row++) {
            int rowTotal = 0;
            System.out.print("Row #" + row + ": ");
            for (int col = 0; col < 5; col++) {
                rowTotal+=arr2[row][col];
                System.out.print(arr2[row][col] + " ");
            }
            System.out.println(", total = " + rowTotal);
        }



    }

}
