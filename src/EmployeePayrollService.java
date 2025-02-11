import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import static java.nio.file.StandardWatchEventKinds.*;

public class EmployeePayrollService {
    private static final String PAYROLL_FILE_NAME = "employeePayroll.txt";

    private static final String File_Path = "C:\\Users\\taakr\\IdeaProjects\\Day15_Employee_Payroll_sol\\src\\employeePayroll.txt";
    private List<EmployeePayroll> employeeList = new ArrayList<>();

    // Method to add an employee
    public void addEmployee(int id, String name, double salary) {
        EmployeePayroll employee = new EmployeePayroll(id, name, salary);
        employeeList.add(employee);
        System.out.println("Employee added successfully.");
    }

    public void writeEmployeeToConsole() {
        System.out.println("\nEmployee Payroll Details:");
        for (EmployeePayroll employee : employeeList) {
            System.out.println(employee);
        }
    }

    public void performFileOperations() throws IOException {
        File file = new File(PAYROLL_FILE_NAME);
        File filePath = new File(File_Path);
        // Check if file exists
        if (file.exists()) {
            System.out.println("File exists." + filePath);
            // Delete file
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            }
        } else {
            System.out.println("File does not exist.");
        }

        // Create a directory
        File directory = new File("testDirectory");
        if (directory.mkdir()) {
            System.out.println("Directory created.");
        }

        // Create an empty file
        if (file.createNewFile()) {
            System.out.println("Empty file created.");
        }

        // List files and directories
        File currentDir = new File(".");
        String[] files = currentDir.list();
        System.out.println("Files and Directories:");
        for (String fileName : files) {
            System.out.println(fileName);
        }
    }

    //UC3
    public void watchDirectory(String directoryPath) throws IOException, InterruptedException {
        Path path = Paths.get(directoryPath);
        WatchService watchService = FileSystems.getDefault().newWatchService();

        path.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

        System.out.println("Watching directory: " + directoryPath);

        while (true) {
            WatchKey key = watchService.take();

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                System.out.println("Event: " + kind + " on " + event.context());
            }

            if (!key.reset()) break; // Exit if the watch key is invalid
        }
    }

    // UC 4: Write Employee Payroll to File
    public void writeEmployeeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PAYROLL_FILE_NAME))) {
            for (EmployeePayroll employee : employeeList) {
                writer.write(employee.toString());
                writer.newLine();
            }
            System.out.println("Employee Payroll written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printEmployeePayrolls() {
        File file = new File(PAYROLL_FILE_NAME);

        if (!file.exists()) {
            System.out.println("Payroll file does not exist.");
            return;
        }

        try (
                BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int count = 0;
            System.out.println("Employee Payrolls:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                count++;
            }
            System.out.println("Total Entries: " + count);
        } catch (IOException e) {
            System.out.println("Error reading payroll file: " + e.getMessage());
        }
    }

    static class Employee {
        String id;
        String name;
        double salary;

        Employee(String id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }
    }

    // Read the payroll file and perform analysis
    public void analyzeEmployeePayroll() {
        File file = new File(PAYROLL_FILE_NAME);

        if (!file.exists()) {
            System.out.println("Payroll file does not exist.");
            return;
        }
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String id = parts[0];
                    String name = parts[1];
                    double salary = Double.parseDouble(parts[2]);
                    employees.add(new Employee(id, name, salary));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading payroll file: " + e.getMessage());
            return;


        }
    }
}