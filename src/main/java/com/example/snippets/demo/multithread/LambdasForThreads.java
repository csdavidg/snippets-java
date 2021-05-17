package com.example.snippets.demo.multithread;

import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class LambdasForThreads {

    public static final Callable<Integer> addNumbersCallable =
            () -> IntStream.rangeClosed(0, 100)
                    .peek(System.out::println)
                    .sum();

    /*public static final Runnable incrementCounterRunnable = () ->
            IntStream.rangeClosed(0, 200)
                    .forEach(i -> {
                        System.out.println(SingleThreadApplicationUsingExecutorService.counter++);
                    });*/

    public static final Callable<Integer> incrementCounterRunnable = () -> {
        IntStream.rangeClosed(0, 200)
                .forEach(i -> {
                    System.out.println(SingleThreadApplicationUsingExecutorService.counter++);
                });
        return SingleThreadApplicationUsingExecutorService.counter;
    };


    public static final Callable<Integer> addingTwoNumbersCallable =
            () -> {
                System.out.println("ADDING 11 + 30");
                return 30 + 11;
            };

}
