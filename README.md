# 📚 LibTrack — Library Management System

A **console-based Library Management System built with Core Java** for managing books, students, faculty members, and book issue/return operations.

The application follows a **layered architecture** with separate model, service, utility, and exception packages. It uses Java Collections for in-memory data management and CSV files for persistent local storage.

---

## 📌 Overview

**LibTrack** provides a structured way to manage day-to-day library operations through a command-line interface.

The application allows users to:

* Manage books
* Register and manage students
* Register and manage faculty
* Issue books to students or faculty
* Return issued books
* Search and remove records
* Persist data using CSV files
* Handle application-specific errors using custom exceptions

The project was designed to practice and demonstrate **Core Java, OOP, Collections, File Handling, Exception Handling, and layered application design**.

---

## ✨ Features

### 📖 Book Management

* Add new books
* Display all books
* Search books by Book ID
* Remove books
* Issue books
* Return books
* View total number of books
* Track book availability
* Track borrower ID and borrower type
* Prevent issuing an already issued book

### 👨‍🎓 Student Management

* Register students
* Display all students
* Search students by ID
* Remove students
* Prevent duplicate student IDs

### 👨‍🏫 Faculty Management

* Register faculty members
* Display faculty members
* Search faculty by ID
* Remove faculty members
* Prevent duplicate faculty IDs

### 🔄 Library Operations

* Issue books to students or faculty
* Validate borrower existence before issuing
* Prevent duplicate book issuance
* Return issued books
* Reset borrower information after return
* Persist changes to CSV files

---

## 🛠️ Technology Stack

| Category             | Technology                                                     |
| -------------------- | -------------------------------------------------------------- |
| Programming Language | Java                                                           |
| Java Concepts        | OOP, Inheritance, Encapsulation, Collections                   |
| Collections          | `ArrayList`                                                    |
| File Handling        | `FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter` |
| Data Storage         | CSV Files                                                      |
| Exception Handling   | Custom Checked Exception                                       |
| IDE                  | Eclipse                                                        |
| Project Structure    | Java Packages / Modular Structure                              |

---

# 🏗️ System Architecture

LibTrack follows a **layered architecture** that separates application control, business logic, domain models, file persistence, and exception handling.

```text
                         ┌──────────────────────┐
                         │        User          │
                         │    Console Input     │
                         └──────────┬───────────┘
                                    │
                                    ▼
                         ┌──────────────────────┐
                         │       Main.java      │
                         │ Application Control  │
                         └──────────┬───────────┘
                                    │
                  ┌─────────────────┼─────────────────┐
                  │                 │                 │
                  ▼                 ▼                 ▼
        ┌─────────────────┐ ┌────────────────┐ ┌─────────────────┐
        │   BookService   │ │ StudentService │ │ FacultyService  │
        │                 │ │                │ │                 │
        │ Add             │ │ Register       │ │ Register        │
        │ Search          │ │ Search         │ │ Search          │
        │ Issue           │ │ Display        │ │ Display         │
        │ Return          │ │ Remove         │ │ Remove          │
        │ Remove          │ │                │ │                 │
        └────────┬────────┘ └───────┬────────┘ └────────┬────────┘
                 │                  │                   │
                 ▼                  ▼                   ▼
        ┌─────────────────┐ ┌────────────────┐ ┌─────────────────┐
        │      Book       │ │    Student     │ │     Faculty     │
        │      Model      │ │     Model      │ │      Model      │
        └────────┬────────┘ └───────┬────────┘ └────────┬────────┘
                 │                  │                   │
                 └──────────────────┼───────────────────┘
                                    │
                                    ▼
                         ┌──────────────────────┐
                         │    File Utilities    │
                         │                      │
                         │ BookFileUtil         │
                         │ StudentFileUtil      │
                         │ FacultyFileUtil      │
                         └──────────┬───────────┘
                                    │
                                    ▼
                         ┌──────────────────────┐
                         │     CSV Storage      │
                         │                      │
                         │ books.csv             │
                         │ students.csv          │
                         │ faculty.csv           │
                         └──────────────────────┘

                         ┌──────────────────────┐
                         │ Custom Exception     │
                         │                      │
                         │ LibraryManagement     │
                         │ Exception            │
                         └──────────────────────┘
```

---

# 🧩 Project Structure

```text
Library-Management-System/
│
├── WorkSpaces/
│   └── coreJavaWorkspace/
│       └── library_management_system/
│
│           ├── src/
│           │   │
│           │   ├── exception/
│           │   │   └── LibraryManagementException.java
│           │   │
│           │   ├── main/
│           │   │   └── Main.java
│           │   │
│           │   ├── model/
│           │   │   ├── Book.java
│           │   │   ├── User.java
│           │   │   ├── Student.java
│           │   │   └── Faculty.java
│           │   │
│           │   ├── service/
│           │   │   ├── BookService.java
│           │   │   ├── StudentService.java
│           │   │   └── FacultyService.java
│           │   │
│           │   └── util/
│           │       ├── BookFileUtil.java
│           │       ├── StudentFileUtil.java
│           │       └── FacultyFileUtil.java
│           │
│           ├── books.csv
│           ├── students.csv
│           ├── faculty.csv
│           └── .gitignore
│
└── README.md
```

