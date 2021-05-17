package com.example.snippets.demo.multithread;

import java.util.stream.IntStream;

public class PrintDataRunnable implements Runnable{


    @Override
    public void run() {
        IntStream.rangeClosed(0, 499)
                .forEach(i -> {
                    System.out.println(SingleThreadApplicationUsingExecutorService.counter++);
                });
    }

    public static void main(String[] args) {
        new Thread(new PrintDataRunnable()).start();
    }
}
