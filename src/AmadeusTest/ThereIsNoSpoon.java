package AmadeusTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.format;

public class ThereIsNoSpoon {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        if (in.hasNextLine()) {
            in.nextLine();
        }

        int[][] board = new int[height][width];
        List<int[]> potential = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                String inp = in.nextLine();

                if (".".equalsIgnoreCase(inp)) {
                    board[j][i] = 0;
                } else if ("0".equalsIgnoreCase(inp)) {
                    board[j][i] = 1;
                    if (j-1 >= 0 && board[j-1][i] == 1) {
                        potential.add(new int[]{j-1, i});
                    }
                }


            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (board[j][i] == 1 && j + 1 <= width - 1 && i + 1 <= height - 1) {
                    if (board[j + 1][i] == 1 && board[j][i + 1] == 1) {
                        System.out.println(format("%d %d %d %d %d %d", j, i, j + 1, i, j, i + 1));
                    }
                } else {
                    System.out.println(format("%d %d -1 -1 -1 -1", j, i));
                }
            }
        }
    }
}
