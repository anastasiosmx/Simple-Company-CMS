package company_objects;
import utilities.Date;
import utilities.EmployeeManipulation;
import utilities.StringManipulation;
import java.lang.*;
import java.util.HashMap;

//TODO Add Help menu for option on creating employees, deprts etc
public class Employee {
    private String speciality, education_name;
    private boolean married;
    private int num_of_kids, educationLevel, salary;
    private Department department;

    String name;
    Date birth_date, start_work, start_manager;
    boolean is_manager;

    HashMap<Project, HashMap<String, String>> project_list= new HashMap<Project, HashMap<String, String>>();

    static final HashMap<Integer,String> EDUCATION_LEVELS = new HashMap<Integer, String>();
    static {
        EDUCATION_LEVELS.put(1, "High School");
        EDUCATION_LEVELS.put(2, "University");
        EDUCATION_LEVELS.put(3, "Postgraduate");
        EDUCATION_LEVELS.put(4, "Doctorate");
    }


    public Employee(String name, String birth_date_input, String start_work_input, String married, int num_of_kids, String speciality, int educationLevel, String is_manager, String start_manager_input){
        StringManipulation string_manipulated = new StringManipulation();

        int[] birth_date_int = string_manipulated.StringDateTokenizer(birth_date_input);
        int[] start_work_int = string_manipulated.StringDateTokenizer(start_work_input);

        Date birth_date = new Date(birth_date_int[0], birth_date_int[1], birth_date_int[2]);
        Date start_work = new Date(start_work_int[0], start_work_int[1], start_work_int[2]);

        this.name           =   name;
        this.birth_date     =   birth_date;
        this.start_work     =   start_work;
        this.is_manager     =   string_manipulated.IsTrue(is_manager);

        setSpecialInfo(educationLevel, num_of_kids, speciality, married);

        if(!this.is_manager){
            Date start_manager = new Date(1,1,1);
            this.start_manager = start_manager;
            this.salary = setSalary(0, project_list.size());
        }else{
            int[] start_manager_int =  string_manipulated.StringDateTokenizer(start_manager_input);
            Date start_manager = new Date(start_manager_int[0], start_manager_int[1], start_manager_int[2]);
            this.start_manager = start_manager;
            this.salary = setSalary(400, project_list.size());
        }
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

    public int setSalary(int manager_subsidy, int num_of_projects){
        EmployeeManipulation m1 = new EmployeeManipulation();
        int salary = 0;
        String start_work = m1.toDateString(this.start_work);
        System.out.println("EDW2 = "+start_work);

        salary = 750 + m1.yearSubsidyCounter(start_work) + m1.kidsSubsidyCounter(this.num_of_kids) + m1.educationSubsidyCounter(this.educationLevel) + manager_subsidy + (100 * num_of_projects);

        return salary;
    }

    public void setProjectToEmployee(Project project){
        project_list.put(project, new HashMap(){
            {put("Begin_date", project.getBegin_date().getDay()+"/"+project.getBegin_date().getMonth()+"/"+project.getBegin_date().getYear());}
            {put("End_date", project.getEnd_date().getDay()+"/"+project.getEnd_date().getMonth()+"/"+project.getEnd_date().getYear());}
        });
    }

    public Department getDepartment(){return this.department;}

    public boolean getMarriedState(){return this.married;}

    public String getSpeciality(){return this.speciality;}

    public String getEducation_name(){return this.education_name;}

    public int getNum_of_kids(){return this.num_of_kids;}

    public int getEducationLevel(){return this.educationLevel;}

    public Date getStart_work(){return this.start_work;}

    public int getSalary(){return this.salary;}
}
