package com.openclassrooms.testing;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void add_shouldReturnTheSum_ofTwoNumbers() {
        // arrange
        Integer expected = 3; // 1+2
        Calculator calculator = new Calculator();

        // act
        Integer result = calculator.add(1, 2);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void multiply_shouldReturnTheMultiplicationResult_ofTwoNumbers() {
        // arrange
        Integer expected = 10;
        Calculator calculator = new Calculator();

        // act
        Integer result = calculator.multiply(2, 5);

        // assert
        assertEquals(expected, result);
    }
}
