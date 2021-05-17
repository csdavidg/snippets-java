package com.example.snippets.demo.java11.zoo;

import com.example.snippets.demo.java11.annotations11.Exercise;
import com.example.snippets.demo.java11.annotations11.Risk;

@Risk(danger = "Silly")
@Risk(danger = "Aggressive", level = 5)
@Risk(danger = "Violent", level = 10)
public class Lion {


    @Deprecated
    public void roar() {
        Cheetah cheetah = new Cheetah();
        Integer number = new Integer("10");

    }

}
