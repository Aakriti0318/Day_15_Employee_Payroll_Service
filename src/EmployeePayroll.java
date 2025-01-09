class EmployeePayroll {
    private int id;
    private String name;
    private double salary;

    // Constructor
    public EmployeePayroll(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // toString method for displaying employee details
    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Salary: $" + salary;
    }
}
