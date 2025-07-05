public class Util {
    /**
     * Clears the screen (cross-platform).
     */
    static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Unable to clear screen.");
        }
    }

    /**
     * Prints a clear header indicating the current operation.
     */
    static void printHeader(String operationName) {
        System.out.println("\n========= " + operationName.toUpperCase() + " =========");
    }
}
