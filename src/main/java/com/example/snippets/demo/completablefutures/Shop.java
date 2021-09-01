package com.example.snippets.demo.completablefutures;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

    private final String name;
    private static Random random;

    public Shop(String name) {
        this.name = name;
        random = new Random();
    }

    public String getProductInfo(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[
                random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    public double getPrice(String product){
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product) {
        /*CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try{
                double price = calculatePrice(product);
                futurePrice.complete(price);
            }catch (Exception e){
                futurePrice.completeExceptionally(e);
            }
        }).start();
        return futurePrice;*/
        //This code does exactly the same as the one commented on above
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void randomDelay() {
        int delay = 500 + random.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void main(String[] args) {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime
                + " msecs");
        // Do some more tasks, like querying other shops
        // doSomethingElse();
        // while the price of the product is being calculated
        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    public String getName() {
        return name;
    }
}
