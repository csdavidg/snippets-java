package com.example.snippets.demo.java11;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LabelsTests {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            LD: if (i >= 2) {
                System.out.println("BEFORE LAB");
                LAB: if (i == 3) {
                    break LAB;
                }
                System.out.println("AFTER LAB");
            }
        }

        StringBuilder sb = new StringBuilder("nim");
        String word = " \t\nan imal\n\t ";

        System.out.println(word.replace("al", sb));

        System.out.println("TRIM " + word.trim());
        System.out.println("STRIP " + word.strip());
        System.out.println("LEADING " + word.stripLeading());
        System.out.println("TRAILING " + word.stripTrailing());

        Set<String> s = Set.of("mickey", "minnie");
        List<String> x = new ArrayList<>(s);

        s.forEach(ss -> System.out.println(ss));
        x.forEach(xx -> System.out.println(xx));

    }

    public void method(Integer charSequence){

    }

    public void method(int string){

    }



}
