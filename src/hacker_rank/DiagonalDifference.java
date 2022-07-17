package hacker_rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {
    public static void main(String[] args) {
        Integer[] line1 = {1, 2, 3};
        Integer[] line2 = {4, 5, 6};
        Integer[] line3 = {9, 8, 9};

        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(line1));
        arr.add(Arrays.asList(line2));
        arr.add(Arrays.asList(line3));

        System.out.println(diagonalDifference(arr));
    }

    public static int diagonalDifference(List<List<Integer>> arr) {

        int lToR = 0;
        int rToL = 0;
        for (int i = 0; i < arr.size(); i++) {
            lToR = lToR + arr.get(i).get(i);
            rToL = rToL + arr.get(i).get(arr.size()-i-1);
        }
        return Math.abs(rToL-lToR);
    }
}
