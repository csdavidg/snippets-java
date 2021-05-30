package com.example.snippets.demo.java11;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInteractions {

    public static void main(String[] args) throws IOException {
        Console console = System.console();
        if (console != null) {
            String userInput = console.readLine();
            console.writer().println("Value entered:" + userInput);
        } else {
            System.err.println("Console not available");
        }

        UserInteractions ui = new UserInteractions();
        ui.checkConsoleInsideInsta();


        var reader = new BufferedReader(new InputStreamReader(System.in));
        String lineRead = reader.readLine();
        System.out.println("You entered: " + lineRead);


    }

    public void checkConsoleInsideInsta() {
        Console console = System.console();
        if (console != null) {
            String userInput = console.readLine();
            console.writer().println("Value entered:" + userInput);
        } else {
            System.err.println("Console not available inside instance methods neither");
        }
    }


}
