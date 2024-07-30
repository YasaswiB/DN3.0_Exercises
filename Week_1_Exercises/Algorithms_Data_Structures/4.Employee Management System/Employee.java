import java.util.Scanner;

public class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    private static Employee[] employeeList = new Employee[100];
    private static int employeeCount = 0;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public static void addNewEmployee(int employeeId, String name, String position, double salary) {
        if (employeeCount < employeeList.length) {
            employeeList[employeeCount++] = new Employee(employeeId, name, position, salary);
            System.out.println("Employee ID " + employeeId + " has been successfully added.");
        } else {
            System.out.println("Cannot add more employees, list is full.");
        }
        showAllEmployees();
    }

    public static void removeEmployee(int employeeId) {
        for (int i = 0; i < employeeCount; i++) {
            if (employeeList[i].employeeId == employeeId) {
                for (int j = i; j < employeeCount - 1; j++) {
                    employeeList[j] = employeeList[j + 1];
                }
                employeeList[--employeeCount] = null;
                System.out.println("Employee ID " + employeeId + " has been removed.");
                showAllEmployees();
                return;
            }
        }
        System.out.println("No employee found with ID " + employeeId + ".");
    }

    public static void findEmployee(int employeeId) {
        for (Employee employee : employeeList) {
            if (employee != null && employee.employeeId == employeeId) {
                System.out.println("Employee details: " + employee);
                return;
            }
        }
        System.out.println("No employee found with ID " + employeeId + ".");
    }

    public static void showAllEmployees() {
        System.out.println("------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-15s | %-10s |\n", "Employee ID", "Name", "Position", "Salary");
        System.out.println("------------------------------------------------------");
        for (Employee employee : employeeList) {
            if (employee != null) {
                System.out.printf("| %-10d | %-20s | %-15s | %-10.2f |\n", employee.employeeId, employee.name, employee.position, employee.salary);
            }
        }
        System.out.println("------------------------------------------------------");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("----- Employee Management System -----");
            System.out.println("1. Add New Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Search for Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int empId = scanner.nextInt();
                    System.out.print("Enter Employee Name: ");
                    String empName = scanner.next();
                    System.out.print("Enter Employee Position: ");
                    String empPosition = scanner.next();
                    System.out.print("Enter Employee Salary: ");
                    double empSalary = scanner.nextDouble();
                    addNewEmployee(empId, empName, empPosition, empSalary);
                    break;
                case 2:
                    System.out.print("Enter Employee ID: ");
                    int removeId = scanner.nextInt();
                    removeEmployee(removeId);
                    break;
                case 3:
                    System.out.print("Enter Employee ID: ");
                    int searchId = scanner.nextInt();
                    findEmployee(searchId);
                    break;
                case 4:
                    showAllEmployees();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}