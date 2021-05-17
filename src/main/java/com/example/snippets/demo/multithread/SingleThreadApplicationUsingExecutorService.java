package com.example.snippets.demo.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SingleThreadApplicationUsingExecutorService extends LambdasForThreads {


    public static int counter;

    public static void main(String[] args) throws InterruptedException {
        /*firstExampleRunningThreadsWithStart();
        secondExampleUsingSingleThreadExecutor();
        thirdExampleUsingFutures();
        System.out.println(fourthExampleUsingCallable());
        System.out.println(fifthExampleAwaitsExecution());*/
        System.out.println(sixthExampleInvokeAll());
//        System.out.println(seventhExampleInvokeAny());
    }

    public static String seventhExampleInvokeAny() {
        ExecutorService es = null;
        try {
            es = Executors.newSingleThreadExecutor();
            List<Callable<Integer>> tasks = new ArrayList<>();
            tasks.add(addNumbersCallable);
            tasks.add(incrementCounterRunnable);
            tasks.add(addNumbersCallable);

            System.out.println("Before invoking invokeAny Method");
            return "The first ended task was = " + es.invokeAny(tasks);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (es != null) {
                es.shutdown();
            }
        }
        return "Seventh task finish with problems";
    }

    public static String sixthExampleInvokeAll() throws InterruptedException {
        ExecutorService es = null;
        try {
            es = Executors.newSingleThreadExecutor();
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (es != null) {
                es.shutdown();
            }
        }
        return "Sixth task finished";
    }

    public static String fifthExampleAwaitsExecution() throws InterruptedException {
        ExecutorService es = null;
        try {
            es = Executors.newSingleThreadExecutor();
            es.submit(addingTwoNumbersCallable);
            es.submit(incrementCounterRunnable);
            es.submit(addNumbersCallable);
        } finally {
            if (es != null) {
                es.shutdown();
            }
        }
        if (es != null) {
            es.awaitTermination(10, TimeUnit.SECONDS);
            if (es.isTerminated()) {
                System.out.println("Finished");
                return "After Waiting for results";
            } else {
                System.out.println("Still Running... ");
            }
        }
        return "Fifth task finished";
    }

    public static String fourthExampleUsingCallable() {
        ExecutorService es = null;
        try {
            es = Executors.newSingleThreadExecutor();
            Callable<Integer> addNumbers = addNumbersCallable;
            Future<Integer> result = es.submit(addNumbers);
            System.out.println(result.get());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (es != null) {
                es.shutdown();
            }
        }
        return "Fourth Task finished";
    }

    public static void thirdExampleUsingFutures() {
        ExecutorService es = null;
        try {
            es = Executors.newSingleThreadExecutor();
            Future<?> result = es.submit(new PrintDataRunnable());
            result.get(10, TimeUnit.SECONDS);
            System.out.println("Reached");
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            if (es != null) {
                es.shutdown();
            }
        }
    }

    public static void secondExampleUsingSingleThreadExecutor() {
        ExecutorService es = Executors.newSingleThreadExecutor();
        try {
            System.out.println("Begin");
            es.execute(new ReadInventoryThread());
            es.execute(new PrintDataRunnable());
            es.execute(new ReadInventoryThread());
            System.out.println("End");
        } finally {
            es.shutdown();
        }
    }

    public static void firstExampleRunningThreadsWithStart() {
        System.out.println("Begin");
        new ReadInventoryThread().start();
        new Thread(new PrintDataRunnable()).start();
        new ReadInventoryThread().start();
        System.out.println("End");


        System.out.println("Begin 2");
        (new ReadInventoryThread()).run();
        (new Thread(new PrintDataRunnable())).run();
        (new ReadInventoryThread()).run();
        System.out.println("End 2");
    }

}
