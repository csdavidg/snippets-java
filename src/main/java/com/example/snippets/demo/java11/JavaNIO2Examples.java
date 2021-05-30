package com.example.snippets.demo.java11;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaNIO2Examples {

    public static void main(String[] args) throws URISyntaxException {
        Path path1 = Path.of("c:\\data_IO\\gorilla.txt");
        System.out.println("Path as usual " + path1);

        Path path = Path.of("c:", "data_IO", "gorilla.txt");
        System.out.println("Path VarArgs " + path);

        Path pathWithPathsClass = Paths.get( "c:", "data_IO", "gorilla.txt");
        System.out.println("Using get method from Paths class " + pathWithPathsClass);

        var p = Paths.get("/mammal/omnivore/raccoon.image");
        System.out.println("Path is: " + p);
        for (int i = 0; i < p.getNameCount(); i++) {
            System.out.println("   Element " + i + " is: " + p.getName(i));
        }
        System.out.println();
        System.out.println("subpath(0,3): " + p.subpath(0, 3));
        System.out.println("subpath(1,2): " + p.subpath(1, 2));
        System.out.println("subpath(1,3): " + p.subpath(1, 3));

    }


}
