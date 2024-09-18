package org.example.sample2;

import java.util.stream.IntStream;

public class StreamVsParallelStream {
    public static void main(String[] args) {

        long start = 0;
        long end = 0;

        /*start = System.currentTimeMillis();
        IntStream.range(1, 100).forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("Time with plain stream: " + (end - start));

        start = System.currentTimeMillis();
        IntStream.range(1, 100).parallel().forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("Time with parallel stream: " + (end - start));*/

        IntStream.range(1, 10).forEach(i -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + " : " + i);
        });

        IntStream.range(1, 10).parallel().forEach(i -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + " : " + i);
        });
    }
}
