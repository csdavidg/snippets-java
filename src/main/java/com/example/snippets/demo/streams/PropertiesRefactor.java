package com.example.snippets.demo.streams;

import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

public class PropertiesRefactor {

    public static void main(String[] args) {

        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        System.out.println(Objects.equals(5, readDuration(props, "a")));
        System.out.println(Objects.equals(0, readDuration(props, "b")));
        System.out.println(Objects.equals(0, readDuration(props, "c")));
        System.out.println(Objects.equals(0, readDuration(props, "d")));
    }

    public static int readDuration(Properties props, String name) {
        return Optional.ofNullable(props.get(name))
                .flatMap(s -> stringToInt((String) s))
                .filter(num -> num > 0)
                .orElse(0);
    }

    public static Optional<Integer> stringToInt(String number) {
        try {
            return Optional.of(Integer.parseInt(number));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

}
