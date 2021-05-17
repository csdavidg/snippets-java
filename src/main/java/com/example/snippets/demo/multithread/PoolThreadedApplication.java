package com.example.snippets.demo.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PoolThreadedApplication extends LambdasForThreads {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
//        System.out.println(firstExampleUsingCachedThreadPool());
        System.out.println(secondExampleUsingFixedThreadPool());
    }

    public static String secondExampleUsingFixedThreadPool() throws InterruptedException {
        ExecutorService es = null;
        try {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            es = Executors.newFixedThreadPool(availableProcessors);
            Future<Integer> firstProcess = es.submit(addingTwoNumbersCallable);
            Future<Integer> secondProcess = es.submit(incrementCounterRunnable);
            Future<Integer> thirdProcess = es.submit(addNumbersCallable);

            System.out.println(firstProcess.get());
            System.out.println(secondProcess.get());
            System.out.println(thirdProcess.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            if (es != null) {
                es.shutdown();
            }
        }
        return "Second task finished";
    }

    public static String firstExampleUsingCachedThreadPool() throws InterruptedException {
        ExecutorService es = null;
        try {
            es = Executors.newCachedThreadPool();
            List<Callable<Integer>> tasks = new ArrayList<>();

            tasks.add(addingTwoNumbersCallable);
            tasks.add(incrementCounterRunnable);
            tasks.add(addNumbersCallable);

            List<Future<Integer>> futures = es.invokeAll(tasks);
            System.out.println("####################################");
            futures.forEach(f -> {
                try {
                    System.out.println("Result " + f.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        } finally {
            if (es != null) {
                es.shutdown();
            }
        }
        return "First task finished";
    }
}
