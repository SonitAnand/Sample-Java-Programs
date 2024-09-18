package org.example.sample2;

import java.util.Arrays;
import java.util.List;

public class StreamToArray {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(23, 67, 84, 98, 100);
        System.out.println("Stream After applying the toArray() function: ");
        Object[] array = integers.stream().filter(i -> i < 50).toArray();
        for (Object o : array) {
            System.out.println(o);
        }
    }
}
