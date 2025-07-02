package calculator;

import java.util.ArrayList;
import java.util.List;

public class Record {
    private final List<String> operations;

    public Record() {
        operations = new ArrayList<>();
    }

    public void addOperation(String operation) {
        operations.add(operation);
    }

    public void showRecord() {
        if (operations.isEmpty()) {
            System.out.println("\nNo hay operaciones en el historial.");
        } else {
            System.out.println("\nHistorial de operaciones:");
            for (String op : operations) {
                System.out.println(op);
            }
        }
    }
}
