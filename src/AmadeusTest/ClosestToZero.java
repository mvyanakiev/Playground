package AmadeusTest;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

class ClosestToZero {

    public static int computeClosestToZero(int[] ts) {
        if (ts.length == 0) {
            return 0;
        }

        int currentValue = 0;
        int closestVal = ts[0];
        Arrays.sort(ts);

        for (int index = 0; index < ts.length; index++) {
            currentValue = ts[index] * ts[index];
            if (currentValue <= (closestVal * closestVal)) {
                closestVal = ts[index];
            }
        }
        return Math.abs(closestVal);
    }

    /* Ignore and do not change the code below */
    // #region main
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ts = new int[n];
        for (int i = 0; i < n; i++) {
            ts[i] = in.nextInt();
        }
        PrintStream outStream = System.out;
        System.setOut(System.err);
        int solution = computeClosestToZero(ts);
        System.setOut(outStream);
        System.out.println(solution);
    }
    // #endregion
}
