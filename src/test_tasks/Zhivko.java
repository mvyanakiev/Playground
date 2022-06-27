package test_tasks;

import java.util.Arrays;

public class Zhivko {
    public static void main(String[] args) {
        int[] testArray = {3, 9, 50, 15, 99, 7, 98, 65};
        int result = distClosestNumbers(testArray);
        System.out.println(result); // Expected result is 1 (the 2 closest numbers are 98 and 99)
    }

    private static int distClosestNumbers(int[] testArray) {
        int result = Integer.MAX_VALUE;
        int firstClose = Integer.MIN_VALUE;
        int secondClose = Integer.MIN_VALUE;

        if (testArray.length <= 1) {
            throw new IllegalArgumentException("Invalid array length!");
        }

        Arrays.sort(testArray);

        for (int i = 0; i < testArray.length - 1; i++) {

            int first = testArray[i];
            int second = testArray[i + 1];

            int absValue = Math.abs(first - second);

            if (absValue < result) {
                result = absValue;
                firstClose = first;
                secondClose = second;
            }
        }

        System.out.println(firstClose);
        System.out.println(secondClose);

        return result;
    }
}
