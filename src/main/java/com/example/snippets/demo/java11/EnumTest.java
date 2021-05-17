package com.example.snippets.demo.java11;

public class EnumTest {

    public static void main(String[] args) {

        for (Season s : Season.values()){
            System.out.println(s + " : " + s.ordinal());
        }

        Season summer = Season.SUMMER;
        switch (summer) {
            case WINTER:
                System.out.println("Get out the sled!");
                break;
            case SUMMER:
                System.out.println("Time for the pool!");
                break;
            default:
                System.out.println("Is it summer yet?");
        }
    }
}
