package assignment5.mapInterface;

import java.util.HashMap;

class Employee {
    private String name;
    private String id;
    private String department;

    public Employee() {
    }

    public Employee(String name, String id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", department=" + department + "]";
    }
}

public class Program8 {
    static HashMap<String, Employee> map = new HashMap<>();

    private static void add(Employee e) {
        map.put(e.getId(), e);
    }

    private static void searchingId(String id) {
        if (map.containsKey(id)) {
            System.out.println(map.get(id));
        } else {
            System.out.println("Not found");
        }
    }

    private static void displayAllEmployees() {
        if (map.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee e : map.values()) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
    	Employee e1 = new Employee("Ravi", "E001", "HR");
        Employee e2 = new Employee("Aditi", "E002", "IT");
        Employee e3 = new Employee("Vikram", "E003", "Finance");
        Employee e4 = new Employee("Neha", "E004", "Marketing");
        add(e1);
        add(e2);
        add(e3);
        add(e4);

        
        searchingId("E001"); 
        searchingId("E005"); 

        
        System.out.println("\nAll Employees:");
        displayAllEmployees();
    }
}
