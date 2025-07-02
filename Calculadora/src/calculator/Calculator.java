package calculator;

public class Calculator {
    public static double add(Number a, Number b) {
        return a.getValue() + b.getValue();
    }


    public static double subtract(Number a, Number b) {
        return a.getValue() - b.getValue();
    }

    public static double multiply(Number a, Number b) {
        return a.getValue() * b.getValue();
    }

    public static double divide(Number a, Number b) throws ArithmeticException {
        if (b.getValue() == 0) {
            throw new ArithmeticException("Error: Division by zero is not allowed.");
        }
        return a.getValue() / b.getValue();
    }

    public static double power(Number base, Number exponent) {
        return Math.pow(base.getValue(), exponent.getValue());
    }

    public static double squareRoot(Number number) throws ArithmeticException {
        if (number.getValue() < 0) {
            throw new ArithmeticException("Error: Cannot calculate the square root of a negative number.");
        }
        return Math.sqrt(number.getValue());
    }
}