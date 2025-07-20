package main;

/**
 * Represents a node in a singly linked list.
 */
public class Node {
    int data;        // Value stored in the node
    Node next;       // Reference to the next node

    /**
     * Constructs a new node with the given data.
     * @param data the value to store in the node
     */
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
