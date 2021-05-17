package com.example.snippets.demo.java11;

import com.example.snippets.demo.dto.GrandFather;

import java.util.List;

public class Child extends GrandFather {

    public static void main(String[] args) {
        Child c = new Child();
        System.out.println(c.publicVariable + c.protectedVariable);


    }

    public <T extends GrandFather> Child method(){
        return new Child();
    }

    public void simpleMethod(List<? super GrandFather> lists){

    }

}
