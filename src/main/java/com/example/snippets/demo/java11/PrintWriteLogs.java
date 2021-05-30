package com.example.snippets.demo.java11;

import com.example.snippets.demo.java11.zoo.Gorilla;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriteLogs {

    public static void main(String[] args) throws FileNotFoundException {
        printWriterMethod();

    }

    private static void printWriterMethod() throws FileNotFoundException {

        try (PrintWriter out = new PrintWriter("c:\\data_IO\\LION.txt")) {
            out.write(String.valueOf(5));  // Writer method
            out.print(5);                  // PrintWriter method

            var a = new Gorilla();
            out.write(a == null ? "null" : a.toString()); // Writer method
            out.print(a);                              // PrintWriter method
        }
    }


}
