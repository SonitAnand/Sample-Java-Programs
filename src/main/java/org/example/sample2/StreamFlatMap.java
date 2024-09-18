package org.example.sample2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMap {
    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(7, 8, 9);
        System.out.println("Stream Before applying the flatmap() function: ");
        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
        System.out.println(listOfLists);

        System.out.println("Stream After applying the flatmap() function: ");
        List<Integer> listOfAllIntegers = listOfLists.stream().flatMap(num -> num.stream()).collect(Collectors.toList());
        System.out.println(listOfAllIntegers);

    }
}
