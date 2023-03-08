package com.example.snippets.demo.others;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"})
public class Socks {

    /*@Setup
    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 10, 10, 30, 50, 10, 20, 10, 10, 40, 40};
        System.out.println(sockMerchant(arr.length, arr));
        System.out.println(sockMerchantSecondApproach(arr.length, arr));
        System.out.println(sockMerchantThirdApproach(arr.length, arr));
    }*/

    //@Benchmark
    public static int sockMerchantThirdApproach() {
        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20, 10, 10, 40, 40};
        return Arrays.stream(ar)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .map(v -> Math.toIntExact(v / 2))
                .reduce(0, Integer::sum);
    }
    //@Benchmark
    public static int sockMerchantSecondApproach() {
        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20, 10, 10, 40, 40};
        Map<Integer, Integer> pairs = new HashMap<>();
        for (int val : ar) {
            pairs.merge(val, 1, Integer::sum);
        }
        return pairs.values()
                .stream()
                .map(v -> Math.toIntExact(v / 2))
                .reduce(0, Integer::sum);
    }
    @Benchmark
    public static int sockMerchant() {
        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20, 10, 10, 40, 40};
        List<Integer> ints = Arrays.stream(ar).boxed().collect(Collectors.toList());
        int total = 0;
        for (int number : ar) {
            long cant = ints.stream().filter(i -> i.equals(number)).count();
            total += Math.toIntExact(cant / 2);
            ints.removeIf(x -> x.equals(number));
        }
        return total;
    }

}
