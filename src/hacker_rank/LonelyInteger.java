package hacker_rank;

import java.util.*;

public class LonelyInteger {
    public static void main(String[] args) {
        Integer[] testArray = {59, 88, 14, 8, 85, 1, 94, 74, 57, 96, 39, 2, 47, 43, 35, 17, 53, 52, 92, 31, 99, 48, 94, 30, 92, 60, 32, 45, 88, 13, 39, 50, 22, 65, 89, 46, 65, 76, 57, 67, 99, 35, 76, 46, 85, 82, 45, 62, 53, 80, 74, 22, 31, 52, 82, 13, 41, 96, 2, 1, 80, 62, 4, 20, 50, 89, 59, 67, 60, 8, 41, 14, 47, 48, 17, 4, 43, 30, 32};
        System.out.println(lonelyInteger(Arrays.asList(testArray)));
    }

    public static int lonelyInteger(List<Integer> a) {
        Collections.sort(a);

        for (int i = 1; i < a.size(); i += 2) {
            if (a.get(i - 1).intValue() != a.get(i).intValue()) {
                return a.get(i - 1);
            }
        }
        return a.get(a.size()-1);
    }
}
