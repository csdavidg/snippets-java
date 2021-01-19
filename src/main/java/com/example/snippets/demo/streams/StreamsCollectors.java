package com.example.snippets.demo.streams;

import com.example.snippets.demo.dto.Dish;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class StreamsCollectors {

    public enum CaloricLevel {DIET, NORMAL, FAT}

    public static void main(String[] args) {
        List<Dish> specialMenu = asList(
                new Dish("pork", true, 900, Dish.Type.MEAT),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 300, Dish.Type.MEAT),
                new Dish("meat", false, 500, Dish.Type.MEAT),
                new Dish("salmon", true, 530, Dish.Type.OTHER));


        optionsToGetMaxValue(specialMenu);

        sumAverageAndSummarizingNumbers(specialMenu);

        groupingOptions(specialMenu);

        creatingCollections();

    }

    private static void groupingOptions(List<Dish> specialMenu) {
        /***
         * GROUPING
         */

        //GROUPING BY DISH.TYPE
        Map<Dish.Type, List<Dish>> typesMap = specialMenu.stream().collect(groupingBy(Dish::getType));
        System.out.println("TYPES MAP " + typesMap);

        //GROUPING BY CALORIC LEVEL
        Map<CaloricLevel, List<Dish>> caloricLevelListMap = specialMenu.stream().collect(groupingBy(StreamsCollectors::getCaloricLevel));

        System.out.println("CALORIC LEVEL MAP " + caloricLevelListMap);

        Map<String, List<Dish>> vegetarianMap = specialMenu.stream()
                .collect(groupingBy(dish -> (dish.isVegetarian()) ? "VEGETARIAN" : "NORMAL"));
        System.out.println("VEGETARIAN CLASSIFICATION " + vegetarianMap);

        Map<Dish.Type, List<Dish>> typeDishesMap = specialMenu.stream()
                .filter(d -> d.getCalories() > 500).collect(groupingBy(Dish::getType));
        System.out.println("FIRST MAPPING " + typeDishesMap);


        Map<Dish.Type, Set<Dish>> typeDishesMapSet = specialMenu.stream()
                .collect(groupingBy(Dish::getType,
                        filtering(d -> d.getCalories() > 500, toSet())));
        System.out.println("SECOND MAPPING" + typeDishesMapSet);

        Map<Dish.Type, List<String>> typeDishMapWithMapping = specialMenu.stream()
                .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
        System.out.println("USING MAPPING INSIDE GROUPING " + typeDishMapWithMapping);

        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("meat", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));

        List<String> allTags = dishTags.entrySet().stream()
                .flatMap(a -> a.getValue().stream()).collect(toList());

        List<String> allTagsUsingJustValues = dishTags.values().stream()
                .flatMap(Collection::stream).collect(Collectors.toList());

        Map<Dish.Type, Set<String>> tagsMap = specialMenu.stream()
                .collect(groupingBy(Dish::getType, flatMapping(d -> dishTags.get(d.getName()).stream(), toSet())));

        System.out.println("FLAT MAP EXAMPLE " + tagsMap);

        //MULTILEVEL GROUP
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> multiLevelGroup = specialMenu.stream().collect(groupingBy(Dish::getType,
                groupingBy(StreamsCollectors::getCaloricLevel)));

        System.out.println("MULTI LEVEL GROUP " + multiLevelGroup);

        Map<Dish.Type, Long> summingEachGroup = specialMenu.stream()
                .collect(groupingBy(Dish::getType, summingLong(Dish::getCalories)));
        System.out.println("SUMMING ALL CALORIES OF EACH TYPE " + summingEachGroup);

        //COUNTING EACH GROUP
        Map<Dish.Type, Long> countingGroupsMap = specialMenu.stream().collect(groupingBy(Dish::getType, counting()));

        System.out.println("AMOUNT OF EACH GROUP " + countingGroupsMap);

        Map<Dish.Type, Optional<Dish>> maxCaloriesMap = specialMenu.stream()
                .collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));

        System.out.println("MAX CALORIES DISHES " + maxCaloriesMap);

        Map<Dish.Type, Dish> maxCaloriesMapWithoutOptional = specialMenu.stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));

        System.out.println("MAX CALORIES WITHOUT OPTIONAL " + maxCaloriesMapWithoutOptional);

        Map<Dish.Type, Integer> dishesNamesJoinedLength = specialMenu.stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(mapping(Dish::getName, joining()), String::length)));

        System.out.println("LENGTH DISHES NAMES JOINED " + dishesNamesJoinedLength);

        Map<Dish.Type, Set<CaloricLevel>> caloricLevelMap = specialMenu.stream()
                .collect(groupingBy(Dish::getType, mapping(StreamsCollectors::getCaloricLevel, toSet())));

        System.out.println("DISH TYPES AND CALORIC LEVELS " + caloricLevelMap);

        System.out.println("AVAILABLE PROCESSORS " + Runtime.getRuntime().availableProcessors());
    }

    private static void creatingCollections() {
        Set<String> friends = new HashSet<>(Arrays.asList("Cristian", "David", "Sanchez"));
        Set<String> friends2 = Stream.of("Cristian", "David", "Sanchez").collect(toSet());

        List<String> friends3 = List.of("Cristian", "David", "Sanchez");

        List<String> cities = new ArrayList<>();
        cities.add("Bogota");
        cities.add("Medellin");
        cities.add("Barranquilla");

        cities.replaceAll(a -> a.startsWith("B") ? "REP" : a);
        cities.forEach(System.out::println);

        ConcurrentHashMap<Integer, String> numbers = new ConcurrentHashMap<>();
        numbers.put(1, "One");
        numbers.put(2, "Two");
        numbers.put(3, "Three");
        numbers.computeIfPresent(2, (k, v) -> v.toUpperCase());
        numbers.compute(2, (k, v) -> "SECOND");

        numbers.computeIfAbsent(4, (k) -> "FIRST " + k);

        //numbers.remove(1, "One");

        numbers.replace(1, "One", "FIRST");

        numbers.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    private static CaloricLevel getCaloricLevel(Dish dish) {
        if (dish.getCalories() <= 400) {
            return CaloricLevel.DIET;
        } else if (dish.getCalories() > 400 && dish.getCalories() <= 700) {
            return CaloricLevel.NORMAL;
        } else {
            return CaloricLevel.FAT;
        }

        //Diana Turbay, Bogota, Colombia - Carrera 3 este 49a - 08 sur
    }

    private static void sumAverageAndSummarizingNumbers(List<Dish> specialMenu) {
        Integer sumCalories = specialMenu.stream().collect(summingInt(Dish::getCalories));

        //CALCULATE CALORIES AVERAGE
        //Simplest way
        OptionalDouble caloriesAverageOpt = specialMenu.stream().mapToInt(Dish::getCalories).average();
        caloriesAverageOpt.ifPresent(a -> System.out.println("AVERAGE " + a));
        //Using collectors
        Double caloriesAverage = specialMenu.stream().collect(averagingInt(Dish::getCalories));

        //GETTING STATISTICS FROM A STREAM OF NUMBERS
        IntSummaryStatistics streamStatistics = specialMenu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println("STATISTICS " + streamStatistics);


        //JOINING STRINGS
        String allDishNames = specialMenu.stream().map(Dish::getName).collect(joining());
        System.out.println(allDishNames);

        //ADDING A SEPARATOR
        String allDishNamesSeparatedByComa = specialMenu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(allDishNamesSeparatedByComa);
    }

    private static void optionsToGetMaxValue(List<Dish> specialMenu) {
        Optional<Integer> max = specialMenu.stream()
                .map(Dish::getCalories)
                .max(Integer::compareTo);
        System.out.println("MAX CALORIES " + max.orElse(0));

        Optional<Integer> collectMax = specialMenu.stream()
                .map(Dish::getCalories)
                .collect(maxBy(Integer::compareTo));

        System.out.println("MAX CALORIES COLLECT " + collectMax.orElse(0));
    }
}
