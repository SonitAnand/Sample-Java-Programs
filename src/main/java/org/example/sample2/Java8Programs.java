package org.example.sample2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Java8Programs {
    public static void main(String[] args) {

        //add two arrays
        int[] array1 = {2, 4, 6, 2};
        int[] array2 = {4, 1, 2, 6};
        int[] array3 = IntStream.concat(Arrays.stream(array1), Arrays.stream(array2)).sorted().toArray();
        out.println(Arrays.toString(array3));

        String str = "welcome to the java world java";

        // convert string to uppercase
        out.println(Stream.of(str).map(String::toUpperCase).collect(Collectors.joining(" ")));

        //reverse whole string
        out.println(Stream.of(str).map(word -> new StringBuilder(word).reverse()).collect(Collectors.joining(" ")));

        //reverse each word in string
        out.println(Stream.of(str.split(" ")).map(word -> new StringBuilder(word).reverse()).collect(Collectors.joining(" ")));

        //find occurrence of each word
        out.println(Stream.of(str.split(" ")).collect(Collectors.groupingBy(word -> word, Collectors.counting())));

        //find occurrence of each character
        Map<Character, Long> eachCharacter = str.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
        out.println(eachCharacter);
        Map<String, Long> charCount = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        out.println(charCount);

        Map<String, Integer> tempMap = Map.of("key1", 101, "key3", 109, "key2", 107);

        //sort a map
        Map<String, Integer> sortedMap = tempMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        out.println(sortedMap);

        //generate random numbers
        Random random = new Random();
        random.ints(0, 50).limit(5).forEach(out::println);

        //find the string whose length is greater than 5
        List<String> stringList = Arrays.asList("welcome", "technology", "java", "come", "to", "backspace");
        long count = stringList.stream().filter(str1 -> str1.length() > 5).count();
        out.println("greater than length count: " + count);

        //check frequency of each word and print whose count >= 2
        List<String> stringList1 = Arrays.asList("AA", "BB", "CC", "AA", "DD", "CC", "AA");
        Map<String, Long> frequencyCheck = stringList1.stream().filter(word -> Collections.frequency(stringList1, word) > 1)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        out.println("check frequency of each word: " + frequencyCheck);

        //find the minimum and maximum numbers
        List<Integer> integerList = Arrays.asList(2, 4, 1, 3, 6, 9, 7);
        Optional<Integer> min = integerList.stream().min(Integer::compare);
        Optional<Integer> max = integerList.stream().max((x1, x2) -> x1 - x2);
        OptionalDouble avg = integerList.stream().mapToInt(n -> n * n).average();
        min.ifPresent(integer -> out.println("minimum number is " + integer));
        max.ifPresent(integer -> out.println("maximum number is " + integer));
        avg.ifPresent(integer -> out.println("average number is " + integer));
    }

}

