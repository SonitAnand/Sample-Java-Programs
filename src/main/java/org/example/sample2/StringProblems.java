package org.example.sample2;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringProblems {

    public static void main(String[] args) {

        String str = "WelcomeToJava";

        // problem 1 - count the occurrence of each character in string
        Map<String, Long> characterOccurrences =
                Arrays.stream(str.split(""))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("occurrence of each character: " + characterOccurrences);

        // problem 2 - find all duplicate elements from a given string
        List<String> duplicateElements =
                Arrays.stream(str.split(""))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(map -> map.getValue() > 1) // for unique element use map.getValue() == 1
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());
        System.out.println("all duplicate elements: " + duplicateElements);

        // problem 3 - find first non repeat element from a given string
        String firstNonRepeatElement =
                Arrays.stream(str.split(""))
                        .collect(
                                Collectors.groupingBy(
                                        Function.identity(), LinkedHashMap::new, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(
                                map -> map.getValue() == 1) // for first repeating character use map.getValue() > 1
                        .findFirst()
                        .get()
                        .getKey();
        System.out.println("find first non repeat element: " + firstNonRepeatElement);

        // String.join method example
        List<String> stringList = Arrays.asList("hey", "how", "are", "you");
        String joinedValue = String.join("-", stringList);
        System.out.println(joinedValue);
    }
}
