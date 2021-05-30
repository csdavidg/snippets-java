package com.example.snippets.demo.java11;

import com.example.snippets.demo.java11.zoo.Gorilla;

import java.io.*;

public class SerializeGorillaObject {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File gorillaSerialized = new File("c:\\data_IO\\gorilla.txt");
        Gorilla gorilla = new Gorilla();
        gorilla.setAge(10);
        gorilla.setFriendly(Boolean.TRUE);
        gorilla.setName("COCO");
        gorilla.setFavoriteFood("Banana");//marked transient

        saveToFile(gorilla, gorillaSerialized);

        System.out.println("Deserialized value: " + readFromFile(gorillaSerialized));


    }

    private static void saveToFile(Gorilla gorilla, File dataFile) throws IOException {
        try (var out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dataFile)))) {
            out.writeObject(gorilla);
        }
    }


    private static Gorilla readFromFile(File dataFile) throws IOException,
            ClassNotFoundException {
        try (var in = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(dataFile)))) {

            var object = in.readObject();
            if (object instanceof Gorilla)
                return (Gorilla) object;
            else
                throw new IllegalArgumentException("The object serialized is not a Gorilla");

        }
    }

}
