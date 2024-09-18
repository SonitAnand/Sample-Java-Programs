package org.example.sample2;

import java.util.Arrays;
import java.util.List;

public class StreamCount {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(23, 67, 84, 98, 100);
        System.out.println("Stream After applying the count() function: ");
        long count = integers.stream().count();
        System.out.println(count);

        long count1 = integers.stream().filter(i -> i > 90).count();
        System.out.println(count1);

    }
}
