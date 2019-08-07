package com.openclassrooms.testing;

/**
 * A very basic calculator
 */
public class Calculator implements CalculatorInterface {

    private ConversionCalculator conversionCalculator;

    public Calculator() {
        this.conversionCalculator = new ConversionCalculator();
    }


    public Calculator(ConversionCalculator conversionCalculator) {
        this.conversionCalculator = conversionCalculator;
    }

    /**
     * {@inheritDoc}
     */
    public Double add(final Double left, final Double right) { return left + right; }

    /**
     * {@inheritDoc}
     */
    public Double subtract(final Double left, final Double right) { return left - right; }

    /**
     * {@inheritDoc}
     */
    public Double convert(ConversionType type, Double value) throws CalculatorException {
        Double result;
        switch (type) {
            case RADIUS_TO_AREA:
                result = conversionCalculator.radiusToAreaOfCircle(value);
                break;
            case LITRES_TO_GALLONS:
                result = conversionCalculator.litresToGallons(value);
                break;
            case CELSIUS_TO_FAHRENHEIT:
                result = conversionCalculator.celsiusToFahrenheit(value);
                break;
            case FAHRENHEIT_TO_CELSIUS:
                result = conversionCalculator.fahrenheitToCelsius(value);
                break;
                default:
                    throw new CalculatorException("Unknown conversion!!!");
        }
        return result;
    }

    public Double multiply(Double i, Double i1) {
        return i * i1;
    }

    public void cos(double v) {
        throw new UnsupportedOperationException("Trigonometry not supported!");
    }

    public void slowCalculation() {
        try {
            final Long sleepTime = 2000L;
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.println("This operation completed after 3 seconds");
        }

    }

}
