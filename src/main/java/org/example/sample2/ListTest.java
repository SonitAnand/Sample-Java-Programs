package org.example.sample2;

import java.util.*;
import java.util.stream.Collectors;

public class ListTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("6", "5", "2", "7", "6", "3", "4", "3", "8", "9", "6");
        System.out.println(list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()));
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        System.out.println(list.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting())).values().stream().max(Comparator.comparing(x -> x)).get());

        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        for (Map.Entry<String, Long> entry : map.entrySet())
            System.out.println("key " + entry.getKey() + " times " + entry.getValue());

        System.out.println(map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

        int max = 0;
        int curr = 0;
        String currKey = null;
        Set<String> uniqueList = new HashSet<>(list);
        for (String key : uniqueList) {
            curr = Collections.frequency(list, key);
            if (max < curr) {
                max = curr;
                currKey = key;
            }
        }
        System.out.println("the number " + currKey + " happens " + max + " times");
    }

}
