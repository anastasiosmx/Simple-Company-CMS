package utilities;
import company_objects.Department;
import company_objects.Employee;


public class EmployeeManipulation {
    public void MoveEmployee(Employee employee, Department department, String is_manager_input, String start_manager_input){
        Department old_dep;
        boolean is_manager;
        StringManipulation man = new StringManipulation();

        is_manager = man.IsTrue(is_manager_input);

        if(!is_manager){
            Date start_manager = new Date(1,1,1);

            employee.setStartManager(start_manager);
            employee.setSalary(0, employee.project_list.size());
            employee.setIsManager("n");

            if(employee.getDepartment() != null){
                old_dep = employee.getDepartment();
                old_dep.setManager(null);
            }

            department.add_Employee(employee);
        }else{
            int[] start_manager_int =   man.StringDateTokenizer(start_manager_input);
            Date start_manager      =   new Date(start_manager_int[0], start_manager_int[1], start_manager_int[2]);

            employee.setStartManager(start_manager);
            employee.setSalary(400, employee.project_list.size());
            employee.setIsManager("y");

            department.setManager(employee);
            department.add_Employee(employee);

            System.out.println("New manager! Say hello to "+department.getManager().getName());
        }
    }

    public String toDateString(Date other){
        String date = other.getDay()+"/"+ other.getMonth()+"/"+ other.getYear();
        return date;
    }

    public String toDateStringReversed(Date other){
        String date;
        if((other.getMonth() < 10) && (other.getDay() < 10)){
            date = other.getYear()+"-0"+other.getMonth()+"-0"+other.getDay();
        }else if((other.getMonth() < 10) && (other.getDay() > 9)){
            date = other.getYear()+"-0"+other.getMonth()+"-"+other.getDay();
        }else if((other.getMonth() > 9) && (other.getDay() < 10)){
            date = other.getYear()+"-"+other.getMonth()+"-0"+other.getDay();
        }else{
            date = other.getYear()+"-"+other.getMonth()+"-"+other.getDay();
        }

        return date;
    }
}
