package com.example.snippets.demo.java11;

public class SwitchStatements {

    public static void main(String[] args) {

        int temperature = 4;
        long humidity = -temperature + temperature * 3;
        if (temperature >= 4)
        if (humidity < 6) System.out.println("Too Low");
        else System.out.println("Just Right");
        else System.out.println("Too High");


        int number = 200;
        final int otherCase = 100;
        final int otherNumber = 2;

        switch (number) {
            case 10:
                System.out.println(10);
                break;
            case 20 | 20:
                System.out.println(20);
                break;
            case 50:
            case 60:
                System.out.println(50 + " OR " + 60);
                break;
            case otherCase:
                System.out.println("OTHER CASE");
                break;
            case otherCase * otherNumber:
                System.out.println("THE GRATER VALUE");
                break;
            default:
                System.out.println("default");
                break;
        }


    }

}
