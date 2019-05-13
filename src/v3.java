import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.copyOf;

public class v3 {

    public static void main(String[] args) {

        int[] arr1 = {2, 11, 8, 10};
        int[] arr2 = {2, 11, 4, 9};
        int[] result = notPresent(arr1, arr2);

            for (int i : result) {
                System.out.println(i);
        }
    }

    private static int[] notPresent(int[] arr1, int[] arr2) {
        List<Integer> tempList = new ArrayList<>();

        for (int i : arr1) {
            if (!Arrays.stream(arr2).anyMatch(x -> x == i)) {
                tempList.add(i);
            }
        }

        int[] answer = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
           answer[i] = tempList.get(i);
        }
        return answer;
    }
}

