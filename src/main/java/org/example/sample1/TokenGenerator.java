package org.example.sample1;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class TokenGenerator {

    protected static SecureRandom random = new SecureRandom();

    public static void main(String[] args) throws Exception {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 100000; i++) {
            String token = UUID.randomUUID().toString().toUpperCase().replace("-", "");
            if (set.contains(token))
                throw new Exception("Error");
            set.add(token);
            //System.out.println(token);
        }
        System.out.println("Complete with UUID");

        Set<String> set1 = new HashSet<>();
        for (int i = 0; i < 100000; i++) {
            String generatedString = whenGeneratingRandomAlphaString();
            if (set1.contains(generatedString))
                throw new Exception("Error");
            set1.add(generatedString);
            //System.out.println(generatedString);
        }
        System.out.println("String generated");

        Set<String> set2 = new HashSet<>();
        for (int i = 0; i < 100000; i++) {
            String str = whenGeneratingRandomAlphanumericString();
            if (set2.contains(str))
                throw new Exception("Error");
            set2.add(str);
            //System.out.println(str);
        }
        System.out.println("AlphanumericString generated");

        Set<String> set3 = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            String str = whenGeneratingRandomNumericString();
            if (set3.contains(str))
                throw new Exception("Error");
            set3.add(str);
            //System.out.println(str);
        }
        System.out.println("NumericString generated");
    }

    public static String whenGeneratingRandomAlphanumericString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        return generatedString;
    }

    public static String whenGeneratingRandomAlphaString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        return generatedString;
    }

    public static String whenGeneratingRandomNumericString() {
        int leftLimit = 48; // letter '0'
        int rightLimit = 57; // letter '9'
        int targetStringLength = 10;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        return generatedString;
    }
}
