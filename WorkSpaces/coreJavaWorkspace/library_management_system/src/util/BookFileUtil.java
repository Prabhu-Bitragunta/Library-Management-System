package util;

import java.io.*;
import java.util.ArrayList;

import model.Book;

public class BookFileUtil {

    private static final String FILE_NAME = "books.csv";
    private static final String HEADER =
            "BookId,Title,Author,Issued,IssuedToId,BorrowerType";

    static {

        File file = new File(FILE_NAME);

        if (!file.exists()) {

            try (BufferedWriter bw =
                    new BufferedWriter(new FileWriter(file))) {

                bw.write(HEADER);
                bw.newLine();

            } catch (IOException e) {

                System.out.println(e.getMessage());

            }

        }

    }

    // Append Book
    public static void appendBook(Book book) {

        try (BufferedWriter bw =
                new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            bw.write(book.getBookId() + "," +
                    book.getTitle() + "," +
                    book.getAuthor() + "," +
                    book.isIssued() + "," +
                    book.getIssuedToId() + "," +
                    book.getBorrowerType());

            bw.newLine();

        } catch (IOException e) {

            System.out.println(e.getMessage());

        }

    }

    // Load Books
    public static ArrayList<Book> loadBooks() {

        ArrayList<Book> books = new ArrayList<>();

        try (BufferedReader br =
                new BufferedReader(new FileReader(FILE_NAME))) {

            br.readLine();

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                Book book = new Book(

                        Integer.parseInt(data[0]),
                        data[1],
                        data[2]);

                book.setIssued(Boolean.parseBoolean(data[3]));
                book.setIssuedToId(Integer.parseInt(data[4]));
                book.setBorrowerType(data[5]);

                books.add(book);

            }

        } catch (IOException e) {

            System.out.println(e.getMessage());

        }

        return books;

    }

    // Save Books
    public static void saveBooks(ArrayList<Book> books) {

        try (BufferedWriter bw =
                new BufferedWriter(new FileWriter(FILE_NAME))) {

            bw.write(HEADER);
            bw.newLine();

            for (Book book : books) {

                bw.write(book.getBookId() + "," +
                        book.getTitle() + "," +
                        book.getAuthor() + "," +
                        book.isIssued() + "," +
                        book.getIssuedToId() + "," +
                        book.getBorrowerType());

                bw.newLine();

            }

        } catch (IOException e) {

            System.out.println(e.getMessage());

        }

    }

}