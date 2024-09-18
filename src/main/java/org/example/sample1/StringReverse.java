package org.example.sample1;

import java.util.*;

public class StringReverse {

    public static void main(String[] args) {
        String str = new String("SonitAnand");
        StringBuilder build = new StringBuilder();
        build.append(str);
        System.out.println(build.reverse());

        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }
        System.out.println(reverse);

        System.out.println("palindrome ==================== palindrome");
        //palindrome concept
        String str1 = "madam";
        String str2 = "Nitin";
        System.out.println(str1.equals(new StringBuilder(str1).reverse().toString()) ? "Yes" : "No");
        System.out.println(str2.equals(new StringBuilder(str2).reverse().toString()) ? "Yes" : "No");

        System.out.println("HashMap ==================== HashMap");
        //HashMap
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("abc", "Sonit");
        map.put("bcd", "Rohit");
        map.put("cde", "Anand");
        for (Map.Entry<String, String> hh : map.entrySet()) {
            System.out.println(hh.getKey());
            System.out.println(hh.getValue());
        }
        System.out.println("Set ==================== Set");
        //Set
        Set<String> set = new HashSet<String>();
        set.add("Sonit");
        set.add("Mohit");
        Iterator<String> setIterator = set.iterator();
        while (setIterator.hasNext()) {
            System.out.println(setIterator.next());
        }

        set.forEach(System.out::println);
    }

    /*
     * public String output(int a,String b) { String result = ""; char[] ar = new
     * char[10+b.length()]; String str = a.toString(); for(int i=0;i<10;i++) {
     * if(i<str.length()) { ar[i] = str.charAt(i); } else ar[i] = ' '; } result =
     * Character.toString(ar); StringBuilder builder = new StringBuilder(result);
     * builder.append(b); return builder.toString(); }
     */
}
