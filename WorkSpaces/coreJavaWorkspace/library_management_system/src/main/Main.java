package main;

import java.util.Scanner;

import exception.LibraryManagementException;
import model.Book;
import model.Faculty;
import model.Student;
import service.BookService;
import service.FacultyService;
import service.StudentService;
import util.BookFileUtil;
import util.FacultyFileUtil;
import util.StudentFileUtil;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BookService bookService = new BookService();
        StudentService studentService = new StudentService();
        FacultyService facultyService = new FacultyService();

        // Load data
        bookService.setBooks(BookFileUtil.loadBooks());
        studentService.setStudents(StudentFileUtil.loadStudents());
        facultyService.setFaculty(FacultyFileUtil.loadFaculty());

        int choice;

        do {

            System.out.println("\n========== LIBRARY MANAGEMENT SYSTEM ==========");
            System.out.println("--------------Book Management----------");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Total Books");
            System.out.println("--------------Student Management----------");

            System.out.println("8. Register Student");
            System.out.println("9. Display Students");
            System.out.println("10. Search Student");
            System.out.println("11. Remove Student");
            System.out.println("--------------Faculty Management----------");
            System.out.println("12. Register Faculty");
            System.out.println("13. Display Faculty");
            System.out.println("14. Search Faculty");
            System.out.println("15. Remove Faculty");

            System.out.println("16. Exit");

            System.out.print("\nEnter Choice : ");
            choice = sc.nextInt();

            try {

                switch (choice) {

                // ================= BOOK =================

                case 1:

                    System.out.print("Enter Book ID : ");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title : ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author : ");
                    String author = sc.nextLine();

                    try {

                        bookService.searchBook(bookId);

                        System.out.println("Book ID already exists.");

                    } catch (LibraryManagementException e) {

                        Book book = new Book(bookId, title, author);

                        bookService.addBook(book);

                        BookFileUtil.appendBook(book);

                    }

                    break;

                case 2:

                    bookService.displayBooks();

                    break;

                case 3:

                    System.out.print("Enter Book ID : ");

                    System.out.println(bookService.searchBook(sc.nextInt()));

                    break;

                case 4:

                    System.out.print("Enter Book ID : ");

                    bookService.removeBook(sc.nextInt());

                    BookFileUtil.saveBooks(bookService.getBooks());

                    break;

                case 5:

                    System.out.print("Enter Book ID : ");
                    int issueBookId = sc.nextInt();

                    System.out.println("\nIssue To");
                    System.out.println("1. Student");
                    System.out.println("2. Faculty");

                    System.out.print("Enter Choice : ");
                    int option = sc.nextInt();

                    if(option == 1){

                        System.out.print("Enter Student ID : ");
                        int sid = sc.nextInt();

                        studentService.searchStudent(sid);

                        bookService.issueBook(
                                issueBookId,
                                sid,
                                "STUDENT");

                    }

                    else if(option == 2){

                        System.out.print("Enter Faculty ID : ");
                        int fid = sc.nextInt();

                        facultyService.searchFaculty(fid);

                        bookService.issueBook(
                                issueBookId,
                                fid,
                                "FACULTY");

                    }

                    else{

                        System.out.println("Invalid Choice.");

                    }

                    BookFileUtil.saveBooks(bookService.getBooks());

                    break;

                case 6:

                    System.out.print("Enter Book ID : ");

                    bookService.returnBook(sc.nextInt());

                    BookFileUtil.saveBooks(bookService.getBooks());

                    break;

                case 7:

                    System.out.println("Total Books : "
                            + bookService.totalBooks());

                    break;
                    // ================= STUDENT =================

                    case 8:

                        System.out.print("Enter Student ID : ");
                        int studentId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Student Name : ");
                        String studentName = sc.nextLine();

                        try {

                            studentService.searchStudent(studentId);

                            System.out.println("Student ID already exists.");

                        } catch (LibraryManagementException e) {

                            Student student =
                                    new Student(studentId, studentName);

                            studentService.registerStudent(student);

                            StudentFileUtil.appendStudent(student);

                        }

                        break;

                    case 9:

                        studentService.displayStudents();

                        break;

                    case 10:

                        System.out.print("Enter Student ID : ");

                        System.out.println(
                                studentService.searchStudent(sc.nextInt()));

                        break;

                    case 11:

                        System.out.print("Enter Student ID : ");

                        studentService.removeStudent(sc.nextInt());

                        StudentFileUtil.saveStudents(
                                studentService.getStudents());

                        break;

                    // ================= FACULTY =================

                    case 12:

                        System.out.print("Enter Faculty ID : ");
                        int facultyId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Faculty Name : ");
                        String facultyName = sc.nextLine();

                        try {

                            facultyService.searchFaculty(facultyId);

                            System.out.println("Faculty ID already exists.");

                        } catch (LibraryManagementException e) {

                            Faculty faculty =
                                    new Faculty(facultyId, facultyName);

                            facultyService.registerFaculty(faculty);

                            FacultyFileUtil.appendFaculty(faculty);

                        }

                        break;

                    case 13:

                        facultyService.displayFaculty();

                        break;

                    case 14:

                        System.out.print("Enter Faculty ID : ");

                        System.out.println(
                                facultyService.searchFaculty(sc.nextInt()));

                        break;

                    case 15:

                        System.out.print("Enter Faculty ID : ");

                        facultyService.removeFaculty(sc.nextInt());

                        FacultyFileUtil.saveFaculty(
                                facultyService.getFaculty());

                        break;

                    case 16:

                        System.out.println("Thank You!");

                        break;

                    default:

                        System.out.println("Invalid Choice.");

                    }

                } catch (LibraryManagementException e) {

                    System.out.println(e.getMessage());

                }

            } while (choice != 16);

            sc.close();

        }

    }