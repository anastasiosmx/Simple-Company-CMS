package com.company;
import company_objects.Employee;
import company_objects.Department;


public class Main {

    public static void main(String[] args) {
        Employee e1 = new Employee("Anastasios", "10/5/1997", "20/2/2020", "Y", 2, "Software Engineer", "University", "y", "10/10/2020");

        Department d1 = new Department("SEO", "The best dep",e1);

        e1.Add_to_Department(d1);

    }
}
