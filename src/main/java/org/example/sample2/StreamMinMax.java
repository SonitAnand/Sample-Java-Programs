package org.example.sample2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamMinMax {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(23, 67, 84, 98, 100);
        System.out.println("Stream After applying the min() function: ");
        Integer min1 = integers.stream().min(Comparator.comparing(Integer::intValue)).get();
        Integer min2 = integers.stream().min(Comparator.reverseOrder()).get();
        System.out.println(min1);
        System.out.println(min2);

        System.out.println("Stream After applying the max() function: ");
        Integer max1 = integers.stream().max(Comparator.comparing(Integer::intValue)).get();
        Integer max2 = integers.stream().max(Comparator.reverseOrder()).get();
        System.out.println(max1);
        System.out.println(max2);

        System.out.println("second highest number");
        Optional<Integer> second = integers.stream().sorted(Comparator.reverseOrder()).limit(3).skip(2).findFirst();
        System.out.println(second.get());

    }
}
