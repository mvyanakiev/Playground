package AmadeusTest;

import java.util.*;
import java.io.*;

class SmallestInterval {

    public static int findSmallestInterval(int[] numbers) {
        Arrays.sort(numbers);
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (i + 1 >= numbers.length) {
                break;
            }

            if (Math.abs(numbers[i] - numbers[i + 1]) < result) {
                result = Math.abs(numbers[i] - numbers[i + 1]);
            }
        }
        return result;
    }

    /* Ignore and do not change the code below */
    // #region main
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }
        PrintStream outStream = System.out;
        System.setOut(System.err);
        int res = findSmallestInterval(numbers);
        System.setOut(outStream);
        System.out.println(res);
    }
    // #endregion
}
