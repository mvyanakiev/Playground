package hacker_rank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MiniMaxSum {
    public static void main(String[] args) {
        Integer[] testArray = {1,3,5,7,9};
//        Integer[] testArray = {769082435, 210437958, 673982045, 375809214, 380564127};
        miniMaxSum(Arrays.asList(testArray));
    }

    public static void miniMaxSum(List<Integer> arr) {
        long max = 0;
        long min = 0;

        Collections.sort(arr);

        for (int i = 0; i <= 3; i++) {
            min += arr.get(i);
        }

        for (int i = 4; i >= 1 ; i--) {
            max += arr.get(i);
        }

        System.out.printf("%d %d", min, max);
    }
}
