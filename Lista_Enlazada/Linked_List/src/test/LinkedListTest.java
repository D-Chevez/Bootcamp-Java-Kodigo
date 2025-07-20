package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.LinkedList;

/**
 * Unit tests for the LinkedList class.
 */
public class LinkedListTest {

    @Test
    public void testInsertAtBeginning() {
        LinkedList list = new LinkedList();
        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        assertEquals(2, list.size());
    }

    @Test
    public void testDeleteFromBeginning() {
        LinkedList list = new LinkedList();
        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.deleteFromBeginning();
        assertEquals(1, list.size());
    }

    @Test
    public void testDeleteFromEmptyList() {
        LinkedList list = new LinkedList();
        list.deleteFromBeginning();  // Should not throw
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        LinkedList list = new LinkedList();
        assertTrue(list.isEmpty());
        list.insertAtBeginning(5);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testSize() {
        LinkedList list = new LinkedList();
        assertEquals(0, list.size());
        list.insertAtBeginning(1);
        list.insertAtBeginning(2);
        list.insertAtBeginning(3);
        assertEquals(3, list.size());
    }

    @Test
    public void testSearchFound() {
        LinkedList list = new LinkedList();
        list.insertAtBeginning(5);
        list.insertAtBeginning(10);
        list.insertAtBeginning(15); // head -> 15 -> 10 -> 5
        String result = list.search(10);
        assertEquals("Value 10 found at position 1", result);
    }

}
