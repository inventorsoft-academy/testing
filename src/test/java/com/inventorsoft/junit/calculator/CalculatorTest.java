package com.inventorsoft.junit.calculator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CalculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void test_sum_two_positive_result_positive() {
        assertEquals(20, calculator.sum(10, 10));
    }

    @Test
    public void test_sum_two_negative_result_negative() {
        assertEquals(-20, calculator.sum(-10, -10));
    }

    @Test
    public void test_sum_two_zero_result_zero() {
        assertEquals(0, calculator.sum(0, 0));
    }

    @Test
    public void test_subtract_with_positive_result_same() {
        assertEquals(0, calculator.sum(0, 0));
    }

    @Test
    public void test_subtract_two_negative_result_negative() {
        assertEquals(0, calculator.multiply(0, 0));
    }

    @Test
    public void test_subtract_one_argument_zero_result_same() {
        assertEquals(10, calculator.substract(10, 0));
    }

    @Test
    public void test_multiply_zero_result_zero() {
        assertEquals(0, calculator.multiply(10, 0));
    }

    @Test
    public void test_divide_same_result_one() {
        assertEquals(1, calculator.divide(10, 10));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testDividingZeroShouldThrowsException1() {
        calculator.divide(5, 0);
    }

    @Test
    public void testDividingZeroShouldThrowsException2() {
        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.divide(5, 0);
        });
    }

    @Test
    public void testDividingZeroShouldThrowsException3() {
        expectedException.expect(UnsupportedOperationException.class);
        expectedException.expectMessage("Cannot divide by zero");

        calculator.divide(5, 0);
    }
}
