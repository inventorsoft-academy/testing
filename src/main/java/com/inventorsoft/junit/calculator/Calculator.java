package com.inventorsoft.junit.calculator;

class Calculator {

    int sum(int a, int b) {
        return a + b;
    }

    int substract(int a, int b) {
        return a - b;
    }

    int divide(int a, int b) throws DivisionByZeroThrowable {
        if (b == 0) {
            throw new DivisionByZeroThrowable("Cannot divide by zero!");
        }
        return a / b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

}
