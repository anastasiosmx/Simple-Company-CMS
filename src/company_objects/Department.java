package company_objects;
import java.util.ArrayList;


public class Department {
    String department_name, description;
    Employee manager;
    ArrayList<Employee> employees= new ArrayList<Employee>();

    public Department(String department_name, String description, Employee manager){
        this.department_name = department_name;
        this. description = description;
        add_Employee(manager);
        this.manager = manager;
    }

    public void add_Employee(Employee employee){
        employees.add(employee);
    }
}
