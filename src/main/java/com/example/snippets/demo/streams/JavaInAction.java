package com.example.snippets.demo.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaInAction {


    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950),
                null
        );

        List<Transaction> transactions2 = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400)
        );

        Stream.concat(transactions.stream(),transactions2.stream())
                        .forEach(System.out::println);

        System.out.println("CITIES");
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .forEach(System.out::println);

        System.out.println("2011 transaction values");
        transactions.stream().filter(a -> a.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);

        System.out.println("Cambridge names");
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(a -> a.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);


        System.out.println("JOIN NAMES");
        System.out.println(transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .collect(Collectors.joining()));

        System.out.println("IS THERE ANY IN MILAN");
        System.out.println(transactions
                .stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan")));

        System.out.println("All VALUES FROM CAMBRIDGE");
        transactions.stream()
                .filter(a -> a.getTrader().getCity().equals("Cambridge"))
                .forEach(t -> System.out.println(t.getValue()));

        System.out.println("MAX  ---- ");
        Optional<Transaction> max = transactions.stream().max(Comparator.comparing(Transaction::getValue));
        max.ifPresent(System.out::println);

        System.out.println("MIN  ---- ");
        Optional<Transaction> min = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        min.ifPresent(System.out::println);


    }

    public static class Trader {
        private final String name;
        private final String city;

        public Trader(String n, String c) {
            this.name = n;
            this.city = c;
        }

        public String getName() {
            return this.name;
        }

        public String getCity() {
            return this.city;
        }

        public String toString() {
            return "Trader:" + this.name + " in " + this.city;
        }
    }

    public static class Transaction {
        private final Trader trader;
        private final int year;
        private final int value;

        public Transaction(Trader trader, int year, int value) {
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        public Trader getTrader() {
            return this.trader;
        }

        public int getYear() {
            return this.year;
        }

        public int getValue() {
            return this.value;
        }

        public String toString() {
            return "{" + this.trader + ", " +
                    "year: " + this.year + ", " +
                    "value:" + this.value + "}";
        }
    }
}
