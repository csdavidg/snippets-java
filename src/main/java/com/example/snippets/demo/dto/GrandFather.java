package com.example.snippets.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class GrandFather {

    protected String protectedVariable = "GranFather-Protected";
    public String publicVariable = "GranFather-Public";
    String defaultVariable = "GranFather-Default";
    String justInGranFather = "GranFather-JustInGranFather";

    public int getHeight() { return 3; }
    public void printInfo() {
        System.out.print(this.getHeight());
    }
}





class Father extends GrandFather {

    protected String protectedVariable = "Father-Protected";
    public String publicVariable = "Father-Public";
    String defaultVariable = "Father-Default";

    static {
        System.out.print("A");
    }

    protected List<CharSequence> printValues(List<CharSequence> chars) {
        return new ArrayList<>();
    }

    public static void hiddenMethod(){
        System.out.println("Father HiddenMethod");
    }

    public int getHeight() { return 4; }

    public static void main(String[] args) {
        new Father().printInfo();
        new GrandFather().printInfo();
    }
}










class Child extends Father {
    static {
        System.out.print("B");
    }

    public static void hiddenMethod(){
        System.out.println("Child HiddenMethod");
    }

    final int age;

    public Child(int age) {
        super();
        this.age = age;
    }

    public Child() {
        this(10);
    }

    public List<CharSequence> printValues(List<CharSequence> chars) {
        final int age;
        System.out.println(this.protectedVariable + " " + super.justInGranFather);
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.print("C");
        Child.hiddenMethod();
        Father.hiddenMethod();
    }

}