import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        EmployeePayrollService payrollService = new EmployeePayrollService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Payroll Service Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    payrollService.addEmployee(id, name, salary);
                    break;
                case 2:
                    payrollService.writeEmployeeToConsole();
                    break;
                case 3:
                    System.out.println("Exiting Employee Payroll Service.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}