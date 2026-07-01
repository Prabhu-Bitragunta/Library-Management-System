package service;

import java.util.ArrayList;

import exception.LibraryManagementException;
import model.Book;

public class BookService {

    private ArrayList<Book> books = new ArrayList<>();

    // Add Book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // Search Book
    public Book searchBook(int bookId)
            throws LibraryManagementException {

        for (Book book : books) {

            if (book.getBookId() == bookId) {
                return book;
            }

        }

        throw new LibraryManagementException("Book not found.");
    }

    // Display Books
    public void displayBooks() {

        if (books.isEmpty()) {

            System.out.println("No books available.");
            return;

        }

        for (Book book : books) {

            System.out.println("----------------------------");
            book.displayDetails();

        }

    }

    // Remove Book
    public void removeBook(int bookId)
            throws LibraryManagementException {

        Book book = searchBook(bookId);

        books.remove(book);

        System.out.println("Book removed successfully.");

    }

    // Issue Book
    public void issueBook(int bookId,
                          int borrowerId,
                          String borrowerType)
            throws LibraryManagementException {

        Book book = searchBook(bookId);

        if (book.isIssued()) {

            throw new LibraryManagementException("Book is already issued.");

        }

        book.setIssued(true);
        book.setIssuedToId(borrowerId);
        book.setBorrowerType(borrowerType);

        System.out.println("Book issued successfully.");

    }

    // Return Book
    public void returnBook(int bookId)
            throws LibraryManagementException {

        Book book = searchBook(bookId);

        if (!book.isIssued()) {

            throw new LibraryManagementException("Book is not issued.");

        }

        book.setIssued(false);
        book.setIssuedToId(0);
        book.setBorrowerType("NONE");

        System.out.println("Book returned successfully.");

    }

    // Total Books
    public int totalBooks() {
        return books.size();
    }

    // Getter
    public ArrayList<Book> getBooks() {
        return books;
    }

    // Setter
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

}