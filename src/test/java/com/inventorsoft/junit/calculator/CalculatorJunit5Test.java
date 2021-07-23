package com.inventorsoft.junit.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorJunit5Test {

    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    void test_subtract_with_positive_result_same() {
        assertEquals(0, calculator.sum(0, 0));
    }

    @Test
    void test_subtract_two_negative_result_negative() {
        assertEquals(0, calculator.multiply(0, 0));
    }

    @Test
    void test_subtract_one_argument_zero_result_same() {
        assertEquals(10, calculator.substract(10, 0));
    }

    @Test
    void test_subtract_two_negative_arguments_zero_result() {
        assertEquals(0, calculator.substract(-20, -20));
    }

    @Test
    void test_multiply_zero_result_zero() {
        assertEquals(0, calculator.multiply(10, 0));
    }

    @Test
    void test_divide_same_result_one() throws Throwable {
        assertEquals(1, calculator.divide(10, 10));
    }

    @Nested
    @DisplayName("Sum tests")
    class SumTest {
        @Test()
        void test_sum_two_positive_result_positive() {
            assertEquals(20, calculator.sum(10, 10));
        }

        @Test
        void test_sum_two_negative_result_negative() {
            assertEquals(-20, calculator.sum(-10, -10));
        }

        @Test
        void test_sum_two_zero_result_zero() {
            int sum = calculator.sum(0, 0);
            assertEquals(0, sum);
        }
    }

}
