import calculator.Record;
import calculator.Menu;

/**
 * Entry point of the calculator application.
 */
public class Main {
    public static void main(String[] args) {
        Record record = new Record(); // Initializes the in-memory operation record
        Menu menu = new Menu(record); // Initializes the menu with the record for tracking operations

        menu.showMainMenu(); // Starts the calculator interactive session
    }
}
