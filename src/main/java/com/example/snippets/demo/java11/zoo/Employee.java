package com.example.snippets.demo.java11.zoo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.concurrent.Callable;

public class Employee implements Serializable {

    private String name;
    private int age;
    private String ssn;

    // defines the fields that can be included in the serialization process
    // If they don't appear here then can't be serialized
    private static final ObjectStreamField[] serialPersistentFields =
            {new ObjectStreamField("name", String.class),
                    new ObjectStreamField("ssn", String.class)};

    private static String encrypt(String input) {
        return "encrypt" + input;
    }

    private static String decrypt(String input) {
        return input.replace("encrypt", "Y");
    }

    private void writeObject(ObjectOutputStream s) throws Exception {
        ObjectOutputStream.PutField fields = s.putFields();
        fields.put("name", name);
        fields.put("ssn", encrypt(ssn));
        fields.put("age", age); //Throws Exception IllegalArgumentException: no such field age with type int
        // The fields must appear in the serialPersistentFields array, if they are not there an exception is thrown
        s.writeFields();
    }

    private void readObject(ObjectInputStream s) throws Exception {
        ObjectInputStream.GetField fields = s.readFields();
        this.name = (String) fields.get("name", null);
        this.ssn = decrypt((String) fields.get("ssn", null));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
