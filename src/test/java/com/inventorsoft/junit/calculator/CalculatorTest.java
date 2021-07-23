package com.inventorsoft.junit.calculator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
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
    public void test_multiply_two_zero_result_zero() {
        assertEquals(0, calculator.multiply(0, 0));
    }

    @Test
    public void test_subtract_one_argument_zero_result_same() {
        assertEquals(10, calculator.substract(10, 0));
    }

    @Test
    public void test_multiply_with_zero_result_zero() {
        assertEquals(0, calculator.multiply(10, 0));
    }

    @Test
    public void test_divide_same_result_one() throws Throwable {
        assertEquals(1, calculator.divide(10, 10));
    }

    @Test(expected = DivisionByZeroThrowable.class)
    public void testDividingZeroShouldThrowsException1() throws Throwable {
        calculator.divide(5, 0);
    }

    @Test
    public void testDividingZeroShouldThrowsException2() {
        assertThrows("Cannot divide by zero!",DivisionByZeroThrowable.class, () ->
                calculator.divide(5, 0)
        );
    }

    @Test
    public void testDividingZeroShouldThrowsException3() throws Throwable {
        expectedException.expect(DivisionByZeroThrowable.class);
        expectedException.expectMessage("Cannot divide by zero!");

        calculator.divide(5, 0);
    }
}
