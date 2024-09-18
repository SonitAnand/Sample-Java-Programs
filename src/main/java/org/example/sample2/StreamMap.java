package org.example.sample2;

import java.util.Arrays;
import java.util.List;

public class StreamMap {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(23, 67, 84, 98, 100);
        System.out.println("Stream After applying the map() function: ");
        integers.stream().map(number -> number * 2).forEach(System.out::println);

    }
}
