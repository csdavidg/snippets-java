package com.example.snippets.demo.java11;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleHandler {

    public static void main(String[] args) {
        Locale es = new Locale("en");
        Locale fr = new Locale("fr");

        welcomeMessage(es);
        welcomeMessage(fr);


    }

    public static void welcomeMessage(Locale locale) {
        var messages = ResourceBundle.getBundle("zoo", locale);


        System.out.println(messages.getString("hello") + " " + messages.getString("open"));
    }
}
