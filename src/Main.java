import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        EmployeePayrollService payrollService = new EmployeePayrollService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Payroll Service Menu:");
            System.out.println("1. Add Employee details");
            System.out.println("2. Write the Employees details");
            System.out.println("3. Perform file operations");
            System.out.println("4. Create a Watch Service");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                //UC1
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
                //UC2
                case 3:
                    payrollService.performFileOperations();
                    break;
                //UC3
                case 4:
                    payrollService.watchDirectory("testDirectory");
                    break;
                case 5:
                    System.out.println("Exiting Employee Payroll Service.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}