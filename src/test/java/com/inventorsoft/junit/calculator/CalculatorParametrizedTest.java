package com.inventorsoft.junit.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class CalculatorParametrizedTest {

    @Parameter
    public int firstNumber;

    @Parameter(1)
    public int secondNumber;

    @Parameter(2)
    public int result;

    private Calculator calculator = new Calculator();

    @Parameters(name = "The sum of {0} and {1} should result in {2}")
    public static Collection<Object[]> params() {
        List<Object[]> params = new ArrayList<>();
        params.add(new Object[]{5, 5, 10});
        params.add(new Object[]{10, 5, 15});
        params.add(new Object[]{20, 5, 25});
        params.add(new Object[]{30, 6, 36});
        params.add(new Object[]{36, 6, 42});
        params.add(new Object[]{45, 5, 50});
        params.add(new Object[]{100, 5, 105});
        return params;
    }

    @Test
    public void testCalculator() {
        Assert.assertEquals(result, calculator.sum(firstNumber, secondNumber));
    }
}
