package util;

import java.io.*;
import java.util.ArrayList;

import model.Student;

public class StudentFileUtil {

    private static final String FILE_NAME = "students.csv";
    private static final String HEADER = "StudentId,Name";

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

    // Append Student
    public static void appendStudent(Student student) {

        try (BufferedWriter bw =
                new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            bw.write(student.getUserId() + "," +
                     student.getName());

            bw.newLine();

        } catch (IOException e) {

            System.out.println(e.getMessage());

        }

    }

    // Load Students
    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        try (BufferedReader br =
                new BufferedReader(new FileReader(FILE_NAME))) {

            br.readLine();

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                Student student = new Student(

                        Integer.parseInt(data[0]),
                        data[1]);

                students.add(student);

            }

        } catch (IOException e) {

            System.out.println(e.getMessage());

        }

        return students;

    }

    // Save Students
    public static void saveStudents(ArrayList<Student> students) {

        try (BufferedWriter bw =
                new BufferedWriter(new FileWriter(FILE_NAME))) {

            bw.write(HEADER);
            bw.newLine();

            for (Student student : students) {

                bw.write(student.getUserId() + "," +
                         student.getName());

                bw.newLine();

            }

        } catch (IOException e) {

            System.out.println(e.getMessage());

        }

    }

}