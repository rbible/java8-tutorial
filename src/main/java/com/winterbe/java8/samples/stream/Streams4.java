package com.winterbe.java8.samples.stream;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @author Benjamin Winterberg
 */
public class Streams4 {

    public static void main(String[] args) {

        outprint("\nfor:");
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }

        outprint("\nforeach:");
        IntStream.range(0, 10).forEach(i -> {
            if (i % 2 == 1) System.out.println(i);
        });

        outprint("\nforeach2:");
        IntStream.range(0, 10).filter(i -> i % 2 == 1).forEach(System.out::println);

        outprint("\nreduce:");
        OptionalInt reduced1 = IntStream.range(0, 10).reduce((a, b) -> a + b);
        System.out.println(reduced1.getAsInt());

        outprint("\nreduce2:");
        int reduced2 = IntStream.range(0, 10).reduce(6, (a, b) -> a + b);
        System.out.println(reduced2);
    }

    private static void outprint(String message) {
        System.out.println(message);
    }

}
