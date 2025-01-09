import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import static java.nio.file.StandardWatchEventKinds.*;

public class EmployeePayrollService {
    private static final String PAYROLL_FILE_NAME = "employeePayroll.txt";

    private static final String File_Path="C:\\Users\\taakr\\IdeaProjects\\Day15_Employee_Payroll_sol\\src\\employeePayroll.txt";
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
        File filePath=new File(File_Path);
        // Check if file exists
        if (file.exists()) {
            System.out.println("File exists."+filePath);
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

}
