package com.example.snippets.demo.dto;

import java.util.Optional;

public class Person {

    private Optional<Car> car;

    public Person(Optional<Car> car) {
        this.car = car;
    }

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }
}
