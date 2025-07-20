package main;

/**
 * Implements a singly linked list with basic operations.
 */
public class LinkedList {
    private Node head;  // Reference to the first node

    /**
     * Constructs an empty linked list.
     */
    public LinkedList() {
        head = null;
    }

    /**
     * Inserts a new node at the beginning of the list.
     * @param data the value to insert
     */
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;  // The new node points to the current head
        head = newNode;       // Head now points to the new node
    }

    /**
     * Deletes the first node in the list if it exists.
     */
    public void deleteFromBeginning() {
        if (head != null) {
            head = head.next;  // Move the head to the next node
        }
    }

    /**
     * Prints all elements of the list to the console.
     */
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    /**
     * Checks whether the list is empty.
     * @return true if the list has no elements
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns the number of elements in the list.
     * @return size of the list
     */
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Searches for the first occurrence of a given value in the list.
     * @param data the value to search for
     * @return a message indicating the node's position or if it was not found
     */
    public String search(int data) {
        Node current = head;
        int position = 0;

        while (current != null) {
            if (current.data == data) {
                return "Value " + data + " found at position " + (position + 1);
            }
            current = current.next;
            position++;
        }

        return "Value " + data + " not found in the list.";
    }

}
