package org.example.sample1;

public class Palindrome {

    public static void main(String[] args) {

        String name = "racecars";
        for (int i = 0; i < name.length(); i++) {
            String value = new StringBuilder(name).deleteCharAt(i).toString();
            if (isPalindrome(value))
                System.out.println(value);
        }
    }

    private static boolean isPalindrome(String value) {
        return value.equals(new StringBuilder(value).reverse().toString());
    }
}
