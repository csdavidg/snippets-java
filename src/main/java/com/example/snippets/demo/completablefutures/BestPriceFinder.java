package com.example.snippets.demo.completablefutures;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BestPriceFinder {

    private static final String PRODUCT_NAME = "MyPhone27S";

    private static List<Shop> buildShops() {
        return IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Shop("Shop - " + i))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Shop> shops = buildShops();

        System.out.println(Runtime.getRuntime().availableProcessors());

        long start = System.nanoTime();
        //findPrices(shops, PRODUCT_NAME);
        List<String> pricesAsync = findPricesAsync(shops, PRODUCT_NAME);
        System.out.println(pricesAsync);
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs \n\n\n\n\n\n\n");


        long startSecondExample = System.nanoTime();
        CompletableFuture[] futures = findPricesStreamAsync(shops, "myPhone27S")
                .map(f -> f.thenAccept(
                        s -> System.out.println(s + " (done in " +
                                ((System.nanoTime() - start) / 1_000_000) + " msecs)")))
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futures).join(); // wait for all CompletableFutures passed have completed
        //CompletableFuture.anyOf(futures).join();// returns a CompletableFuture<Object> that completes with the same value as the first-to-complete CompletableFuture
        System.out.println("All shops have now responded in "
                + ((System.nanoTime() - startSecondExample) / 1_000_000) + " msecs");


    }

    public static List<String> findPrices(List<Shop> shops, String product) {
        return shops.stream()
                .parallel()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getProductInfo(product)))
                .collect(toList());
    }

    public static List<String> findPricesAsync(List<Shop> shops, String product) {

        final Executor executor =
                Executors.newFixedThreadPool(Math.min(shops.size(), 100),
                        (Runnable r) -> {
                            Thread t = new Thread(r);
                            t.setDaemon(true);
                            return t;
                        }
                );

        List<CompletableFuture<String>> completableFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getProductInfo(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(
                        () -> Discount.applyDiscount(quote), executor)))
                .map(future -> future.thenCombine(CompletableFuture.supplyAsync(Currency::addCurrency)
                                        .completeOnTimeout("EUR", 2, TimeUnit.SECONDS), // Use a default VALUE whether the exchange service doesn't provide a result in 2 seconds or the time defined.
                                (productInfo, currency) -> productInfo + " price is in " + currency)
                        .orTimeout(3, TimeUnit.SECONDS)) // Make the Future throw a Timeout-Exception if not completed after 3 seconds. Asynchronous timeout management was added in Java 9.
                .collect(toList());

        return completableFutures.stream()
                /*.map(cf -> {
                    try{
                        return cf.get();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    return "";
                })*/
                // The join() method has the same meaning as the get() method
                // The difference is that join() doesn't have checked exceptions
                .map(CompletableFuture::join)
                .collect(toList());
    }

    public static Stream<CompletableFuture<String>> findPricesStreamAsync(List<Shop> shops, String product) {

        final Executor executor =
                Executors.newFixedThreadPool(Math.min(shops.size(), 100),
                        (Runnable r) -> {
                            Thread t = new Thread(r);
                            t.setDaemon(true);
                            return t;
                        }
                );

        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getProductInfo(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(
                        () -> Discount.applyDiscount(quote), executor)))
                .map(future -> future.thenCombine(CompletableFuture.supplyAsync(Currency::addCurrency)
                                        .completeOnTimeout("EUR", 2, TimeUnit.SECONDS), // Use a default VALUE whether the exchange service doesn't provide a result in 2 seconds or the time defined.
                                (productInfo, currency) -> productInfo + " price is in " + currency)
                        .orTimeout(3, TimeUnit.SECONDS)); // Make the Future throw a Timeout-Exception if not completed after 3 seconds. Asynchronous timeout management was added in Java 9.
    }

    public static String applyDiscount(String spd) {
        Quote quote = Quote.parse(spd);
        return Discount.applyDiscount(quote);
    }

}
