package DSA;

public class Ex4_EmployeeManagementSystem {
    private static final int MAX_EMPLOYEES = 100;
    private Employee[] employees;
    private int size;

    public Ex4_EmployeeManagementSystem() {
        employees = new Employee[MAX_EMPLOYEES];
        size = 0;
    }

    public static void main(String[] args) {
        Ex4_EmployeeManagementSystem system = new Ex4_EmployeeManagementSystem();
        system.addEmployee(new Employee("E001", "Alice", "Manager", 90000));
        system.addEmployee(new Employee("E002", "Bob", "Developer", 70000));
        system.addEmployee(new Employee("E003", "Charlie", "Designer", 60000));

        System.out.println("All Employees:");
        system.traverseEmployees();

        System.out.println("\nSearching for Employee E002:");
        Employee employee = system.searchEmployee("E002");
        if (employee != null) {
            System.out.println("Found: " + employee);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting Employee E002:");
        system.deleteEmployee("E002");
        system.traverseEmployees();
    }

    static class Employee {
        private String employeeId;
        private String name;
        private String position;
        private double salary;

        public Employee(String employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "EmployeeID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: $" + salary;
        }
    }

    // Add an employee to the array
    public void addEmployee(Employee employee) {
        if (size < MAX_EMPLOYEES) {
            employees[size] = employee;
            size++;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    // Search for an employee by employeeId
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by employeeId
    public void deleteEmployee(String employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[size - 1] = null;
            size--;
        } else {
            System.out.println("Employee not found. Cannot delete.");
        }
    }
}

