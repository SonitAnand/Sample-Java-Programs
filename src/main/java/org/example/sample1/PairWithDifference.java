package org.example.sample1;

import java.util.Arrays;
import java.util.List;

public class PairWithDifference {
    public static void main(String[] args) {
        Integer numbers[] = {2, 4, 6, 9, 10};
        int diff = 2;
        System.out.println("------using for loop------");
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if ((numbers[i] - numbers[j] == diff || numbers[j] - numbers[i] == diff) && i != j)
                    System.out.println(numbers[i] + ":" + numbers[j]);
            }
        }
        System.out.println("------using list------");
        List<Integer> integerList = Arrays.asList(numbers);
        for (int i = 0; i < numbers.length; i++) {
            int check = numbers[i] - diff;
            if (integerList.contains(check) && check != diff)
                System.out.println(check + ":" + numbers[i]);
        }
        System.out.println("------using while loop------");
        findPair(numbers, diff);
    }

    static boolean findPair(Integer arr[], int n) {
        int size = arr.length;
        // Initialize positions of two elements
        int i = 0, j = 1;
        // Search for a pair
        while (i < size && j < size) {
            if (i != j && (arr[j] - arr[i] == n || arr[i] - arr[j] == n)) {
                System.out.print("Pair Found: " +
                        "( " + arr[i] + ", " + arr[j] + " )");
                return true;
            } else if (arr[j] - arr[i] < n)
                j++;
            else
                i++;
        }
        System.out.print("No such pair found");
        return false;
    }
}
