package util;

import java.io.*;
import java.util.ArrayList;

import model.Faculty;

public class FacultyFileUtil {

    private static final String FILE_NAME = "faculty.csv";
    private static final String HEADER = "FacultyId,Name";

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

    // Append Faculty
    public static void appendFaculty(Faculty faculty) {

        try (BufferedWriter bw =
                new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            bw.write(faculty.getUserId() + "," +
                     faculty.getName());

            bw.newLine();

        } catch (IOException e) {

            System.out.println(e.getMessage());

        }

    }

    // Load Faculty
    public static ArrayList<Faculty> loadFaculty() {

        ArrayList<Faculty> facultyList = new ArrayList<>();

        try (BufferedReader br =
                new BufferedReader(new FileReader(FILE_NAME))) {

            br.readLine();

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                Faculty faculty = new Faculty(

                        Integer.parseInt(data[0]),
                        data[1]);

                facultyList.add(faculty);

            }

        } catch (IOException e) {

            System.out.println(e.getMessage());

        }

        return facultyList;

    }

    // Save Faculty
    public static void saveFaculty(ArrayList<Faculty> facultyList) {

        try (BufferedWriter bw =
                new BufferedWriter(new FileWriter(FILE_NAME))) {

            bw.write(HEADER);
            bw.newLine();

            for (Faculty faculty : facultyList) {

                bw.write(faculty.getUserId() + "," +
                         faculty.getName());

                bw.newLine();

            }

        } catch (IOException e) {

            System.out.println(e.getMessage());

        }

    }

}