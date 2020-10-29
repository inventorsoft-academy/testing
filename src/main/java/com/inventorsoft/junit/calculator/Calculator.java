package com.inventorsoft.junit.calculator;

public class Calculator {
    
    public int sum(int a, int b) {
        return a + b;
    }

    public int substract(int a, int b) {
        return a - b;
    }

    public int divide(int a, int b) throws UnsupportedOperationException{
        if(b==0){
            throw new UnsupportedOperationException("Cannot divide by zero");
        }
        return a / b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

}
