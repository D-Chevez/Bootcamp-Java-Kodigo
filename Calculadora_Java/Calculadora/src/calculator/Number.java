package calculator;

/**
 * Represents a real number encapsulated for operations in the calculator.
 */
public class Number {
    private double value;

    /**
     * Constructor to initialize the number with a specific value.
     * @param value the numerical value to store
     */
    public Number(double value) {
        this.value = value;
    }

    /**
     * Retrieves the stored numerical value.
     * @return the value as double
     */
    public double getValue() {
        return value;
    }

    /**
     * Updates the stored numerical value.
     * @param value the new value to set
     */
    public void setValue(double value) {
        this.value = value;
    }
}
