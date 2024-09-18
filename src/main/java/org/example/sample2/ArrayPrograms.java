package org.example.sample2;

import java.util.Arrays;

import static java.lang.System.out;

public class ArrayPrograms {

    public static void main(String[] args) {
        int[] array1 = {2, 4, 6, 2};
        int[] array2 = {4, 1, 2, 6};
        out.println("arrays equality check is " + checkArraysEqual(array1, array2));

        int[] array3 = {0, 1, 1, 0, 1, 0, 0};
        out.println("aggregated arrays is " + Arrays.toString(aggregate0sAnd1s(array3)));

        out.println("checking for prime is " + primeNumberCheck(8));

        fibonacciSeries(10);

        int factorial = factorialFunction(5);
        out.println("factorial is " + factorial);
    }

    private static boolean checkArraysEqual(int[] array1, int[] array2) {
        boolean areEqual = true;
        if (array1.length != array2.length) {
            areEqual = false;
        }
        Arrays.sort(array1);
        Arrays.sort(array2);
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                areEqual = false;
                break;
            }
        }
        return areEqual;
    }

    private static int[] aggregate0sAnd1s(int[] array3) {
        int count = 0;
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] == 0) {
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            array3[i] = 0;
        }
        for (int i = count; i < array3.length; i++) {
            array3[i] = 1;
        }
        return array3;
    }

    private static boolean primeNumberCheck(int value) {
        boolean isPrime = true;
        if (value <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= value / 2; i++) {
                if (value % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime;
    }

    private static void fibonacciSeries(int value) {
        //0 1 1 2 3 5
        int num1 = 0;
        int num2 = 1;
        int counter = 0;
        while (counter < value) {
            out.println(num1 + " ");
            int num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
            counter++;
        }
    }

    private static int factorialFunction(int num) {
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    private static int factorialRecussiveFunction(int num) {
        if (num == 0) {
            return 1;
        } else {
            return (num * factorialFunction(num - 1));
        }
    }
}
