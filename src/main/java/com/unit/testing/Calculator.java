package com.unit.testing;

public class Calculator {

    public Integer add(Integer a, Integer b){
        return a+b;
    }

    public Integer divide(Integer a, Integer b){
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return a/b;
    }
}
