package test_tasks;

import java.util.Scanner;

import static java.lang.String.format;
// https://www.codingame.com
// hotmail / forums

public class ThereIsNoSpoon {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        if (in.hasNextLine()) {
            in.nextLine();
        }

        char[][] board = new char[height][width];

        for (int h = 0; h < height; h++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            for (int w = 0; w < width; w++) {
                board[h][w] = line.charAt(w);
            }
        }

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {

                if (board[h][w] == '0'
                    && h + 1 <= height - 1
                    && w + 1 <= width - 1
                    && board[h + 1][w] == '0'
                    && board[h][w + 1] == '0') {

                    System.out.println(format("%d %d %d %d %d %d", h, w, w + 1, h, w, h + 1));

                } else {
                    System.out.println(format("%d %d -1 -1 -1 -1", h, w));
                }
            }
        }
    }
}

//5
//4
//.....
//00...
//0.00.
//..0..