
# 📚 Library Management System

> A **console-based Library Management System** built using **Core Java** that manages books, students, and faculty records with CSV-based data persistence. The project follows a clean layered architecture and demonstrates Core Java concepts such as OOP, Collections, Exception Handling, and File Handling.

---

## ✨ Features

### 📖 Book Management
- ➕ Add Book
- 🔍 Search Book
- 📋 Display All Books
- ❌ Remove Book
- 📤 Issue Book
- 📥 Return Book
- 📊 View Total Books

### 👨‍🎓 Student Management
- ➕ Register Student
- 🔍 Search Student
- 📋 Display Students
- ❌ Remove Student

### 👨‍🏫 Faculty Management
- ➕ Register Faculty
- 🔍 Search Faculty
- 📋 Display Faculty
- ❌ Remove Faculty

### 🔄 Library Operations
- 📚 Issue books to Students or Faculty
- 🔄 Return issued books
- ✅ Prevent duplicate IDs
- 👤 Track borrower information
- 💾 Automatically save data

---

# 🛠️ Tech Stack

| Category | Technology |
|----------|------------|
| Language | Java (Core Java) |
| IDE | Eclipse |
| Storage | CSV Files |
| Collections | ArrayList |
| File Handling | BufferedReader, BufferedWriter, FileReader, FileWriter |
| Exception Handling | Custom Exception (`LibraryException`) |

---

# 📂 Project Structure


LibraryManagementSystem
│
├── 📁 model
│   ├── Book.java
│   ├── User.java
│   ├── Student.java
│   └── Faculty.java
│
├── 📁 service
│   ├── BookService.java
│   ├── StudentService.java
│   └── FacultyService.java
│
├── 📁 util
│   ├── BookFileUtil.java
│   ├── StudentFileUtil.java
│   └── FacultyFileUtil.java
│
├── 📁 exception
│   └── LibraryException.java
│
└── 📁 main
    └── Main.java


---

# 🏗️ Architecture


                        Main
                         │
         ┌───────────────┼───────────────┐
         ▼               ▼               ▼
   BookService     StudentService   FacultyService
         │               │               │
         ▼               ▼               ▼
  BookFileUtil   StudentFileUtil  FacultyFileUtil
         │               │               │
         ▼               ▼               ▼
     books.csv      students.csv    faculty.csv


---

# 🔄 Application Flow


User
 │
 ▼
Main Menu
 │
 ▼
Service Layer
 │
 ▼
Validation
 │
 ▼
CSV File Operations
 │
 ▼
Updated Records


---

# 💡 Core Java Concepts Used

- ✅ Classes & Objects
- ✅ Encapsulation
- ✅ Inheritance
- ✅ Collections (ArrayList)
- ✅ Exception Handling
- ✅ File Handling
- ✅ Packages
- ✅ Layered Architecture
- ✅ Single Responsibility Principle (SRP)

---

# 📁 Data Storage

The application stores data in separate CSV files.

📄 books.csv
📄 students.csv
📄 faculty.csv


Data is automatically loaded when the application starts and saved whenever records are added, removed, issued, or returned.

---

# 🚀 Future Enhancements

- 🗄️ MySQL Integration using JDBC
- 🌐 Spring Boot REST API
- 🔐 User Authentication
- 💰 Fine Calculation
- 🔍 Search by Title/Author
- 📊 Dashboard & Reports

---

# 👨‍💻 Author

**Anil Kumar Bitragunta**

Java Developer | Core Java | SQL | Problem Solving
````




