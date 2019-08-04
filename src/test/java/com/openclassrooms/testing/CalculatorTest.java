package com.openclassrooms.testing;
import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.*;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;





@Tag("Calculator test")
@DisplayName("Simple calculator")


public class CalculatorTest {

    private static Instant startTime;
    private Calculator calculatorUnderTest;


    @BeforeClass
   public static void beforeClass() {
        // the time when the test was run
        startTime = Instant.now();
        System.out.println("Before class");
    }

    @AfterClass
   public static void afterClass() {
        Instant endTime = Instant.now();
        Duration duration = Duration.between(startTime, endTime);
        System.out.println("Test took: " + duration.toString());
    }

    @Before
   public void setCalculator() {
        System.out.println("Before test: " + Instant.now());
        calculatorUnderTest = new Calculator();
    }

    @After
   public void tearDown() {
        System.out.println("After testL " + Instant.now());
        calculatorUnderTest = null;
    }

    @Test
   public void add_shouldReturnTheSum_ofTwoNumbers() {
        // arrange
        Integer expected = 3; // 1+2

        // act
        Integer result = calculatorUnderTest.add(1, 2);

        // assert
        assertEquals(expected, result);
    }

    @Test
   public void multiply_shouldReturnTheProduct_ofTwoNumbers() {
        // arrange
        Integer expected = 6;

        // act
        Integer product = calculatorUnderTest.multiply(2, 3);

        // assert that product is equal to 6
        assertThat(product, is(equalTo(expected)));
    }

    @Test(expected = UnsupportedOperationException.class)
   public void cos_shouldNotBeSupported_whenCalledWithAnyValue() {
        // arrange is done in @Before

        // act
        calculatorUnderTest.cos(0.8);
        // assert: assertion happens in the @Test
    }

    @Test(timeout = 6000)
   public void slowCalculation_shouldTakeUnreasonablyLong_whenCalled() {
        // Act by calling a slow calculation
        calculatorUnderTest.slowCalculation();
    }
}
