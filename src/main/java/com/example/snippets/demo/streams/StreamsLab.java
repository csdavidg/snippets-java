package com.example.snippets.demo.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;


public class StreamsLab {

    public static void main(String[] args) throws Exception {
        int table[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9, 0}};
        Arrays.stream(table).forEach(System.out::println);

        List<Integer> collect = Arrays.stream(table)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toList());

        List<List<Integer>> twoDimensionList = List.of(
                List.of(1, 2, 3, 4),
                List.of(5, 6, 7, 8),
                List.of(9, 10, 11)
        );

        twoDimensionList.stream().flatMap(Collection::stream).forEach(System.out::println);

        System.out.println("COMPLEX STREAMS SECTION");
        complexStream();

        System.out.println("AVERAGE");
        mapToObjectPrimitiveStreams();
    }


    public static void complexStream() {
        JavaInAction.Trader raoul = new JavaInAction.Trader("Raoul", "Cambridge");
        JavaInAction.Trader mario = new JavaInAction.Trader("Mario", "Milan");
        JavaInAction.Trader alan = new JavaInAction.Trader("Alan", "Cambridge");
        JavaInAction.Trader brian = new JavaInAction.Trader("Brian", "Cambridge");
        List<JavaInAction.Transaction> transactions = Arrays.asList(
                new JavaInAction.Transaction(brian, 2011, 300),
                new JavaInAction.Transaction(raoul, 2012, 1000),
                new JavaInAction.Transaction(raoul, 2011, 400),
                new JavaInAction.Transaction(mario, 2012, 710),
                new JavaInAction.Transaction(mario, 2012, 700),
                new JavaInAction.Transaction(alan, 2012, 950),
                null
        );

        List<JavaInAction.Transaction> transactions2 = Arrays.asList(
                new JavaInAction.Transaction(brian, 2011, 300),
                new JavaInAction.Transaction(raoul, 2012, 1000),
                new JavaInAction.Transaction(raoul, 2011, 400)
        );

        /*Stream.of(transactions.stream(), transactions2.stream(), transactions2.stream())
                .flatMap(Function.identity())
                .mapToInt(JavaInAction.Transaction::getYear)
                .forEach(System.out::println);*/
    }

    public static void mapToObjectPrimitiveStreams() {
        long[] stamps2 = {205286400, 791726400, 978307200, 1582165220};
        Arrays.stream(stamps2).mapToObj(Date::new).forEach(System.out::println);

        OptionalDouble collect = Arrays.stream(stamps2)
                .mapToInt(s -> new Date(s * 1000).getYear())
                .average();
        collect.ifPresent(System.out::println);

    }

    public static void joinStringsToJsonArray(){
        String cities[] = { "Boston", "Denver", "Atlanta", "Chicago" };
        String json = Arrays.stream(cities).collect(Collectors.joining("\", \"", "[ \"", "\" ]"));
        System.out.println(json);


    }

    public static void collectionMethods(){
        /*System.out.println("\nBirthday names only by month:");
        Map bdayNames =
                Arrays.stream(people).collect(
                        Collectors.groupingBy(Person::getMonthName,
                                Collectors.mapping(p -> p.getName(), Collectors.toList())));
        printMap(bdayNames);*/
    }

}
