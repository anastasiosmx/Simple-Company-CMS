package utilities;
import java.util.Calendar;
import java.util.HashMap;

import company_objects.Department;
import company_objects.Employee;


public class EmployeeManipulation {
    static final HashMap<Integer,Integer> EDUCATION_SUBSIDY = new HashMap<Integer, Integer>();
    static {
        EDUCATION_SUBSIDY.put(1, 0);
        EDUCATION_SUBSIDY.put(2, 80);
        EDUCATION_SUBSIDY.put(3, 160);
        EDUCATION_SUBSIDY.put(4, 240);
    }


    public void MoveEmployee(Employee employee, Department department){
        employee.set_Department(department);
    }

    public int yearSubsidyCounter(String start_year_tmp){
        System.out.println("EDW: "+start_year_tmp);
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

    public String toDateString(Date other){
        String date = other.getDay()+"/"+ other.getMonth()+"/"+ other.getYear();
        return date;
    }
}
