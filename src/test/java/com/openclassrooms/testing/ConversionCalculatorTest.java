package com.openclassrooms.testing;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.Math.PI;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Tag("ConversionTest")
@DisplayName("We should be able to convert between different units.")
@Category(Categories.ConversionTests.class)


public class ConversionCalculatorTest {

    private ConversionCalculator calculatorUnderTest = new ConversionCalculator();




    @Nested
    @Tag("TemperatureTests")
    @DisplayName("We should be able to convert between Fahrenheit and Celsius")
    class TemperatureTests {
        @Tag("FahrenheitTests")
        @DisplayName("Given zero degrees in celsius when converted to Fahrenheit then the result is 32")
        @Test
        public void celsiusToFahrenheit_returnsFahrenheitTemperature_whenCelsiusIsPositive() {
            Double actualFahrenheit = calculatorUnderTest.celsiusToFahrenheit(0.0);
            assertThat(actualFahrenheit, is(equalTo(32.0)));
        }

        @DisplayName("Given 32 degrees in Fahrenheit when converted to Celsius then the result is zero")
        @Test
        public void fahrenheitToCelsius_returnCelsiusTemperature_whenFahrenheitIsPositive() {
            Double actualCelsius = calculatorUnderTest.fahrenheitToCelsius(32.0);
            assertThat(actualCelsius, is(equalTo(0.0)));
        }
    }







    @DisplayName("Given a volume in litres when converted to gallons then the result is rounded up")
    @Test
    public void litresToGallons_returnsGallons() {
        Double actualLitres = calculatorUnderTest.litresToGallons(3.78541);
        assertThat(actualLitres, is(equalTo(1.0)));
    }

    @DisplayName("Given a radius of one when converted then the result is PI")
    @Test
    public void radiusToAreaOfCircle_returnPi_whenWeHaveARadiusOfOne() {
        Double actualArea = calculatorUnderTest.radiusToAreaOfCircle(1.0);
        assertThat(actualArea, is(equalTo(PI)));
    }

}
