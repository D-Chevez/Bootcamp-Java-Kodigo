package calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the in-memory operation history during the execution of the calculator.
 */
public class Record {
    private List<String> operations;

    /**
     * Initializes the operation history list.
     */
    public Record() {
        operations = new ArrayList<>();
    }

    /**
     * Adds a new operation to the history.
     * @param operation the operation performed as a string
     */
    public void addOperation(String operation) {
        operations.add(operation);
    }

    /**
     * Displays the operation history in the console.
     */
    public void showHistory() {
        if (operations.isEmpty()) {
            System.out.println("No operations recorded yet.");
        } else {
            System.out.println("\n--- Operation History ---");
            for (String op : operations) {
                System.out.println(op);
            }
            System.out.println("--------------------------\n");
        }
    }
}
