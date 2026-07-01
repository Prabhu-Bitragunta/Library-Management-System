package service;

import java.util.ArrayList;

import exception.LibraryManagementException;
import model.Faculty;

public class FacultyService {

    private ArrayList<Faculty> facultyList = new ArrayList<>();

    // Register Faculty
    public void registerFaculty(Faculty faculty) {

        facultyList.add(faculty);

        System.out.println("Faculty registered successfully.");

    }

    // Search Faculty
    public Faculty searchFaculty(int facultyId)
            throws LibraryManagementException {

        for (Faculty faculty : facultyList) {

            if (faculty.getUserId() == facultyId) {
                return faculty;
            }

        }

        throw new LibraryManagementException("Faculty not found.");

    }

    // Display Faculty
    public void displayFaculty() {

        if (facultyList.isEmpty()) {

            System.out.println("No faculty available.");
            return;

        }

        for (Faculty faculty : facultyList) {

            System.out.println("-------------------------");
            faculty.displayDetails();

        }

    }

    // Remove Faculty
    public void removeFaculty(int facultyId)
            throws LibraryManagementException {

        Faculty faculty = searchFaculty(facultyId);

        facultyList.remove(faculty);

        System.out.println("Faculty removed successfully.");

    }

    public ArrayList<Faculty> getFaculty() {
        return facultyList;
    }

    public void setFaculty(ArrayList<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

}