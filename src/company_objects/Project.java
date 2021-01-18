package company_objects;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import utilities.StringManipulation;
import utilities.Date;
import utilities.EmployeeManipulation;


public class Project {
    HashMap<Employee, HashMap<String, String>> employee_list;
    private ArrayList<Employee> employees;
    private Date begin_date, end_date;

    String project_name, description;
    int gross_revenue, general_expenses, operating_expenses;

    public Project(){}

    public Project(String project_name, String description, String gross_revenue, String general_expenses, String operating_expenses){
        employee_list = new HashMap<Employee, HashMap<String, String>>();
        employees = new ArrayList<Employee>();
        this.project_name       = project_name;
        this.description        = description;
        this.general_expenses   = Integer.parseInt(general_expenses);
        this.gross_revenue      = Integer.parseInt(gross_revenue);
        this.operating_expenses = Integer.parseInt(operating_expenses);
    }

    public void setStartingDate(String begin_date_input){
        StringManipulation manipulated_string   = new StringManipulation();
        int[] begin_date_split                  = manipulated_string.StringDateTokenizer(begin_date_input);
        Date begin_date                         = new Date(begin_date_split[0], begin_date_split[1], begin_date_split[2]);
        this.begin_date                         = begin_date;
    }

    public void setEndingDate(String end_date_input){
        StringManipulation manipulated_string   = new StringManipulation();
        int[] end_date_split                    = manipulated_string.StringDateTokenizer(end_date_input);
        Date end_date                           = new Date(end_date_split[0], end_date_split[1], end_date_split[2]);
        this.end_date                           = end_date;
    }

    public void setEmployeeToProject(Employee employee, String begin_date, String end_date){
        setStartingDate(begin_date);
        setEndingDate(end_date);
        long total_salary_input = EmployeeTotalSalary();

        String total_salary = String.valueOf(total_salary_input);

        employees.add(employee);

        employee_list.put(employee, new HashMap<String, String>(){
            {put("Begin_date", getBegin_date().getDay()+"/"+getBegin_date().getMonth()+"/"+getBegin_date().getYear());}
            {put("End_date", getEnd_date().getDay()+"/"+getEnd_date().getMonth()+"/"+getEnd_date().getYear());}
            {put("Total_Salary", total_salary);}
        });
    }

    public long EmployeeTotalSalary(){
        EmployeeManipulation m1 = new EmployeeManipulation();
        long total_salary = 0;

        long monthsBetween = ChronoUnit.MONTHS.between(
                LocalDate.parse(m1.toDateStringReversed(this.begin_date)).withDayOfMonth(1),
                LocalDate.parse(m1.toDateStringReversed(this.end_date)).withDayOfMonth(1));

        total_salary =  monthsBetween * 100;

        return total_salary;
    }

    public Date getBegin_date(){return this.begin_date;}

    public Date getEnd_date(){return this.end_date;}

    public HashMap getEmployee_List(){return this.employee_list;}

    public int getTotalProjectsEmployeesSalary(){
        int total_employee_salary = 0;
        Employee e1;

        for(int i = 0; i < this.employees.size() ; i++){
            e1 = this.employees.get(i);
            total_employee_salary += Integer.parseInt(this.employee_list.get(e1).get("Total_Salary"));
        }

        return total_employee_salary;
    }

    public String getProject_name(){return this.project_name;}

    public int getGross_revenue(){return this.gross_revenue;}

    public int getGeneral_expenses(){return this.general_expenses;}

    public int getOperating_expenses(){return this.operating_expenses;}

    public String getDescription(){return  this.description;}
}
