package com.winterbe.java8.samples.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author Benjamin Winterberg
 */
public class LambdaArraySort {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        lambda4Sort(names, Collections.reverseOrder());
        System.out.println(names);


        usualSort(names);
        System.out.println(names);
        lambda1Sort(names);
        System.out.println(names);
        lambda2Sort(names);
        System.out.println(names);
        lambda3Sort(names);
        System.out.println(names);


        List<String> names2 = Arrays.asList("peter", null, "anna", "mike", "xenia");
        lambda4Sort(names2, Comparator.nullsLast(String::compareTo));
        System.out.println(names2);


        List<String> names3 = Arrays.asList("2", "1");
        lambda5Sort(names3);
        System.out.println(names3);
    }

    private static void lambda5Sort(List<String> names3) {
        Optional.ofNullable(names3).ifPresent(list -> list.sort(Comparator.naturalOrder()));
    }

    private static void lambda4Sort(List<String> names2, Comparator<String> c) {
        names2.sort(c);
    }

    /**
     * simple
     */
    private static void lambda3Sort(List<String> names) {
        Collections.sort(names, (a, b) -> a.compareTo(b));
    }

    /**
     * parameter type
     */
    private static void lambda2Sort(List<String> names) {
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
    }

    /**
     * method body
     */
    private static void lambda1Sort(List<String> names) {
        Collections.sort(names, (String a, String b) -> {
            return a.compareTo(b);
        });
    }

    private static void usualSort(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
    }

}