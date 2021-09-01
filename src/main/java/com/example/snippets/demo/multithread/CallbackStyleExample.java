package com.example.snippets.demo.multithread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;

public class CallbackStyleExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int x = 1337;
        Result result = new Result();

        /*f(x, (int y) -> {
            result.left = y;
            System.out.println("FX" + (result.left + result.right));
        } );

        g(x, (int z) -> {
            result.right = z;
            System.out.println("GX" +(result.left + result.right));
        });*/

        CompletableFuture<Integer> first = new CompletableFuture<>();
        CompletableFuture<Integer> second = new CompletableFuture<>();
        CompletableFuture<Integer> combineResults = first.thenCombine(second, Integer::sum);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(() -> first.complete(f(x)));
        executorService.submit(() -> second.complete(g(x)));

        System.out.println("The result is " + combineResults.get());


    }

    private static int f(int number){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number;
    }

    private static int g(int number){
        return number;
    }

    private static void f(int number, IntConsumer callback){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        callback.accept(number);
    }

    private static void g(int number, IntConsumer callback){
        callback.accept(number);
    }

    private static class Result {
        private int left;
        private int right;
    }
}