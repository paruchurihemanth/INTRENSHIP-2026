import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    String department;

    Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
}

public class Main {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Department");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    updateDepartment();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    static void addEmployee() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Department: ");
        String dept = sc.nextLine();

        employees.add(new Employee(id, name, dept));
        System.out.println("Employee added successfully.");
    }

    static void viewEmployees() {
        for (Employee e : employees) {
            System.out.println(e.id + " | " + e.name + " | " + e.department);
        }
    }

    static void searchEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Employee e : employees) {
            if (e.id == id) {
                System.out.println("Found: " + e.name + " (" + e.department + ")");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    static void updateDepartment() {
        System.out.print("Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Employee e : employees) {
            if (e.id == id) {
                System.out.print("New Department: ");
                e.department = sc.nextLine();
                System.out.println("Department updated.");
                return;
            }
        }

        System.out.println("Employee not found.");
    }
}