import java.util.Arrays;
import java.util.List;

/**
 * Handles sort operations with before-and-after display and clear complexity reporting.
 */
public class Sorter {

    private int[] staticList;
    private List<OperationRecord> operationHistory;

    public Sorter(int[] staticList, List<OperationRecord> operationHistory) {
        this.staticList = Arrays.copyOf(staticList, staticList.length);
        this.operationHistory = operationHistory;
    }

    private void displayBeforeAndAfter(int[] before, int[] after) {
        System.out.println("List before sorting: " + Arrays.toString(before) + " (Length: "+ before.length +")");
        System.out.println("List after sorting:  " + Arrays.toString(after) + " (Length: "+ after.length +")");
    }

    private void printComplexity(String best, String worst, String average) {
        System.out.println("Complexity: Best " + best + ", Worst " + worst + ", Avg " + average);
    }

    public void bubbleSort() {
        int[] before = Arrays.copyOf(staticList, staticList.length);
        int[] arr = Arrays.copyOf(staticList, staticList.length);

        long startTime = System.nanoTime();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        Util.clearScreen();
        Util.printHeader("Bubble Sort");
        displayBeforeAndAfter(before, arr);
        System.out.println("Bubble Sort completed | Execution time (ns): " + duration);
        printComplexity("O(n)", "O(n^2)", "O(n^2)");

        operationHistory.add(new OperationRecord(
                "Bubble Sort",
                "-",
                duration,
                "Sorted",
                "O(n)", "O(n^2)", "O(n^2)"
        ));
    }

    public void insertionSort() {
        int[] before = Arrays.copyOf(staticList, staticList.length);
        int[] arr = Arrays.copyOf(staticList, staticList.length);

        long startTime = System.nanoTime();
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        Util.clearScreen();
        Util.printHeader("Insertion Sort");
        displayBeforeAndAfter(before, arr);
        System.out.println("Insertion Sort completed | Execution time (ns): " + duration);
        printComplexity("O(n)", "O(n^2)", "O(n^2)");

        operationHistory.add(new OperationRecord(
                "Insertion Sort",
                "-",
                duration,
                "Sorted",
                "O(n)", "O(n^2)", "O(n^2)"
        ));
    }

    public void selectionSort() {
        int[] before = Arrays.copyOf(staticList, staticList.length);
        int[] arr = Arrays.copyOf(staticList, staticList.length);

        long startTime = System.nanoTime();
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        Util.clearScreen();
        Util.printHeader("Selection Sort");
        displayBeforeAndAfter(before, arr);
        System.out.println("Selection Sort completed | Execution time (ns): " + duration);
        printComplexity("O(n^2)", "O(n^2)", "O(n^2)");

        operationHistory.add(new OperationRecord(
                "Selection Sort",
                "-",
                duration,
                "Sorted",
                "O(n^2)", "O(n^2)", "O(n^2)"
        ));
    }
}
