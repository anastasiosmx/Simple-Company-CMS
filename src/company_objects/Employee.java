package company_objects;
import company_objects.Department;
import utilities.Date;
import java.lang.*;
import java.util.Objects;
import java.util.ArrayList;

public class Employee {
    ArrayList<Department> departments = new ArrayList<Department>();
    String name, specialty, education;
    Date birth_date, start_work, start_manager;
    boolean married, is_manager;
    int num_of_kids;

    public Employee(String name, String birth_date_input, String start_work_input, String married, int num_of_kids, String specialty, String education, String is_manager, String start_manager_input){
        int[] birth_date_int = StringDateTokenizer(birth_date_input);
        int[] start_work_int = StringDateTokenizer(start_work_input);

        Date birth_date = new Date(birth_date_int[0], birth_date_int[1], birth_date_int[2]);
        Date start_work = new Date(start_work_int[0], start_work_int[1], start_work_int[2]);

        this.name = name;
        this.birth_date = birth_date;
        this.start_work = start_work;
        this.married = IsTrue(married);
        this.num_of_kids = num_of_kids;
        this.specialty = specialty;
        this.education = education;
        this.is_manager = IsTrue(is_manager);

        if(!this.is_manager){
            Date start_manager = new Date(1,1,1);
            this.start_manager = start_manager;
        }else{
            int[] start_manager_int =  StringDateTokenizer(start_manager_input);
            Date start_manager = new Date(start_manager_int[0], start_manager_int[1], start_manager_int[2]);

            this.start_manager = start_manager;
        }
    }

    public int[] StringDateTokenizer(String birth_date_input){
        String[] birth_date_split = birth_date_input.split("/");
        int b_day = Integer.parseInt(birth_date_split[0]);
        int b_month = Integer.parseInt(birth_date_split[1]);
        int b_year = Integer.parseInt(birth_date_split[2]);

        return new int[]{b_day,b_month,b_year};
    }

    public boolean IsTrue(String object){return Objects.equals("Y", object.toUpperCase());}

    public void Add_to_Department(Department department){
        departments.add(department);
    }

}
