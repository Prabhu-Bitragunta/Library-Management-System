package service;

import java.util.ArrayList;

import exception.LibraryManagementException;
import model.Student;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    // Register Student
    public void registerStudent(Student student) {

        students.add(student);

        System.out.println("Student registered successfully.");

    }

    // Search Student
    public Student searchStudent(int studentId)
            throws LibraryManagementException {

        for (Student student : students) {

            if (student.getUserId() == studentId) {
                return student;
            }

        }

        throw new LibraryManagementException("Student not found.");

    }

    // Display Students
    public void displayStudents() {

        if (students.isEmpty()) {

            System.out.println("No students available.");
            return;

        }

        for (Student student : students) {

            System.out.println("-------------------------");
            student.displayDetails();

        }

    }

    // Remove Student
    public void removeStudent(int studentId)
            throws LibraryManagementException {

        Student student = searchStudent(studentId);

        students.remove(student);

        System.out.println("Student removed successfully.");

    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

}