package com.openclassrooms.testing;

import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.*;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@Tag("Calculator test")
@DisplayName("Simple calculator")

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    @Mock
    ConversionCalculator conversionCalculatorTestDouble;


    private static Instant startTime;
    private Calculator calculatorUnderTest;


    @Before
    public void setUp() {
        calculatorUnderTest = new Calculator(conversionCalculatorTestDouble);
    }


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
        System.out.println("After class: test took: " + duration.toString());
    }


    @After
    public void tearDown() {
        System.out.println("After test " + Instant.now());
        calculatorUnderTest = null;
    }

    @Test
    public void add_shouldReturnTheSum_ofTwoNumbers() {
        // arrange
        Double expected = 3.0; // 1.0 + 2.0

        // act
        Double result = calculatorUnderTest.add(1.0, 2.0);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void multiply_shouldReturnTheProduct_ofTwoNumbers() {
        // arrange
        Double expected = 6.0;

        // act
        Double product = calculatorUnderTest.multiply(2.0, 3.0);

        // assert that product is equal to 6.0
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

    @Test
    public void convert_callsTheConverter_WhenRequestingRadiusToArea() throws Exception {
        Double radius = 1.0;
        when(conversionCalculatorTestDouble.radiusToAreaOfCircle(radius)).thenReturn(Math.PI);
        Double result =  calculatorUnderTest.convert(ConversionType.RADIUS_TO_AREA, radius);
        // check we called it
        verify(conversionCalculatorTestDouble).radiusToAreaOfCircle(radius);
    }
}
