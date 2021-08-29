package com.example.snippets.demo.java11;

import java.util.HashMap;
import java.util.stream.Stream;

public class JavaPerformanceTest {

    public static void main(String[] args) {
        Stream.iterate("_", s -> !s.isEmpty(), a -> a + a)
                .forEach(JavaPerformanceTest::printValueGenerated);
    }

    private static void printValueGenerated(String s) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HashMap<String, Integer> dummyObject = new HashMap<>();
        System.out.println(s);
    }

}

interface Hello {
    void say();
}

class Tester {

    public static void main(String[] args) {
        Hello test = Tester::saySomething;
        test.say();
    }

    private static void saySomething() {
        System.out.println("Say Something");
    }

    private static void say() {
        System.out.println("Wathever");
    }

}