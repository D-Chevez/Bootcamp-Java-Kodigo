package calculator;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final Record record;

    public Menu(Record history) {
        scanner = new Scanner(System.in);
        this.record = history;
    }

    public void showMainMenu() {
        while (true) {
            System.out.println("\nCalculating in java");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Power");
            System.out.println("6. Square Root");
            System.out.println("7. Show History");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int option = getIntInput();
            switch (option) {
                case 1:
                    handleOperation(Operation.ADDITION);
                    break;
                case 2:
                    handleOperation(Operation.SUBTRACTION);
                    break;
                case 3:
                    handleOperation(Operation.MULTIPLICATION);
                    break;
                case 4:
                    handleOperation(Operation.DIVISION);
                    break;
                case 5:
                    handleOperation(Operation.POWER);
                    break;
                case 6:
                    handleOperation(Operation.SQUARE_ROOT);
                    break;
                case 7:
                    record.showRecord();
                    break;
                case 0:
                    System.out.println("Exiting the calculator. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void handleOperation(Operation op) {
        boolean continueOperation = true;
        while (continueOperation) {
            try {
                double result = 0;
                Number num1 = new Number(0);
                Number num2 = new Number(0);

                System.out.println("\n");

                switch (op) {
                    case ADDITION:
                        System.out.print("Enter the first number: ");
                        num1.setValue(getDoubleInput());
                        System.out.print("Enter the second number: ");
                        num2.setValue(getDoubleInput());
                        result = Calculator.add(num1, num2);
                        record.addOperation(num1.getValue()+ " + " + num2.getValue() + " = " + result);
                        break;
                    case SUBTRACTION:
                        System.out.print("Enter the first number: ");
                        num1.setValue(getDoubleInput());
                        System.out.print("Enter the second number: ");
                        num2.setValue(getDoubleInput());
                        result = Calculator.subtract(num1, num2);
                        record.addOperation(num1.getValue()+ " - " + num2.getValue() + " = " + result);
                        break;
                    case MULTIPLICATION:
                        System.out.print("Enter the first number: ");
                        num1.setValue(getDoubleInput());
                        System.out.print("Enter the second number: ");
                        num2.setValue(getDoubleInput());
                        result = Calculator.multiply(num1, num2);
                        record.addOperation(num1.getValue()+ " * " + num2.getValue() + " = " + result);
                        break;
                    case DIVISION:
                        System.out.print("Enter the numerator: ");
                        num1.setValue(getDoubleInput());
                        System.out.print("Enter the denominator: ");
                        num2.setValue(getDoubleInput());
                        result = Calculator.divide(num1, num2);
                        record.addOperation(num1.getValue()+ " / " + num2.getValue() + " = " + result);
                        break;
                    case POWER:
                        System.out.print("Enter the base: ");
                        num1.setValue(getDoubleInput());
                        System.out.print("Enter the exponent: ");
                        num2.setValue(getDoubleInput());
                        result = Calculator.power(num1, num2);
                        record.addOperation(num1.getValue()+ " ^ " + num2.getValue() + " = " + result);
                        break;
                    case SQUARE_ROOT:
                        System.out.print("Enter the number: ");
                        num1.setValue(getDoubleInput());
                        result = Calculator.squareRoot(num1);
                        record.addOperation("sqrt(" + num1.getValue()+ ") = " + result);
                        break;
                }

                System.out.println("Result: " + result);

            } catch (ArithmeticException ex) {
                System.out.println(ex.getMessage());
            }

            // Submenu prompt
            System.out.println("\nDo you want to:");
            System.out.println("1. Perform another " + op.name().toLowerCase().replace('_', ' ') + " operation");
            System.out.println("2. Return to the main menu");
            System.out.print("Select an option: ");
            int choice = getIntInput();

            if (choice != 1) {
                continueOperation = false;
            }
        }
    }



    private int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid integer: ");
            }
        }
    }

    private double getDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

}