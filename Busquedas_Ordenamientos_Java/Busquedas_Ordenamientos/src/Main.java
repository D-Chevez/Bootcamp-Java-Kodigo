import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

/**
 * Main class to execute the Searcher and Sorter system with a clean, interactive menu.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        int size = random.nextInt(16) + 5; // Generates [0,15] + 5 = [5,20]
        int[] staticContent = new int[size];

        for (int i = 0; i < size; i++) {
            staticContent[i] = random.nextInt(100) + 1; // Values between 1 and 100
        }

        List<OperationRecord> operationHistory = new ArrayList<>();
        Searcher searcher = new Searcher(staticContent, operationHistory, scanner);
        Sorter sorter = new Sorter(staticContent, operationHistory);

        boolean exit = false;

        while (!exit) {
            Util.clearScreen();
            Util.printHeader("Menu");
            System.out.println("1. Sequential Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Bubble Sort");
            System.out.println("4. Insertion Sort");
            System.out.println("5. Selection Sort");
            System.out.println("6. View Operation History");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            try {
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        searcher.sequentialSearch();
                        break;
                    case 2:
                        searcher.binarySearch();
                        break;
                    case 3:
                        sorter.bubbleSort();
                        displayAuxMenu(scanner);
                        break;
                    case 4:
                        sorter.insertionSort();
                        displayAuxMenu(scanner);
                        break;
                    case 5:
                        sorter.selectionSort();
                        displayAuxMenu(scanner);
                        break;
                    case 6:
                        displayOperationHistory(operationHistory, scanner);
                        break;
                    case 7:
                        System.out.println("Exiting the program...");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please select a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        scanner.close();
    }

    /**
     * Displays the operation history and a post-history menu to continue or exit.
     */
    private static void displayOperationHistory(List<OperationRecord> operationHistory, Scanner scanner) {
        Util.clearScreen();
        Util.printHeader("Record");
        if (operationHistory.isEmpty()) {
            System.out.println("No operations performed yet.");
        } else {
            System.out.printf("%-20s %-10s %-15s %-25s %-40s\n",
                    "Operation", "Target", "Time (ns)", "Result", "Complexity");
            for (OperationRecord record : operationHistory) {
                record.display();
            }
        }

        displayAuxMenu(scanner);
    }


    private static void displayAuxMenu(Scanner scanner){
        boolean validInput = false;
        while (!validInput) {
            System.out.println("\nDo you want to:");
            System.out.println("1. Return to main menu");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                validInput = true;
            } else if (choice == 2) {
                System.out.println("Exiting the program...");
                System.exit(0);
            } else {
                System.out.println("Invalid option. Please select 1 or 2.");
            }
        }
    }
}
