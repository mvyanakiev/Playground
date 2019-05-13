import java.util.Arrays;

import static java.util.Arrays.copyOf;

public class v1 {

    public static void main(String[] args) {

        int[] arr1 = {2, 11, 8, 10, 12};
        int[] arr2 = {2, 11, 8, 10};
        int[] result = notPresent(arr1, arr2);

        for (int i : result) {
            System.out.println(i);
        }
    }


    public static int[] notPresent(int[] arr1, int[] arr2) {

        int[] answer = new int[1];
        int index = 0;

        for (int i : arr1) {

            if (!Arrays.stream(arr2).anyMatch(x -> x == i)) {

                if (index == 0) {
                    answer = copyOf(answer, index+2);
                } else {
                    answer = copyOf(answer, index+1);
                }

                answer[index] = i;
                index++;
            }
        }
        return answer;
    }
}

