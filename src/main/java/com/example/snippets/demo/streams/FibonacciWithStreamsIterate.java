package com.example.snippets.demo.streams;

import java.util.stream.Stream;

public class FibonacciWithStreamsIterate {

    public static void main(String[] args) {
        fibonacciJava8();
        fibonacciJava9AndFurther();
    }

    private static void fibonacciJava8() {
        System.out.println("JAVA 8 WITHOUT PREDICATE IN THE ITERATE METHOD");
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(20)
                .forEach(a -> System.out.println("(" + a[0] + "," + a[1] + ")"));
    }

    private static void fibonacciJava9AndFurther() {
        System.out.println("*******");
        System.out.println("*******");
        System.out.println("*******");
        System.out.println("JAVA 8 WITH PREDICATE IN THE ITERATE METHOD");

        Stream.iterate(new int[]{0, 1}, x -> x[1] <= 6765, n -> new int[]{n[1], n[0] + n[1]})
                .forEach(a -> System.out.println("(" + a[0] + "," + a[1] + ")"));
    }

}
