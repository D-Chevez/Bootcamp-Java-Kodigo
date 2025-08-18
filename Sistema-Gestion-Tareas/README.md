# 🔗 SOLID Task Management System

A small console-based Task Manager built with Java 17, designed to clearly demonstrate the five SOLID principles with a layered architecture (model / repository / service) and in-memory persistence. Clean structure, extensible filters, and separation of concerns throughout.

---

## 📌 Features
✅ Create Users, Projects, and Tasks  
✅ Assign tasks to a user and a project  
✅ Change task status (TODO, IN_PROGRESS, DONE, BLOCKED)  
✅ Set priority and due date  
✅ List and filter tasks by: status, assignee, project, due date range  
✅ Delete tasks  
✅ Console menu with clear prompts  
**Design highlights**  
⭐ Interfaces for repositories and services  
⭐ In-Memory repositories (thread-safe maps)  
⭐ Specification/Strategy pattern for filters  
⭐ Dependency Injection (manual via constructors)  

---

## 🧠 SOLID in this project
- **S** — Single Responsibility  
Each layer/class has a single reason to change: TaskServiceImpl handles business logic, repositories handle data access, Main is the UI.
- **O** — Open/Closed  
New filters can be added via new Specifications without modifying domain models (e.g., StatusSpecification, ProjectSpecification, etc.).
- **L** — Liskov Substitution  
Task implements WorkItem. Any other WorkItem would work where a WorkItem is expected.
- **I** — Interface Segregation  
Repositories split into ReadRepository and WriteRepository, avoiding “fat” interfaces.
- **D** — Dependency Inversion  
Services depend on abstractions (TaskRepository, UserRepository, ProjectRepository), not concrete implementations. The UI wires concretes.

---

## 🗂️ Project Structure

```css
src/
  ├─ model/
  │   ├─ WorkItem.java
  │   ├─ Task.java
  │   ├─ TaskStatus.java
  │   ├─ Priority.java
  │   ├─ User.java
  │   └─ Project.java
  ├─ repository/
  │   ├─ ReadRepository.java
  │   ├─ WriteRepository.java
  │   ├─ TaskRepository.java
  │   ├─ UserRepository.java
  │   ├─ ProjectRepository.java
  │   └─ inmem/
  │       ├─ InMemoryTaskRepository.java
  │       ├─ InMemoryUserRepository.java
  │       └─ InMemoryProjectRepository.java
  ├─ service/
  │   ├─ filter/
  │   │   ├─ Specification.java
  │   │   ├─ TaskFilter.java
  │   │   ├─ StatusSpecification.java
  │   │   ├─ AssigneeSpecification.java
  │   │   ├─ ProjectSpecification.java
  │   │   └─ DueDateRangeSpecification.java
  │   ├─ TaskService.java
  │   ├─ TaskServiceImp.java
  │   ├─ UserService.java
  │   ├─ UserServiceImp.java
  │   ├─ ProjectService.java
  │   └─ ProjectServiceImp.java
  └─ Main.java
```
---

## 🚀 How to Compile and Run

### **1️⃣ Compile**

Make sure you have **Java** and an IDE like **IntelliJ IDEA** installed.
Navigate to the `main/` folder on `Task-Manager-System/` in your terminal and run:

```bash
javac *.java
```

### **2️⃣ Run**

After compilation, execute:

```bash
java Main
```

---

## 🎯 Purpose
📌 Practice clean Java 17 design with SOLID
📌 Understand layered architecture with in-memory persistence

Enjoy building and extending your SOLID Task Manager!