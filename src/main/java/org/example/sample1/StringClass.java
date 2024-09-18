package org.example.sample1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StringClass {

    public static void main(String[] args) {

        String value = "helloworld";

        System.out.println(value.replaceAll("[aeiou]", ""));

        Map<Character, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < value.length(); i++) {
            char tempChar = value.charAt(i);
            if (map.containsKey(tempChar)) {
                int count = map.get(tempChar);
                count++;
                map.put(tempChar, count);
            } else
                map.put(tempChar, 1);
        }
        System.out.println(map);

        /*for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1)
                map.remove(entry.getKey());
        }*/


        map.entrySet().stream().forEach(entry -> {
            int temp = entry.getValue();
            if (temp > 1)
                map.remove(entry.getKey());
        });
        System.out.println(map);

        String inputString = "Hello world to Java Programming";

        System.out.println(new StringBuilder(inputString).reverse().toString());

        String result = "";
        for (int i = inputString.length() - 1; i >= 0; i--) {
            result += inputString.charAt(i);
        }
        System.out.println(result);

        String reverseString = "";
        String[] splitString = inputString.split(" ");
        for (int i = 0; i < splitString.length; i++) {
            String word = splitString[i];
            String reverseWord = "";
            for (int j = word.length() - 1; j >= 0; j--) {
                reverseWord = reverseWord + word.charAt(j);
            }
            reverseString = reverseString + reverseWord + " ";
        }
        System.out.println(reverseString);

        int first = 0;
        int second = 1;
        int third = 0;
        System.out.print(first + " " + second + " ");

        for (int i = 0; i < 10; i++) {
            third = first + second;
            System.out.print(third + " ");
            first = second;
            second = third;
        }
    }
}
