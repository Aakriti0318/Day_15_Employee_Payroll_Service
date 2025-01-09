import java.util.ArrayList;
import java.util.List;
public class EmployeePayrollService {
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
}
