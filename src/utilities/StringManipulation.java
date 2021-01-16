package utilities;
import company_objects.Department;
import company_objects.Employee;
import company_objects.Project;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Objects;


public class StringManipulation {
    public int[] StringDateTokenizer(String object){
        String[] object_split = object.split("/");
        int b_day   =   Integer.parseInt(object_split[0]);
        int b_month =   Integer.parseInt(object_split[1]);
        int b_year  =   Integer.parseInt(object_split[2]);

        return new int[]{b_day,b_month,b_year};
    }

    public boolean IsTrue(String object){return Objects.equals("Y", object.toUpperCase());}

    public Employee EmployeeFromFileTokenized(String object_to_be_tokenized){
        String[] res_tmp    =   object_to_be_tokenized.split(":");
        StringManipulation man = new StringManipulation();

        String fullname     =       res_tmp[0];
        String birth_date   =       res_tmp[1];
        String ismarried    =       res_tmp[2];
        String isManager    =       res_tmp[3];
        int num_of_kids     =       Integer.parseInt(res_tmp[4]);
        String started_working  =   res_tmp[5];
        String speciality   =       res_tmp[6];
        int education_level =       Integer.parseInt(res_tmp[7]);

        Employee e = new Employee(fullname, birth_date, started_working, ismarried, num_of_kids, speciality, education_level);
        e.setIsManager(isManager);

        return e;
    }

    public Department DepartmentFromFileTokenized(String object_to_be_tokenized){
        String[] res_tmp    =   object_to_be_tokenized.split(":");

        String dep_name     =   res_tmp[0];
        String dep_descr    =   res_tmp[1];

        Department d = new Department(dep_name, dep_descr);
        return d;
    }

    public Project ProjectFromFileTokenized(String object_to_be_tokenized){
        String[] res_tmp = object_to_be_tokenized.split(":");

        String proj_name    =   res_tmp[0];
        String proj_descr   =   res_tmp[1];
        String groos_rev    =   res_tmp[2];
        String gen_exp      =   res_tmp[3];
        String op_exp       =   res_tmp[4];

        Project p = new Project(proj_name,proj_descr, groos_rev,gen_exp,op_exp);
        return p;
    }

    public void getProjectsfromEmployees(String object_to_be_tokenized, ArrayList<Employee> employees, ArrayList<Project> projects){
        int employee_index = 0, projects_index = 0;
        String[] proj_tmp = new String[100];

        String[] res_tmp    =   object_to_be_tokenized.split(":");
        String employee_name    =   res_tmp[0];

        for(int k = 8 ; k < res_tmp.length ; k++){
            proj_tmp[k-8] = res_tmp[k];
        }

        for(int l = 0 ; l < employees.size() ; l++){
            if(Objects.equals(employee_name, employees.get(l).getName())){
                employee_index = l;
                break;
            }
        }

        for(int i = 0 ; i < proj_tmp.length ; i = i + 5 ){
            if(Objects.equals(proj_tmp[i], "null")){
                break;
            }

            String project_name     = proj_tmp[i];
            String begin_date = proj_tmp[i+2];
            String end_date = proj_tmp[i+3];



            for(int j = 0 ; j < projects.size() ; j++){
                if(Objects.equals(project_name, projects.get(j).getProject_name())){
                    projects_index = j;
                    break;
                }
            }
            projects.get(projects_index).setEmployeeToProject(employees.get(employee_index), begin_date, end_date);
            employees.get(employee_index).setProjectToEmployee(projects.get(projects_index));
        }
    }

    public String[] getDepartmentsToEmployees(String object_to_be_tokenized, ArrayList<Employee> employees, ArrayList<Department> departments){
        int departments_index   = 0;
        int employee_index      = 0;
        String isManager = "", startManagerDate = "";
        EmployeeManipulation man = new EmployeeManipulation();
        String[] res_tmp        =   object_to_be_tokenized.split(":");
        String[] proj_tmp       = new String[100];
        String departments_name = res_tmp[0];



        for(int i = 2 ; i < res_tmp.length ; i++){
            proj_tmp[i-2] = res_tmp[i];
        }

        startManagerDate = proj_tmp[0];

        for(int j = 0 ; j < departments.size() ; j++){
            if(Objects.equals(departments_name, departments.get(j).getDepartment_name())){
                departments_index = j;
                break;
            }
        }

        for(int k = 0 ; k < proj_tmp.length ; k++){
            for(int j = 0 ; j < employees.size() ; j++) {
                if(Objects.equals(proj_tmp[k], employees.get(j).getName())){
                    employee_index = j;
                    if(employees.get(employee_index).getManagerState()){
                        isManager += "y";
                    }else{
                        isManager += "n";
                        startManagerDate += "10/10/2020";
                    }

                    man.MoveEmployee(employees.get(employee_index), departments.get(departments_index), isManager, startManagerDate);
                }
            }
        }



        return proj_tmp;
    }
}
