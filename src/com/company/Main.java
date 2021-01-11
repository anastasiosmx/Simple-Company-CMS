package com.company;
import company_objects.Employee;
import company_objects.Department;
import company_objects.Project;
import utilities.EmployeeManipulation;


public class Main {

    public static void main(String[] args) {
        Employee e1 = new Employee("Anastasios", "10/05/1997", "20/02/2020", "Y", 2, "Software Engineer", 3);
        EmployeeManipulation man = new EmployeeManipulation();

        Employee e2 = new Employee("Mitsos", "10/05/1995", "10/02/2020", "Y", 1, "FrontEnd Developer", 1);

        Department d1 = new Department("SEO", "The best dep",e1);

        Department d2 = new Department("dep2", "The best dep",e2);

        man.MoveEmployee(e1,d1, "Y", "10/10/2020");
        man.MoveEmployee(e2,d2,"Y",  "5/10/2020");
        man.MoveEmployee(e1,d2, "Y", "10/10/2020");

        Project Acropolis = new Project("Acropolis", "Acropolis maintenance", "256788", "100000", "20000");
        Acropolis.setEmployeeToProject(e1,"10/05/2020","20/07/2020");
        e1.setProjectToEmployee(Acropolis);
    }
}
