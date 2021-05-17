package com.example.snippets.demo.java11;

public class NestedInnerClassesTest {

    public static void staticMethod() {
        NestedInnerClassesTest nit = new NestedInnerClassesTest();
    }

    public static void main(String[] args) {
        A a = new A();

        A.B b = a.new B();
        A.B b2 = a.new B();

        A.B.C c = b.new C();
        A.B.C c2 = b2.new C();

        c.allTheX();

    }

    public void methodWithLocalClass() {
        class LocalClass {
            public static final int size = 0;
            private int otherValue;

            public void methodInLocalClass() {

            }
        }

        System.out.println(LocalClass.size);
    }

    static class StaticClass {
        private static int value = 0;
    }

    abstract class TestAbstract{

        public abstract void method();

    }
}
