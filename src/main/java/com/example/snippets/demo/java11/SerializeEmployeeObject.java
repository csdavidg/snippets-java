package com.example.snippets.demo.java11;

import com.example.snippets.demo.java11.zoo.Employee;
import com.example.snippets.demo.java11.zoo.Gorilla;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SerializeEmployeeObject {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        var values = new ArrayList<Integer>();
        values.add(4);
        values.add(4);
        values.set(1,6);
        values.remove(0);
        for (var v : values) System.out.print(v);

        

        /*Path employeeSerialized = Paths.get("c:", "data_IO", "employee.txt");
        Employee employee = new Employee();
        employee.setAge(20);
        employee.setName("Luis");
        employee.setSsn("124324345");

        saveToFile(employee, employeeSerialized.toFile());

        System.out.println("Deserialized value: " + readFromFile(employeeSerialized.toFile()));*/


    }

    private static void saveToFile(Employee employee, File dataFile) throws IOException {
        try (var out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dataFile)))) {
            out.writeObject(employee);
        }
    }


    private static Employee readFromFile(File dataFile) throws IOException,
            ClassNotFoundException {
        try (var in = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(dataFile)))) {

            var object = in.readObject();
            if (object instanceof Employee)
                return (Employee) object;
            else
                throw new IllegalArgumentException("The object serialized is not an employee");

        }
    }

}
