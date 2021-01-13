package com.company;
import company_objects.Employee;
import company_objects.Department;
import company_objects.Project;
import utilities.EmployeeManipulation;
import utilities.MoneyUtilities;
import utilities.File_utilities;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        ArrayList<Employee> employees;
        ArrayList<Department> departments;
        ArrayList<Project> all_projects;

        File_utilities f = new File_utilities();
        employees = f.readEmployeesFromDir("C:\\Users\\Anastasios\\Desktop\\Company_Cms\\DB\\Employees");
        departments = f.readDepartmentsFromDir("C:\\Users\\Anastasios\\Desktop\\Company_Cms\\DB\\Departments");
        all_projects = f.readProjectsFromDir("C:\\Users\\Anastasios\\Desktop\\Company_Cms\\DB\\Projects");

        f.setProjectsToEmployees("C:\\Users\\Anastasios\\Desktop\\Company_Cms\\DB\\Employees", employees, all_projects);

        //Project proj1 = new Project();

        MoneyUtilities m1 = new MoneyUtilities();
        EmployeeManipulation man = new EmployeeManipulation();

        Employee e1 = new Employee("Anastasios", "10/05/1997", "20/02/2020", "Y", 2, "Software Engineer", 3);
        Employee e2 = new Employee("Mitsos", "10/05/1995", "10/02/2020", "Y", 1, "FrontEnd Developer", 1);

        Department d1 = new Department("Software Analysis", "The best dep");
        Department d2 = new Department("Social Media", "The best dep");

        man.MoveEmployee(e1,d1, "Y", "10/10/2020");
        man.MoveEmployee(e2,d2,"Y",  "5/10/2020");
        man.MoveEmployee(e1,d2, "n", "10/10/2020");

        Project Acropolis = new Project("Acropolis", "Acropolis maintenance", "256788", "100000", "20000");
        //all_projects.add(Acropolis);
        Acropolis.setEmployeeToProject(e1,"10/05/2020","20/07/2020");
        Acropolis.setEmployeeToProject(e2,"10/05/2020","20/08/2020");

        Project SNF = new Project("Stavros Niarxos Foundation", "Construction of SNF building", "400000", "5000", "10000");
        //all_projects.add(SNF);

        e1.setProjectToEmployee(Acropolis);
        e2.setProjectToEmployee(Acropolis);

        //System.out.println(d2.getDepartment_name()+" total employees salary = "+m1.TotalDepartmentsEmployeesSalary(d2));
        //System.out.println("Total employees salary for the project "+Acropolis.getProject_name()+" is "+Acropolis.getTotalProjectsEmployeesSalary());
        //System.out.println("Total income for a project = "+m1.trueProjectIncome(Acropolis));

       // proj1 = m1.bestProject(all_projects);
        //System.out.println("The best project, based on the total income is "+proj1.getProject_name());
    }
}
