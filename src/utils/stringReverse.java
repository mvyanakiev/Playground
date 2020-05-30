package utils;

public class stringReverse {

    public static void main(String[] args) {

        String snake = "SURLDAS";
        String result = "S";

        for (int i = snake.length()-1; i >= 1 ; i--) {
            result += snake.charAt(i);
        }

        System.out.println(snake);
        System.out.println(result);
    }


}
