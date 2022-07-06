package test_tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) {

        int[] input = new int[] { 1, 2, 3, 11, 2, 85, 5, 7, 0, 11, 7, 9, 11 };
        Arrays.sort(input);

        List<Integer> resultList = new ArrayList<>();
        resultList.add(input[0]);

        for (int i = 1; i < input.length; i++) {
            if (input[i] != input[i - 1]) {
                resultList.add(input[i]);
            }
        }

        resultList.stream().forEach(i -> System.out.println(i));
    }
}
