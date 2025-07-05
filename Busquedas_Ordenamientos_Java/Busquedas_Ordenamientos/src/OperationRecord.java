/**
 * Represents a record of an operation performed by the system.
 * Stores the algorithm name, execution time, searched value or type of sorting, result,
 * and detailed complexity (best, worst, average cases).
 */
public class OperationRecord {
    private String operationName;
    private String target;
    private long executionTime;
    private String result;
    private String bestCase;
    private String worstCase;
    private String averageCase;

    public OperationRecord(String operationName, String target, long executionTime, String result,
                           String bestCase, String worstCase, String averageCase) {
        this.operationName = operationName;
        this.target = target;
        this.executionTime = executionTime;
        this.result = result;
        this.bestCase = bestCase;
        this.worstCase = worstCase;
        this.averageCase = averageCase;
    }

    public void display() {
        System.out.printf("%-20s %-10s %-15d %-25s %-40s\n",
                operationName, target, executionTime, result,
                "Best " + bestCase + ", Worst " + worstCase + ", Avg " + averageCase);
    }
}
