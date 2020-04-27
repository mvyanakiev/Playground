package fruitBoxes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class nestedLists {

    public static void main(String[] args) {
        List<String> mans = new ArrayList<>();
        List<String> woman = new ArrayList<>();
        List<String> pets = new ArrayList<>();

        mans.add("pesho");
        mans.add("ivan");
//        mans.add("angel");

        woman.add("ina");
        woman.add("ani");
        woman.add("katya");
//        woman.add("vanya");

        pets.add("cat");
        pets.add("dog");

        List<List<String>> lists = new ArrayList<>();
        lists.add(mans);
        lists.add(pets);
        lists.add(woman);


//        for (int i = 0; i < mans.size(); i++) {
//            for (int j = 0; j < woman.size(); j++) {
//
//                System.out.println(mans.get(i) + " " + woman.get(j));
//
//            }
//        }
        List<String> result = new ArrayList<>();

        generatePermutations(lists, result, 0, "");
//        var result = cartesianProductWithStreams(lists);
        result.forEach(System.out::println);
    }








    public static void generatePermutations(List<List<String>> lists, List<String> result, int depth, String current) {
        if (depth == lists.size()) {
            result.add(current);
            return;
        }

        for (int i = 0; i < lists.get(depth).size(); i++) {
            generatePermutations(lists, result, depth + 1, current + " " + lists.get(depth).get(i));
        }
    }






    private static <T> List<List<T>> flatMapper(List<List<T>> lists, List<T> list) {
        return list.stream().flatMap(t -> mapper(t, lists)).collect(toList());
    }

    public static <T> List<List<T>> cartesianProductWithStreams(List<List<T>> lists) {
        List<List<T>> start = new ArrayList<>();
        start.add(new ArrayList<>());
        return lists.stream().reduce(start, (a, b) -> flatMapper(a, b), (a, b) -> a);
    }

    private static <T> Stream<List<T>> mapper(T t, List<List<T>> lists) {
        return lists.stream()
                .map(list -> {
                    List<T> temp = new ArrayList<>(list);
                    temp.add(t);
                    return temp;
                });
    }
}