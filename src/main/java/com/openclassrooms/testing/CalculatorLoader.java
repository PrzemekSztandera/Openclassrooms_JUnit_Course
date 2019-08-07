package com.openclassrooms.testing;

public class CalculatorLoader {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double num = 0;
        try {
          num =  calculator.convert(ConversionType.LITRES_TO_GALLONS, 98.0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(num);

    }
}
