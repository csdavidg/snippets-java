package com.example.snippets.demo.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriplesFlatMap {

    public static void main(String[] args) {

        Stream<int[]> triples = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b,
                                        (int) Math.sqrt(a * a + b * b)}));

        triples.forEach(b -> {
            for (int j : b) {
                System.out.print(j);
                System.out.print(",");
            }
            System.out.println("");
        });

        Stream<double[]> triplesOptimized = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .mapToObj(b -> new double[]{a, b,
                                        Math.sqrt(a * a + b * b)})
                ).filter(c -> c[2] % 1 == 0);

    }


}
