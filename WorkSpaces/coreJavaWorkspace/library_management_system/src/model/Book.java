package model;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private boolean issued;
    private int issuedToId;
    private String borrowerType;

    public Book(int bookId, String title, String author) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.issued = false;
        this.issuedToId = 0;
        this.borrowerType = "NONE";

    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public int getIssuedToId() {
        return issuedToId;
    }

    public void setIssuedToId(int issuedToId) {
        this.issuedToId = issuedToId;
    }

    public String getBorrowerType() {
        return borrowerType;
    }

    public void setBorrowerType(String borrowerType) {
        this.borrowerType = borrowerType;
    }

    public void displayDetails() {
        System.out.println(this);
    }

    @Override
    public String toString() {

        return "Book ID       : " + bookId +
               "\nTitle         : " + title +
               "\nAuthor        : " + author +
               "\nStatus        : " + (issued ? "Issued" : "Available") +
               "\nBorrower ID   : " + issuedToId +
               "\nBorrower Type : " + borrowerType;
    }
}