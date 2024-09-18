package org.example.sample2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.out;

public class StringPrograms {

    public static void main(String[] args) {

        String inputString = "Welcome To Java";

        // find the duplicate characters in string
        HashMap<Character, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) != ' ') {
                if (tempMap.containsKey(inputString.charAt(i))) {
                    int count = tempMap.get(inputString.charAt(i));
                    tempMap.put(inputString.charAt(i), ++count);
                } else {
                    tempMap.put(inputString.charAt(i), 1);
                }
            }
        }

        tempMap.forEach((key, value) -> {
            if (value > 1) out.println(key);
        });

        // find longest non repeating string
        String str = "abcdasde";
        String str1 = "";
        String str2 = "";
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (charSet.contains(str.charAt(i))) {
                charSet.clear();
                str1 = "";
            }
            charSet.add(str.charAt(i));
            str1 = str1 + str.charAt(i);
            if (str1.length() > str2.length()) str2 = str1;
        }
        out.println(str2);

        //Java Program to convert upper Case to lower Case and Vice-versa
        StringBuilder stringBuilder = new StringBuilder(inputString);
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (Character.isLowerCase(inputString.charAt(i))) {
                stringBuilder.setCharAt(i, Character.toUpperCase(inputString.charAt(i)));
            } else {
                stringBuilder.setCharAt(i, Character.toLowerCase(inputString.charAt(i)));
            }
        }
        out.println("converted string is " + stringBuilder.toString());

    }
}
