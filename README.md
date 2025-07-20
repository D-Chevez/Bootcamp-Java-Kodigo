# 🔗 Java Simple Linked List

This project implements a **singly linked list in Java**, using object-oriented programming principles. It is designed for academic practice with clean structure, interaction via console, and unit tests using JUnit.

---

## 📌 Features

✅ Add new elements at the **beginning** of the list  
✅ **Delete** elements from the beginning  
✅ **Search** for an element and return its **position**  
✅ **Print** the current state of the list  
✅ Show if the list is **empty** or display its **size**  
✅ Clean and modular design using:

- `Node` (list node representation)
- `LinkedList` (list logic and operations)
- `Main` (console menu interface)
- `LinkedListTest` (unit tests using JUnit 5)

---

## 🚀 How to Compile and Run

### **1️⃣ Compile**

Make sure you have **Java** and an IDE like **IntelliJ IDEA** installed.
Navigate to the `main/` folder on `linked_list/` in your terminal and run:

```bash
javac *.java
```

### **2️⃣ Run**

After compilation, execute:

```bash
java Main
```

You will see an interactive linked list menu in your console.

---

## 🖥️ How to Use
### **1️⃣ From the console menu, select any of the following options:**

- Insert at beginning
- Delete from beginning
- Print list
- Check if list is empty
- Show list size
- Search for a value
- Exit

### **2️⃣ Input the requested values and see the output.**

---

## 🧪 Unit Testing
The project includes a test class SimpleLinkedListTest located inside the test/ folder. It uses JUnit 5 and tests the following:

- Insertion of nodes

- Deletion of nodes

- Deletion when list is empty

- Size and empty checks

- Value search with expected position

To run the tests:

- Right-click the test class in IntelliJ IDEA and choose Run

- All test cases should pass successfully ✅

---

## 📂 Project Structure

```css
Linked_List/
├── main/
│   ├── Node.java
│   ├── LinkedList.java
│   └── Main.java
│
└── test/
    └── LinkedListTest.java
```

---

## 🎯 Purpose

This project is intended to:

✅ Strengthen your understanding of linked data structures  
✅ Practice Java OOP principles  
✅ Improve logic flow and recursive thinking  

Enjoy learning and practicing Java with this clean and testable linked list project!