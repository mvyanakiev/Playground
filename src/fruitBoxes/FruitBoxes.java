package fruitBoxes;

import java.util.ArrayList;
import java.util.List;

public class FruitBoxes {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(-10);
        list.add(7);
        list.add(1);
        list.add(3);
        list.add(-5);
        list.add(6);

        int max = 0;
        int positionOfMax = 0;

        for (int i = 0; i < list.size(); i++) {
            positionOfMax = i + 1;
            max += list.get(i);

            int rest = 0;

            for (int j = i + 1; j < list.size(); j++) {
                rest += list.get(j);
            }

            if (max + rest < max) {
                break;
            }
        }

        System.out.println();
        if (max > 0) {
            System.out.println("Max = " + max + " | " + "Boxes to buy: " + positionOfMax);
        } else {
            System.out.println("Do not buy anything");
        }
    }
}
