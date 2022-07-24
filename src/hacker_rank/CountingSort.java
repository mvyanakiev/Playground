package hacker_rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountingSort {
    public static void main(String[] args) {
        Integer[] testArray = {1,1,3,2,1};
        List<Integer> result = countingSort(Arrays.asList(testArray));

        for (int i = 0; i < testArray.length; i++) {
            System.out.println(result.get(i));
        }
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(100, 0));

        for (int i = 0; i < arr.size(); i++) {
            Integer member = arr.get(i);
            result.set(member, result.get(member)+1);
        }
        return result;
    }
}
