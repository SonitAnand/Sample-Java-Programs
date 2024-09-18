package org.example.sample2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(23, 67, 84, 98, 100);
        System.out.println("Stream After applying the filter() function: ");
        integers.stream().filter(i -> i > 85).collect(Collectors.toList()).forEach(System.out::println);
        integers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList()).forEach(System.out::println);

    }
}
