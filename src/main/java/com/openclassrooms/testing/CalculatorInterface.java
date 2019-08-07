package com.openclassrooms.testing;

public interface CalculatorInterface {

    /**
     * Adds the left argument to the right.
     * @param left The first number to be added.
     * @param right A number to be added to the left.
     * @return sum of left and right argument as Double type.
     */
    Double add(final Double left, final Double right);

    /**
     * Subtract right argument from the left.
     * @param left The first number to subtract from.
     * @param right A number to be subtracted from the left.
     * @return result of subtraction as Double type.
     */
    Double subtract(final Double left, final Double right);

    /**
     * Converts a value based on the requested converter.
     * @param type to convert to.
     * @param value to be converted.
     * @return converted value.
     * @throws Exception
     */
    Double convert(ConversionType type, Double value) throws Exception;

    /**
     * Multiply left and right argument
     * @param left
     * @param right
     * @return Result of multiplication as Double.
     */
    Double multiply(final Double left, final Double right);
}
