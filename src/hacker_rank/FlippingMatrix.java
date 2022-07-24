package hacker_rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlippingMatrix {
    public static void main(String[] args) {
        Integer[] line1 = {112, 42, 83, 119};
        Integer[] line2 = {56, 125, 56, 49};
        Integer[] line3 = {15, 78, 101, 43};
        Integer[] line4 = {162, 98, 114, 108};

        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(line1));
        arr.add(Arrays.asList(line2));
        arr.add(Arrays.asList(line3));

        System.out.println(flippingMatrix(arr));
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        return 0;
    }
}
