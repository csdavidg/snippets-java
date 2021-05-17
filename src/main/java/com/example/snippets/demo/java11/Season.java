package com.example.snippets.demo.java11;

/*

* If a enum just has constants
it does not need a semicolon at the end
public enum Season {
   WINTER, SPRING, SUMMER, FALL
}
* */

public enum Season {

    WINTER("Low") {
        @Override
        public String getHours() {
            return "10am-3pm";
        }
    },
    SPRING("Medium"),
    SUMMER("High") {
        @Override
        public String getHours() {
            return "9am-7pm";
        }
    },
    FALL("Medium");

    private final String expectedVisitors;

//    public abstract String getHours();

    public String getHours() {
        return "9am-5pm";
    }

    Season(String expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }

    public void printExpectedVisitors() {
        System.out.println(expectedVisitors);
    }
}