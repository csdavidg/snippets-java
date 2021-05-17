package com.example.snippets.demo.streams;

import lombok.Data;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdasExamples {

    class Animal<T>{
        T name;

        public T getAnimal(){
            return name;
        }
    }

    static class Dog {//implements Comparable<Dog> {
        Integer id;
        String breed;

        public <T> String getDogBreed(T param){
            return param.toString();
        }

        public Dog(int id, String breed) {
            this.id = id;
            this.breed = breed;
        }

        public Integer getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBreed() {
            return breed;
        }

        public void setBreed(String breed) {
            this.breed = breed;
        }

        /*@Override
        public int compareTo(Dog o) {
            return this.breed.compareTo(o.getBreed());
        }*/
    }

    public static void main(String[] args) {

        Dog d1 = new Dog(1, "Puddle");
        Dog d2 = new Dog(2, "Puddle");
        Dog d3 = new Dog(1, "Bull");

        Comparator<Dog> compareDogs1 = Comparator.comparing(Dog::getBreed);

        Set<Dog> dogsSet = new TreeSet<>(compareDogs1);

        dogsSet.add(d1);
        dogsSet.add(d2);
        dogsSet.add(d3);

        dogsSet.forEach(d -> System.out.println(d.getBreed()));

        Map<Dog, Integer> mapDogs = new TreeMap<>(compareDogs1);

        mapDogs.put(d1, d1.getId());
        mapDogs.put(d2, d2.getId());
        mapDogs.put(d3, d3.getId());

        System.out.println("MAP RESULTS");
        mapDogs.entrySet().forEach(System.out::println);

        var names = Arrays.asList("Fluffy", "Hoppy");
        Comparator<String> c = Comparator.reverseOrder();
        var index = Collections.binarySearch(names, "Hoppy", c);
        System.out.println(index);

        List<String> strings = Arrays.asList("zbcd", "xbab", "dasdaf", "asdasweqer", "aasfghwe");

        Comparator<Dog> compareDogs = Comparator.comparingInt(Dog::getId);


        int compare = compareDogs.compare(d1, d3);

        System.out.println(" Result " + compare + " " + (compare == 0 ? "EQUALS" : (compare > 0 ? "1 is Grater" : "2 is Grater")));

//        Function<String, Integer> function = (s) -> s.length();
        Function<String, Integer> function = String::length;
//        Comparator<String> comparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());
//        Comparator<String> comparator = Comparator.comparing(String::length);
        Comparator<String> comparator = customComparing(String::length);
        Collections.sort(strings, comparator.reversed());

        strings.forEach(System.out::println);

        var variable = "HOLA";
        Predicate<String> checkFirstLetter = variable::startsWith;

        if (checkFirstLetter.test("H")) {
            System.out.println("Starts with H");
        } else {
            System.out.println("Other Letter");
        }

        BiPredicate<String, String> biFunction = String::startsWith;

        if (biFunction.test(variable, "H")) {
            System.out.println("BP Starts with H");
        } else {
            System.out.println("BP Other Letter");
        }

        Set<Integer> setMembers = new HashSet<>();
        setMembers.add(1);
        setMembers.add(2);
        setMembers.add(3);
        setMembers.add(4);
        setMembers.add(1);
        setMembers.add(5);
        setMembers.add(6);
        setMembers.add(7);
        setMembers.add(8);
        setMembers.forEach(System.out::println);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.offer(30);
        queue.offer(50);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println("LOOP STARTS HERE");
        queue.forEach(System.out::println);

        Map<String, Integer> numbersMap = new HashMap<>(Map.ofEntries(
                Map.entry("Two", Integer.valueOf("2")),
                Map.entry("Three", Integer.valueOf("3"))));

        Integer one = numbersMap.putIfAbsent("one", null);
        System.out.println(one);

        Integer oneAgain = numbersMap.putIfAbsent("one", Integer.valueOf("1"));
        System.out.println("OneAgain " + oneAgain);

        Integer two = numbersMap.putIfAbsent("Two", Integer.valueOf("20"));
        System.out.println(two);

        Integer four = numbersMap.putIfAbsent("Four", Integer.valueOf("4"));
        System.out.println(four);

        numbersMap.forEach(LambdasExamples::printKeyValues);
    }

    public static void printKeyValues(String k, Integer v) {
        System.out.println(k + " : " + v);
    }

    static Comparator<String> customComparing(Function<String, Integer> var0) {
        Objects.requireNonNull(var0);
        return (String s1, String s2) -> var0.apply(s1).compareTo(var0.apply(s2));
        /*return (Comparator)((Serializable)((var1x, var2x) -> {
            return ((Comparable)var0.apply(var1x)).compareTo(var0.apply(var2x));
        }));*/
        //6.45 - 8.50 - 7.12

    }


}
