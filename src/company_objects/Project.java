package company_objects;
import java.util.HashMap;
import utilities.StringManipulation;
import utilities.Date;


public class Project {
    HashMap<Employee, HashMap<String, String>> employee_list= new HashMap<Employee, HashMap<String, String>>();
    private Date begin_date, end_date;

    String project_name, description;
    int gross_revenue, general_expenses, operating_expenses;

    public Project(String project_name, String description, String gross_revenue, String general_expenses, String operating_expenses){
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
        employee_list.put(employee, new HashMap(){
            {put("Begin_date", getBegin_date().getDay()+"/"+getBegin_date().getMonth()+"/"+getBegin_date().getYear());}
            {put("End_date", getEnd_date().getDay()+"/"+getEnd_date().getMonth()+"/"+getEnd_date().getYear());}
        });
    }

    public Date getBegin_date(){return this.begin_date;}

    public Date getEnd_date(){return this.end_date;}

    public HashMap getEmployee_List(){return this.employee_list;}
}
