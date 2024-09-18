package org.example.sample1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ConcurrentMapClass {

    public static void main(String[] args) {
        Map<String, Integer> tempMap = new ConcurrentHashMap<>();
        tempMap.put("abc", 1);
        tempMap.put("bcd", 11);
        tempMap.put("cde", 111);
        System.out.println(tempMap.size());

        for (Map.Entry<String, Integer> entry : tempMap.entrySet()) {
            System.out.println("key :: " + entry.getKey() + " value :: " + entry.getValue());
            tempMap.put("abcdef", 1111);
        }
        System.out.println(tempMap.size());
        LinkedHashMap<String, Integer> linkedHashMap = tempMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(linkedHashMap);
    }

}
