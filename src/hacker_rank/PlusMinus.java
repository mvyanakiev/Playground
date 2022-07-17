package hacker_rank;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class PlusMinus {
    public static void main(String[] args) {
        Integer[] testArray = {-4, 3, -9, 0, 4, 1};
        plusMinus(Arrays.asList(testArray));
    }

    public static void plusMinus(List<Integer> arr) {
        int negatives = 0;
        int positives = 0;
        int zeros = 0;

        for (Integer integer : arr) {
            if (integer < 0) {
                negatives++;
            } else if (integer > 0) {
                positives++;
            } else {
                zeros++;
            }
        }

        double size = arr.size() + 0.0;
        double positivesResult = positives / size;
        double negativesResult = negatives / size;
        double zerosResult = zeros / size;

        DecimalFormat df = new DecimalFormat("0.000000");
        df.setRoundingMode(RoundingMode.HALF_DOWN);

        System.out.println(df.format(positivesResult));
        System.out.println(df.format(negativesResult));
        System.out.println(df.format(zerosResult));
    }
}
