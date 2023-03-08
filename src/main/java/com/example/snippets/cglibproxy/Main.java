package com.example.snippets.cglibproxy;

public class Main {

    public static void main(String[] args) {
        ConcreteClass concreteClass = new ConcreteClass();
        ConcreteClassProxy proxy = new ConcreteClassProxy(concreteClass);
        ConcreteClass  concreteClassProxy = proxy.getConcreteClassUsingProxy();

        concreteClassProxy.firstMethod();
    }

}
