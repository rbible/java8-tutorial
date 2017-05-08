package com.winterbe.java8.samples.optionals;

import java.util.Optional;

/**
 * @author Benjamin Winterberg
 */
public class Optional1 {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");

        System.out.println(optional.isPresent()); // true
        System.out.println(optional.get()); // "bam"
        System.out.println(optional.orElse("fallback")); // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0))); // "b"

        Optional<String> optional2 = Optional.ofNullable(".");

        System.out.println(optional2.isPresent());  
        System.out.println(optional2.get()); 
        System.out.println(optional2.orElse("fallback"));  
    }
}