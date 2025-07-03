package calculator;

/**
 * Provides static methods for performing arithmetic operations on Number instances.
 */
public class Calculator {

    /**
     * Adds two numbers.
     */
    public static double add(Number a, Number b) {
        return a.getValue() + b.getValue();
    }

    /**
     * Subtracts the second number from the first.
     */
    public static double subtract(Number a, Number b) {
        return a.getValue() - b.getValue();
    }

    /**
     * Multiplies two numbers.
     */
    public static double multiply(Number a, Number b) {
        return a.getValue() * b.getValue();
    }

    /**
     * Divides the first number by the second, handling division by zero.
     * @throws ArithmeticException if division by zero occurs
     */
    public static double divide(Number a, Number b) throws ArithmeticException {
        if (b.getValue() == 0) {
            throw new ArithmeticException("Error: Division by zero is not allowed.");
        }
        return a.getValue() / b.getValue();
    }

    /**
     * Raises a number to the power of another.
     */
    public static double power(Number base, Number exponent) {
        return Math.pow(base.getValue(), exponent.getValue());
    }

    /**
     * Calculates the square root of a number, handling negative input.
     * @throws ArithmeticException if the number is negative
     */
    public static double squareRoot(Number number) throws ArithmeticException {
        if (number.getValue() < 0) {
            throw new ArithmeticException("Error: Cannot calculate the square root of a negative number.");
        }
        return Math.sqrt(number.getValue());
    }
}