---

# 🧱 Architecture Components

## 1. Application Layer

### `Main.java`

`Main` acts as the entry point and application controller.

It is responsible for:

* Displaying the menu
* Reading console input
* Creating service objects
* Loading existing data
* Calling service-layer operations
* Handling user interaction
* Saving modified data

---

## 2. Service Layer

The service layer contains the application's primary business operations.

### `BookService`

Handles:

* Adding books
* Searching books
* Displaying books
* Removing books
* Issuing books
* Returning books
* Counting books

### `StudentService`

Handles:

* Student registration
* Student search
* Student display
* Student removal

### `FacultyService`

Handles:

* Faculty registration
* Faculty search
* Faculty display
* Faculty removal

The services maintain their records using Java's `ArrayList`.

---

# 🧬 Model Layer

The model layer represents the main entities of the application.

```text
                 User
                /    \
               /      \
          Student    Faculty

                 Book
```

### `User`

The parent class containing common user information:

* `userId`
* `name`

### `Student`

Extends `User` and represents a library student.

### `Faculty`

Extends `User` and represents a faculty member.

### `Book`

Represents a library book and maintains:

* Book ID
* Title
* Author
* Issue status
* Borrower ID
* Borrower type

---

# 💾 Persistence Layer

The application uses **CSV files for persistent storage** instead of an external database.

| Utility Class     | File           | Responsibility                  |
| ----------------- | -------------- | ------------------------------- |
| `BookFileUtil`    | `books.csv`    | Load, append, and save books    |
| `StudentFileUtil` | `students.csv` | Load, append, and save students |
| `FacultyFileUtil` | `faculty.csv`  | Load, append, and save faculty  |

The application loads existing records when it starts and writes updated records whenever changes are made.

---

# 🔄 Application Flow

```text
User
  │
  ▼
Console Menu
  │
  ▼
Main.java
  │
  ▼
Service Layer
  │
  ├── Validate Request
  │
  ├── Search / Modify Object
  │
  └── Apply Business Rules
  │
  ▼
File Utility
  │
  ▼
CSV Storage
```

---

# 📕 Book Issue Flow

One of the main operations is issuing a book.

```text
User selects "Issue Book"
          │
          ▼
       Book ID
          │
          ▼
Select Borrower Type
     /            \
 Student          Faculty
    │                │
    ▼                ▼
Student ID       Faculty ID
    │                │
    └───────┬────────┘
            ▼
     Validate Borrower
            │
            ▼
      Search for Book
            │
            ▼
   Check Issue Status
       /          \
   Available     Issued
      │             │
      ▼             ▼
 Update Book     Throw Exception
      │
      ▼
Save books.csv
```

When a book is successfully issued, the `Book` object stores:

```text
issued = true
issuedToId = borrower ID
borrowerType = STUDENT / FACULTY
```

---

# 📗 Book Return Flow

```text
User selects "Return Book"
            │
            ▼
         Book ID
            │
            ▼
       Search Book
            │
            ▼
     Check Issue Status
        /          \
    Issued       Available
      │              │
      ▼              ▼
 Reset Status     Throw Exception
      │
      ▼
Save books.csv
```

After a successful return:

```text
issued = false
issuedToId = 0
borrowerType = NONE
```

---

# ⚠️ Exception Handling

The project uses a custom checked exception:

```text
LibraryManagementException
```

It is used for application-specific situations such as:

* Book not found
* Student not found
* Faculty not found
* Book already issued
* Book not currently issued

Example:

```java
throw new LibraryManagementException(
    "Book is already issued."
);
```

This provides clearer error handling for business operations.

---

# 🧠 Core Java Concepts Demonstrated

## Object-Oriented Programming

### Encapsulation

Class fields are declared `private` and accessed through getters and setters.

### Inheritance

```text
User
 ├── Student
 └── Faculty
```

`Student` and `Faculty` inherit common properties from `User`.

### Classes and Objects

The application models real-world entities such as:

* Books
* Students
* Faculty members
* Users

### Collections

`ArrayList` is used to maintain collections of books, students, and faculty.

### Exception Handling

A custom checked exception is used for application-specific validation failures.

### File Handling

Java I/O classes are used to read and write CSV data.

---

# 🔍 Data Persistence

The project maintains three CSV files:

```text
books.csv
students.csv
faculty.csv
```

### Startup

```text
CSV Files
    ↓
File Utiliti
```
