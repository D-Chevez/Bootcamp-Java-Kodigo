import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Handles search operations over a static list with complexity details and user-friendly display.
 */
public class Searcher {

    private int[] staticList;
    private List<OperationRecord> operationHistory;
    private Scanner scanner;

    public Searcher(int[] staticList, List<OperationRecord> operationHistory, Scanner scanner) {
        this.staticList = Arrays.copyOf(staticList, staticList.length);
        this.operationHistory = operationHistory;
        this.scanner = scanner;
    }

    /**
     * Displays the available values to search.
     * @param shouldSort if true, displays the list sorted for binary search clarity.
     */
    private void displayAvailableValues(boolean shouldSort) {
        int[] listToShow = Arrays.copyOf(staticList, staticList.length);
        if (shouldSort) {
            Arrays.sort(listToShow);
            System.out.println("Available values to search (sorted): " + Arrays.toString(listToShow) + " (Length: "+ listToShow.length +")");
        } else {
            System.out.println("Available values to search: " + Arrays.toString(listToShow) + " (Length: "+ listToShow.length +")");
        }
    }

    /**
     * Overloaded method for unsorted display.
     */
    private void displayAvailableValues() {
        displayAvailableValues(false);
    }

    /**
     * Submenu after each search allowing the user to repeat, return, or exit.
     *
     * @param searchType 1 for sequential, 2 for binary
     */
    private void postSearchMenu(int searchType) {
        boolean valid = false;
        while (!valid) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Perform another search of this type");
            System.out.println("2. Return to the main menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if (searchType == 1) {
                        sequentialSearch();
                    } else {
                        binarySearch();
                    }
                    valid = true;
                    break;
                case 2:
                    valid = true;
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, please choose 1, 2, or 3.");
            }
        }
    }

    /**
     * Performs a sequential search, requesting user input internally with post-search menu.
     */
    public void sequentialSearch() {
        Util.clearScreen();
        Util.printHeader("Sequential Search");
        displayAvailableValues();
        System.out.print("Enter the number to search: ");

        int target = scanner.nextInt();

        long startTime = System.nanoTime();
        boolean found = false;
        int index = -1;

        for (int i = 0; i < staticList.length; i++) {
            if (staticList[i] == target) {
                found = true;
                index = i;
                break;
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        String result = found ? "Found at index " + index : "Not found";
        System.out.println(result + " | Execution time (ns): " + duration);
        System.out.println("Complexity: Best O(1), Worst O(n), Avg O(n)");

        operationHistory.add(new OperationRecord(
                "Sequential Search",
                String.valueOf(target),
                duration,
                result,
                "O(1)", "O(n)", "O(n)"
        ));

        postSearchMenu(1);
    }

    /**
     * Performs a binary search, requesting user input internally with post-search menu.
     */
    public void binarySearch() {
        Util.clearScreen();
        Util.printHeader("Binary Search");
        displayAvailableValues(true);
        System.out.print("Enter the number to search: ");

        int target = scanner.nextInt();

        int[] sortedList = Arrays.copyOf(staticList, staticList.length);
        Arrays.sort(sortedList);

        long startTime = System.nanoTime();
        int low = 0, high = sortedList.length - 1;
        boolean found = false;
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedList[mid] == target) {
                found = true;
                index = mid;
                break;
            } else if (sortedList[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        String result = found ? "Found at index " + index : "Not found";
        System.out.println(result + " | Execution time (ns): " + duration);
        System.out.println("Complexity: Best O(1), Worst O(log n), Avg O(log n)");

        operationHistory.add(new OperationRecord(
                "Binary Search",
                String.valueOf(target),
                duration,
                result,
                "O(1)", "O(log n)", "O(log n)"
        ));

        postSearchMenu(2);
    }
}
