import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Age: " + age;
    }
}

public class StudentManagementSystem {

    private static final String FILE_NAME = "students.txt";

    public static void addStudent(Student student) {

        try (BufferedWriter bw =
                new BufferedWriter(
                        new FileWriter(FILE_NAME, true))) {

            bw.write(student.getId() + "," +
                     student.getName() + "," +
                     student.getAge());

            bw.newLine();

            System.out.println("Student Added Successfully!");

        } catch (IOException e) {

            System.out.println("Error Writing File: "
                               + e.getMessage());
        }
    }

    public static void displayStudents() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No student records found.");
            return;
        }

        try (BufferedReader br =
                new BufferedReader(
                        new FileReader(FILE_NAME))) {

            String line;

            System.out.println("\n----- Student Records -----");

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);

                Student student =
                        new Student(id, name, age);

                System.out.println(student);
            }

        } catch (IOException e) {

            System.out.println("Error Reading File: "
                               + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Student Management System =====");

            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Student Age: ");
                    int age = sc.nextInt();

                    Student student =
                            new Student(id, name, age);

                    addStudent(student);

                    break;

                case 2:

                    displayStudents();

                    break;

                case 3:

                    System.out.println("Exiting Program...");
                    sc.close();
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}