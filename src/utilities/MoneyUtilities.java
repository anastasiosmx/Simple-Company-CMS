package utilities;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import company_objects.Department;
import company_objects.Project;


public class MoneyUtilities {
    static final HashMap<Integer,Integer> EDUCATION_SUBSIDY = new HashMap<Integer, Integer>();
    static {
        EDUCATION_SUBSIDY.put(1, 0);
        EDUCATION_SUBSIDY.put(2, 80);
        EDUCATION_SUBSIDY.put(3, 160);
        EDUCATION_SUBSIDY.put(4, 240);
    }

    public int TotalDepartmentsEmployeesSalary(Department department){
        int total_employee_salary = 0;

        for(int i = 0 ; i < department.getEmployeeList().size() ; i++){
            total_employee_salary += department.getEmployeeList().get(i).getSalary();
        }
        return total_employee_salary;
    }

    public int yearSubsidyCounter(String start_year_tmp){
        StringManipulation m1 = new StringManipulation();

        int subsidy = 0;
        int system_year = Calendar.getInstance().get(Calendar.YEAR);

        int[] start_year_split = m1.StringDateTokenizer(start_year_tmp);

        int active_years = system_year - start_year_split[2];
        int subsidy_years = active_years / 3;

        if(subsidy_years >= 3){
            for(int i = 1 ; i <= subsidy_years ; i++){
                subsidy = subsidy + (i * 40);
            }

            return subsidy;
        }
        return subsidy;
    }

    public int kidsSubsidyCounter(int num_of_kids){
        int subsidy = 0;

        if((num_of_kids >= 1) && (num_of_kids < 4)){
            for(int i = 1 ; i <= num_of_kids ; i++){
                subsidy = subsidy + (i * 60);
            }
            return subsidy;
        }
        return subsidy;
    }

    public int educationSubsidyCounter(int education_level) {
        int subsidy = EDUCATION_SUBSIDY.get(education_level);
        return subsidy;
    }

    public int trueProjectIncome(Project project){
        int total_expenses = project.getGeneral_expenses() + project.getOperating_expenses() + project.getTotalProjectsEmployeesSalary();
        int true_income = project.getGross_revenue() - total_expenses;
        return true_income;
    }

    public Project bestProject(ArrayList<Project> project){
        int max_income = 0;
        Project d1 = new Project();
        MoneyUtilities m1 = new MoneyUtilities();

        for(int i = 0 ; i < project.size() ; i++){
            if(m1.trueProjectIncome(project.get(i)) > max_income){
                max_income = m1.trueProjectIncome(project.get(i));
                d1 = project.get(i);
            }
        }
        return d1;
    }
}
