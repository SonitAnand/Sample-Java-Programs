package org.example.sample2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayProblems {

  public static void main(String[] args) {

    // problem 1 - find the second-highest number from given array
    int[] numbers = {5, 9, 11, 21, 2, 8, 21, 1};
    int secondHighestNumber =
        Arrays.stream(numbers)
            .boxed()
            .distinct()
            .sorted(Comparator.reverseOrder())
            .skip(1)
            .findFirst()
            .get();
    System.out.println("second-highest number from given array: " + secondHighestNumber);
    int secondLowestNumber = Arrays.stream(numbers).boxed().sorted().skip(1).findFirst().get();
    System.out.println("second-lowest number from given array: " + secondLowestNumber);

    // problem 2 - find the longest string from a given array
    String[] stringArray = {"Java", "Spring", "SpringBoot", "Microservices"};
    Optional<String> longestString =
        Arrays.stream(stringArray)
            .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
    System.out.println("longest string from a given array: " + longestString.get());
    System.out.println(
        "length of longest string: "
            + Arrays.stream(stringArray).mapToInt(str -> str.length()).max().orElse(0));

    // problem 3 - find all elements from array who starts with 1
    int[] numbers1 = {5, 9, 11, 21, 2, 8, 21, 1};
    List<String> elementStartsWithOne =
        Arrays.stream(numbers1)
            .boxed()
            .map(String::valueOf)
            .filter(x -> x.startsWith("1"))
            .collect(Collectors.toList());
    System.out.println("all elements from array who starts with 1: " + elementStartsWithOne);

    // problem 4 - find the common element between two arrays
    int[] array1 = {1, 2, 3, 4, 5};
    int[] array2 = {4, 5, 6, 7, 8, 1};
    List<Integer> commonElement =
        Arrays.stream(array1)
            .filter(num1 -> Arrays.stream(array2).anyMatch(num2 -> num2 == num1))
            .boxed()
            .collect(Collectors.toList());
    System.out.println("the common element between two arrays: " + commonElement);

    // problem 5 - reverse an array on integers in-place
    int[] array3 = {1, 2, 3, 4, 5};
    IntStream.range(0, array3.length / 2)
        .forEach(
            i -> {
              int temp = array3[i];
              array3[i] = array3[array3.length - i - 1];
              array3[array3.length - i - 1] = temp;
            });
    System.out.println("reverse an array on integers in-place: " + Arrays.toString(array3));

    // problem 6 - add two arrays and sort it
    int[] arr1 = {2, 5, 3, 9};
    int[] arr2 = {7, 15, 13, 8};
    int[] arr3 = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray();
    System.out.println("added two arrays: " + Arrays.toString(arr3));

    // problem 7 - program for even numbers
    List<Integer> evenNumbers =
        IntStream.range(2, 20).filter(num -> num % 2 == 0).boxed().collect(Collectors.toList());
    System.out.println("even numbers from 0 to 10 are: " + evenNumbers);

    // problem 8 - program for prime numbers
    List<Integer> primeNumbers =
        IntStream.range(2, 20)
            .filter(number -> IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0))
            .boxed()
            .collect(Collectors.toList());
    System.out.println("prime numbers from 0 to 20 are: " + primeNumbers);
  }
}
