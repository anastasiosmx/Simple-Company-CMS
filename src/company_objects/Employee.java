package company_objects;
import utilities.Date;
import utilities.EmployeeManipulation;
import utilities.MoneyUtilities;
import utilities.StringManipulation;
import java.lang.*;
import java.util.HashMap;

//TODO Add Help menu for option on creating employees, deprts etc
public class Employee {
    private String speciality, education_name;
    private boolean married, is_manager;
    private int num_of_kids, educationLevel, salary;
    private Department department;
    private Date start_manager;

    String name;
    Date birth_date, start_work;

    public HashMap<Project, HashMap<String, String>> project_list= new HashMap<Project, HashMap<String, String>>();

    static final HashMap<Integer,String> EDUCATION_LEVELS = new HashMap<Integer, String>();
    static {
        EDUCATION_LEVELS.put(1, "High School");
        EDUCATION_LEVELS.put(2, "University");
        EDUCATION_LEVELS.put(3, "Postgraduate");
        EDUCATION_LEVELS.put(4, "Doctorate");
    }

    public Employee(){}

    public Employee(String name, String birth_date_input, String start_work_input, String married, int num_of_kids, String speciality, int educationLevel){
        StringManipulation string_manipulated = new StringManipulation();

        int[] birth_date_int = string_manipulated.StringDateTokenizer(birth_date_input);
        int[] start_work_int = string_manipulated.StringDateTokenizer(start_work_input);

        Date birth_date = new Date(birth_date_int[0], birth_date_int[1], birth_date_int[2]);
        Date start_work = new Date(start_work_int[0], start_work_int[1], start_work_int[2]);

        this.name           =   name;
        this.birth_date     =   birth_date;
        this.start_work     =   start_work;


        setSpecialInfo(educationLevel, num_of_kids, speciality, married);
    }

    public void set_Department(Department department){this.department = department;}

    public void setMarriedState(String married){
        StringManipulation string_manipulated = new StringManipulation();
        this.married = string_manipulated.IsTrue(married);
    }

    public void setSpecialty(String speciality){this.speciality = speciality;}

    public void setNum_of_kids(int num_of_kids){this.num_of_kids = num_of_kids;}

    public void setEducationLevel(int educationLevel){
        String education_name = EDUCATION_LEVELS.get(educationLevel);
        this.educationLevel = educationLevel;
        this.education_name = education_name;
    }

    public void setSpecialInfo(int educationLevel, int num_of_kids, String speciality, String married){
        setEducationLevel(educationLevel);
        setNum_of_kids(num_of_kids);
        setSpecialty(speciality);
        setMarriedState(married);
    }

    public void setSalary(int manager_subsidy, int num_of_projects){
        int salary = 0;
        EmployeeManipulation m1 = new EmployeeManipulation();
        MoneyUtilities m2 = new MoneyUtilities();

        String start_work = m1.toDateString(this.start_work);

        salary = 750 + m2.yearSubsidyCounter(start_work) + m2.kidsSubsidyCounter(this.num_of_kids) + m2.educationSubsidyCounter(this.educationLevel) + manager_subsidy + (100 * num_of_projects);

        this.salary = salary;
    }

    public void setProjectToEmployee(Project project){
        project_list.put(project, new HashMap(){
            {put("Begin_date", project.getBegin_date().getDay()+"/"+project.getBegin_date().getMonth()+"/"+project.getBegin_date().getYear());}
            {put("End_date", project.getEnd_date().getDay()+"/"+project.getEnd_date().getMonth()+"/"+project.getEnd_date().getYear());}
        });
    }

    public void setIsManager(String isManager){
        StringManipulation man1 = new StringManipulation();
        this.is_manager = man1.IsTrue(isManager);
    }

    public void setStartManager(Date start_manager_input){this.start_manager = start_manager_input;}

    public Department getDepartment(){return this.department;}

    public boolean getMarriedState(){return this.married;}

    public String getSpeciality(){return this.speciality;}

    public String getEducation_name(){return this.education_name;}

    public int getNum_of_kids(){return this.num_of_kids;}

    public int getEducationLevel(){return this.educationLevel;}

    public Date getStart_work(){return this.start_work;}

    public boolean getManagerState(){return this.is_manager;}

    public Date getStart_manager(){return this.start_manager;}

    public String getName(){return this.name;}

    public int getSalary(){return this.salary;}

    public HashMap<Project, HashMap<String,String>> getProject_list(){return this.project_list;}
}
