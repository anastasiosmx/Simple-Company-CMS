package company_objects;
import java.util.ArrayList;


public class Department {
    private String department_name, description;
    private Employee manager;
    private ArrayList<Employee> employees;

    public Department(String department_name, String description){
        employees  = new ArrayList<Employee>();
        setDepartment(department_name, description);
    }

    public void add_Employee(Employee employee){employees.add(employee);}

    public void setDepartment_name(String department_name){this.department_name = department_name;}

    public void setDescription(String description){this.description = description;}

    public void setManager(Employee manager){this.manager = manager;}

    public void setDepartment(String department_name, String description){
        setDepartment_name(department_name);
        setDescription(description);
    }

    public String getDepartment_name(){return this.department_name;}

    public String getDescription(){return  this.description;}

    public Employee getManager(){return this.manager;}

    public ArrayList<Employee> getEmployeeList(){return this.employees;}
}
