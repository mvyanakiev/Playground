package fruitBoxes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CartesianProduct {

    public static void main(String... args) {
        int[][] input = { {1, 2}, {11, 22, 33}, {111, 222, 333, 444}, {99, 88, 77} };
//        var lL = fromInt2DToListOfLists(input);

        List<List<Integer>> lL = fromInt2DToListOfLists(input);
        var result = cartesianProductWithStreams(lL);
        result.forEach(System.out::println);
    }

    private static <T> Stream<List<T>> mapper(T t, List<List<T>> lists) {
        return lists.stream()
                .map(list -> {List<T> temp = new ArrayList<>(list); temp.add(t); return temp;})
                ;
    }

    private static <T> List<List<T>> flatMapper(List<List<T>> lists, List<T> list) {
        return list.stream().flatMap(t -> mapper(t, lists)).collect(toList());
    }

    public static <T> List<List<T>> cartesianProductWithStreams(List<List<T>> lists) {
        List<List<T>> start = new ArrayList<>();
        start.add(new ArrayList<>());
        return lists.stream().reduce(start, (a, b) -> flatMapper(a, b), (a, b) -> a);
    }

    private static List<List<Integer>> fromInt2DToListOfLists(int[][] input) {
        return Arrays.stream(input)
                .map(ar -> Arrays.stream(ar).boxed().collect(toList()))
                .collect(toList());
    }
}
