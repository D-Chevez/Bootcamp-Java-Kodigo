package main;

import java.util.Scanner;

/**
 * main.Main class to interact with the main.LinkedList.
 * Provides a console-based menu for basic operations.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int option;

        do {
            // Display menu
            System.out.println("\n--- Simple Linked List Menu ---");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Delete from beginning");
            System.out.println("3. Print list");
            System.out.println("5. Show size");
            System.out.println("6. Search for a value");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            option = scanner.nextInt();

            // Handle user input
            switch (option) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    list.insertAtBeginning(value);
                    System.out.println("Inserted " + value + " at beginning.");
                    break;
                case 2:
                    list.deleteFromBeginning();
                    System.out.println("Deleted node from beginning.");
                    break;
                case 3:
                    System.out.println("List contents:");
                    list.printList();
                    break;
                case 5:
                    System.out.println("List size: " + list.size());
                    break;
                case 6:
                    System.out.print("Enter value to search: ");
                    int searchValue = scanner.nextInt();
                    String result = list.search(searchValue);
                    System.out.println(result);
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (option != 0);

        scanner.close();
    }
}
