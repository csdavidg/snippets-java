package com.example.snippets.demo;

public class RefactoringUsingLambdas {

    public static void changingAnonymousClass() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        Runnable lambdaExpression = () -> System.out.println("Hello");

    }

}
