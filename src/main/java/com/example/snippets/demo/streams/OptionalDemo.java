package com.example.snippets.demo.streams;

import com.example.snippets.demo.dto.Car;
import com.example.snippets.demo.dto.Insurance;
import com.example.snippets.demo.dto.Person;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

public class OptionalDemo {

    private static final String CHEAPEST = "THE CHEAPEST";

    public static void main(String[] args) {


        Insurance insurance = new Insurance(null);
        Car car = new Car(Optional.ofNullable(insurance));
        Person person = new Person(Optional.ofNullable(car));

        Optional<Insurance> insuranceOpt = Optional.ofNullable(insurance);
        Optional<String> nameOpt = insuranceOpt.map(Insurance::getName);
        String name = insuranceOpt.map(Insurance::getName).orElse("MAP UNKNOWN NAME");
        System.out.println("USING OF MAP " + name);
        //person = new Person(Optional.of(new Car(Optional.of(new Insurance(null)))));
        //person = null;
        //EITHER CAR or INSURANCE ARE NULL THIS CHAIN WOULDN'T WORK BECAUSE IT WILL THROW AN NULL POINTER EXCEPTION
        //THEY MUST BE OPTIONALS EITHER EMPTY OR WITH THE CORRESPONDING OBJECT
        String insuranceName = Optional.ofNullable(person)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("-- FLATMAP UNKNOWN");

        System.out.println("GETTING INSURANCE NAME USING FLATMAP " + insuranceName);

        Optional<Optional<Car>> mapCarOptionalOptional = Optional.ofNullable(person).map(Person::getCar);
        System.out.println("Optional<Optional<Car>> RESULT " + mapCarOptionalOptional);

        Optional<Car> flatMapCarOptional = Optional.ofNullable(person).flatMap(Person::getCar);
        System.out.println("Optional<Car> RESULT " + flatMapCarOptional);

        Optional<Car> mapCarOptional = Optional.ofNullable(person).map(p -> p.getCar().get());
        System.out.println("Optional<Car> RESULT USING GET METHOD " + mapCarOptional);


        List<Person> personsList = new ArrayList<>();

        IntStream.range(1, 10).forEach(i -> {
            Insurance insurance1 = null;
            if (i % 2 == 0) {
                insurance1 = new Insurance("SECURITY" + i);
            }
            Car car1 = new Car(Optional.ofNullable(insurance1));
            Person person1 = new Person(Optional.ofNullable(car1));
            personsList.add(person1);
        });



        Set<String> collect = personsList.stream()
                .map(Person::getCar)
                .map(c -> c.flatMap(Car::getInsurance))
                .map(i -> i.map(Insurance::getName))
                .flatMap(Optional::stream)
                .collect(toSet());

        collect.forEach(System.out::println);

        Optional<Insurance> optInsurance = Optional.ofNullable(new Insurance(null));
        Optional<Car> optCar = Optional.ofNullable(new Car(optInsurance));
        Optional<Person> optPerson = Optional.ofNullable(new Person(Optional.ofNullable(car)));

        //Validating that neither object is null in order to call the getCheapestInsurance method with valid data
        if (optPerson.isPresent() && optCar.isPresent()) {
            Insurance cheapestInsurance = getCheapestInsurance(optPerson.get(), optCar.get());
        }

        //USING flatMap AND map, to avoid call the getCheapestInsurance method either Person = null or Car = null
        //This is the same process as the one done in the above validation
        Optional<Insurance> cheapestInsurance = optPerson.flatMap(p -> optCar.map(c -> getCheapestInsurance(p, c)));

        cheapestInsurance.ifPresentOrElse(i -> System.out.println("IF present OR ELSE This is the cheapest insurance " + i.getName()),
                () -> System.out.println("IF present OR ELSE NO PRESENT"));

        cheapestInsurance.filter(i -> CHEAPEST.equals(i.getName()))
                .ifPresent(i -> System.out.println("This is the cheapest insurance " + i.getName()));

        OptionalInt optInt = OptionalInt.of(10);

    }

    private static Insurance getCheapestInsurance(Person person, Car car) {
        return new Insurance(CHEAPEST);
    }
}
