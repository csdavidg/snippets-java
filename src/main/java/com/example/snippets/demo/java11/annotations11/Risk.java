package com.example.snippets.demo.java11.annotations11;

import java.lang.annotation.Repeatable;

@Repeatable(Risks.class)
public @interface Risk {

    String danger();
    int level() default 1;

}
