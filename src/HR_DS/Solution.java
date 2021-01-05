package HR_DS;

import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/2d-array/problem?h_r=next-challenge&h_v=zen

public class Solution {
    static int hourglassSum(int[][] arr) {

        int result = 0;

        for (int row = 0; row <= 3; row++) {
            for (int col = 0; col <= 3; col++) {

                int current = checkHourglass(arr, row, col);

                if (current > result) {
                    result = current;
                }
            }
        }

        return result;
    }

    private static int checkHourglass(int[][] arr, int row, int col) {

        int res = 0;

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                res += arr[i][j];
            }
        }

        res = res - arr[row + 1][col] - arr[row + 1][col + 2];

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);
    private static final int ARR_SIZE = 6;

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/HR_DS/file.txt"));

        int[][] arr = new int[ARR_SIZE][ARR_SIZE];

        for (int i = 0; i < ARR_SIZE; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < ARR_SIZE; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

//        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
