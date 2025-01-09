
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
            System.out.println("5. Write Employee Payroll to File");
            System.out.println("6. Print all employee payroll details from the file");
            System.out.println("7. Exit");
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
                //UC4
                case 5:
                    payrollService.writeEmployeeToFile();
                    break;
                //UC5
                case 6:
                    payrollService.printEmployeePayrolls();
                    break;
                case 7:
                    System.out.println("Exiting Employee Payroll Service.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}