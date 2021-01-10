package com.company;
import company_objects.Employee;
import company_objects.Department;
import company_objects.Project;
import utilities.EmployeeManipulation;
import utilities.MoneyUtilities;


public class Main {

    public static void main(String[] args) {
        Employee e1 = new Employee("Anastasios", "10/05/1997", "20/02/2020", "Y", 2, "Software Engineer", 1, "y", "10/10/2020");
        EmployeeManipulation man = new EmployeeManipulation();

        Department d1 = new Department("SEO", "The best dep",e1);
        System.out.println("Department manager = "+d1.getDepartment_name());

        Department d2 = new Department("dep2", "The best dep",e1);
        System.out.println("Department manager = "+d2.getDepartment_name());

        man.MoveEmployee(e1,d1);
        System.out.println("E1 Deprtment = "+e1.getDepartment().getDepartment_name());

        man.MoveEmployee(e1,d2);
        System.out.println("E1 NEW Deprtment = "+e1.getDepartment().getDepartment_name());

        Project Acropolis = new Project("Acropolis", "Acropolis maintenance", "256788", "100000", "20000");
        Acropolis.setEmployeeToProject(e1,"10/05/2020","20/07/2020");
        e1.setProjectToEmployee(Acropolis);
        System.out.println("Begin date= "+Acropolis.getEmployee_List());

        System.out.println("PROJECT EMPLOYEE LIST = "+Acropolis.getEmployee_List());

        System.out.println("E1 salary = "+ e1.getSalary());



    }
}
