package com.example.snippets.demo.java11.annotations11;

import com.example.snippets.demo.java11.Child;
import com.example.snippets.demo.java11.Season;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//@Target(ElementType.TYPE_USE)
public @interface Exercise {

    Season seasonValue() default Season.FALL;
    int hoursPerDay();
    int startDay() default 4;
    int validateHour() default 10;
    Class getChild() default Child.class;
}

@interface WorkOut {

    int value() default 10;
}