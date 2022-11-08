package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://www.baeldung.com/java-bifunction-interface

public class Learning {
    public static void main(String[] args) {

        // single parameter
        List<String> mapped = Stream.of("hello", "world")
            .map(word -> word + "!")
            .collect(Collectors.toList());

        for (String s : mapped) {
            System.out.println(s);
        }

        // The reduce function uses the functional interface BinaryOperator<T>, which takes two objects of the *same type* as its inputs.
        String result = Stream.of("hello1", "world1")
            .reduce("", (a, b) -> a + "-" + b);
        System.out.println(result);

        result = Stream.of("hello2", "world2").reduce("", (a, b) -> combineWithoutTrailingDash(a, b));
        System.out.println(result);

        // with method reference
        result = Stream.of("hello3", "world3").reduce("", Learning::combineWithoutTrailingDash);
        System.out.println(result);


        // Using BiFunction
        // The BiFunction interface allows us to use parameters of *different types*.
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<Integer> list2 = Arrays.asList(1, 2, 3);

        List<String> biResult = new ArrayList<>();
        for (int i=0; i < list1.size(); i++) {
            biResult.add(list1.get(i) + list2.get(i));
        }

        for (String s : biResult) {
            System.out.println(s);
        }


        // We can generalize this specialized function using a BiFunction as the combiner:
        List<String> listString = Arrays.asList("x", "y", "z");
        List<Integer> listInt = Arrays.asList(9, 8, 7);

        List<String> biLambdaResult = listCombiner(listString, listInt, (letter, number) -> letter + number);
        for (String s : biLambdaResult) {
            System.out.println(s);
        }


        // with an extracted method and a method reference:
        List<Double> list3 = Arrays.asList(1.0d, 2.5d, 3.3d);
        List<Float> list4 = Arrays.asList(0.5f, 0.1f, 7.6f);

        List<Boolean> biLambdaResultBool = listCombiner(list3, list4, Learning::firstIsGreaterThanSecond);
        for (Boolean s : biLambdaResultBool) {
            System.out.println(s);
        }


        // Another example -> подаваш 2 аргумента и функция
        List<Float> list5 = Arrays.asList(0.1f, 0.2f, 4f);
        List<Float> list6 = Arrays.asList(0.1f, 5.3f, 4f);

        List<Boolean> resultCompare = listCombiner(list5, list6, (float1, float2) -> float1.equals(float2));
        for (Boolean s : resultCompare) {
            System.out.println(s);
        }

        // Понеже Float има в себе си equals, можеш да го ползваш като method reference
        resultCompare = listCombiner(list5, list6, Float::equals);
        for (Boolean s : resultCompare) {
            System.out.println(s);
        }

        // compareTo връща int
        List<Integer> toCompare = listCombiner(list5, list6, Float::compareTo);
        for (Integer integer : toCompare) {
            System.out.println(integer);
        }


        // ако искаме тези int-ове да ги направим булеви, можем да използваме .andThen
        List<Boolean> toBool = listCombiner(list5, list6, asBiFunction(Float::compareTo)
            .andThen(i -> i > 0));
        
        for (Boolean aBoolean : toBool) {
            System.out.println(aBoolean);
        }
    }

    private static <T, U, R> List<R> listCombiner(
        List<T> list1, List<U> list2, BiFunction<T, U, R> combiner) {
        List<R> result = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            result.add(combiner.apply(list1.get(i), list2.get(i)));
        }
        return result;
    }

    private static <T, U, R> BiFunction<T, U, R> asBiFunction(BiFunction<T, U, R> function) {
        return function;
    }

    private static String combineWithoutTrailingDash(String a, String b) {
        if (a.isEmpty()) {
            return b;
        }
        return a + "-" + b;
    }

    private static boolean firstIsGreaterThanSecond(Double a, Float b) {
        return a > b;
    }
}
