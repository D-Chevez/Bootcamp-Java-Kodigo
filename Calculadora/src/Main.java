import calculator.Record;
import calculator.Menu;

public class Main {

    public static void main(String[] args) {
        Record record = new Record();  // Create an instance for recording history
        Menu menu = new Menu(record);  // Pass record to menu for operations

        menu.showMainMenu();  // Start the main menu loop
    }

}
