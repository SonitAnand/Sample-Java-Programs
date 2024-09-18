package org.example.sample2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringTest {

    public static void main(String[] args) {

        String str = "Sun rises in the east";
        String[] tempChar = str.split(" ");

        String longestString = "";
        int max = 0;
        for (int i = 0; i < tempChar.length; i++)
            if (tempChar[i].length() % 2 == 0 && tempChar[i].length() > max) {
                max = tempChar[i].length();
                longestString = tempChar[i];
            }
        System.out.println("longest even string :: " + longestString);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = tempChar.length - 1; i >= 0; i--) {
            stringBuilder.append(tempChar[i] + " ");
        }
        System.out.println("Reversed string as :: " + stringBuilder);

        String duplicateStr = "hello world";
        Map<Character, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < duplicateStr.length(); i++) {
            char letter = duplicateStr.charAt(i);
            if (resultMap.containsKey(letter)) {
                int count = resultMap.get(letter);
                count++;
                resultMap.put(letter, count);
            } else {
                resultMap.put(letter, 1);
            }
        }
        System.out.println("Duplicate character in string :: " + resultMap);

        System.out.println("Removed all vowels :: " + duplicateStr.replaceAll("[aeiou]", ""));

        Character vowels[] = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        List<Character> vowelList = Arrays.asList(vowels);
        StringBuffer stringBuffer = new StringBuffer(duplicateStr);
        for (int i = 0; i < duplicateStr.length(); i++) {
            if (vowelList.contains(duplicateStr.charAt(i))) {
                stringBuffer.replace(i, i + 1, "");
            }
        }
        System.out.println("Removed all vowels using buffer :: " + stringBuffer.toString());
    }
}
