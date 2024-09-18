package org.example.sample2;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NthHighestSalary {

    public static void main(String[] args) {

        // problem - find the second-highest salary of the employee

        // key-employee name and value-employee salary - type 1 input
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("anil", 1000);
        map1.put("bhavna", 1300);
        map1.put("micael", 1500);
        map1.put("tom", 1600);
        map1.put("ankit", 1200);
        map1.put("daniel", 1700);
        map1.put("james", 1400);
        Map.Entry<String, Integer> result1 = getNthHighestSalary(map1, 4);
        System.out.println("the Nth Highest Salary is " + result1);

        // key-employee name and value-employee salary - type 2 input
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("anil", 1000);
        map2.put("ankit", 1200);
        map2.put("bhavna", 1200);
        map2.put("james", 1200);
        map2.put("micael", 1000);
        map2.put("tom", 1300);
        map2.put("daniel", 1300);
        Map.Entry<Integer, List<String>> result2 = getNthHighestSalaryDynamic(map2, 2);
        System.out.println("the Nth Highest Salary is " + result2);
    }

    public static Map.Entry<String, Integer> getNthHighestSalary(Map<String, Integer> map1, int num) {
        return map1.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList())
                .get(num - 1);
    }

    public static Map.Entry<Integer, List<String>> getNthHighestSalaryDynamic(
            Map<String, Integer> map2, int num) {
        return map2.entrySet().stream()
                .collect(
                        Collectors.groupingBy(
                                Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList())
                .get(num - 1);
    }
}
