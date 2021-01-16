package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import company_objects.Employee;
import company_objects.Department;
import company_objects.Project;
import utilities.File_utilities;
import java.util.ArrayList;
import java.util.concurrent.Flow;


public class CompanyCMS extends JFrame implements ActionListener{
    String employee_Name = "", birth_Date = "", startWorking_Date = "", is_Married = "", numOf_Kids = "", specialityName = "", education_lvl = "";

    static ArrayList<Employee> employees;
    static ArrayList<Department> departments;
    static ArrayList<Project> all_projects;

    JButton createEmployee      = new JButton("Create a new Employee");
    JButton createDepartment    = new JButton("Create a new Department");
    JButton createProject       = new JButton("Create a new Project");
    JButton showEmployees       = new JButton("See all Employees");
    JButton showDepartments     = new JButton("See all Departments");
    JButton showProjects        = new JButton("See all Projects");
    JButton saveEmployee        = new JButton("Save");


    JTextArea info              = new JTextArea("Company CMS is a program that helps you organize, create and watch all employees, departments and projects of this company. (C) Dimitris Mantis");
    JTextArea employeeName     = new JTextArea("Employee name");
    JTextArea birthDate        = new JTextArea("Date of Birth");
    JTextArea startWorkingDate = new JTextArea("Start working fate");
    JTextArea isMarried        = new JTextArea("Married status (y/n)");
    JTextArea numOfKids        = new JTextArea("Number of kids");
    JTextArea speciality       = new JTextArea("Speciality");
    JTextArea educationLevel   = new JTextArea("EducationLevel [See Info Bellow]");
    JTextArea educationInfo    = new JTextArea("1 --> High School\n2 --> University\n3 --> Postgraduate\n4 --> Doctorate");

    JPanel menu             = new JPanel();
    JPanel centerDiv        = new JPanel();
    JPanel createEmployees  = new JPanel();

    public CompanyCMS(){
        super("Company CMS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,400);

        menu.setLayout(new FlowLayout());
        centerDiv.setLayout(new FlowLayout());
        createEmployees.setLayout(new FlowLayout());

        createEmployee.addActionListener(this);
        createDepartment.addActionListener(this);
        createProject.addActionListener(this);
        showEmployees.addActionListener(this);
        showDepartments.addActionListener(this);
        showProjects.addActionListener(this);
        saveEmployee.addActionListener(this);

        menu.add(createEmployee);
        menu.add(createDepartment);
        menu.add(createProject);
        menu.add(showEmployees);
        menu.add(showDepartments);
        menu.add(showProjects);
        menu.add(info);

        centerDiv.add(info);

        createEmployees.add(employeeName);
        createEmployees.add(birthDate);
        createEmployees.add(startWorkingDate);
        createEmployees.add(isMarried);
        createEmployees.add(numOfKids);
        createEmployees.add(speciality);
        createEmployees.add(educationLevel);
        createEmployees.add(educationInfo);
        createEmployees.add(saveEmployee);

        createEmployees.setVisible(false);

        setLayout(new BorderLayout());
        add(menu,BorderLayout.NORTH);
        add(centerDiv, BorderLayout.SOUTH);
        add(createEmployees, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == createEmployee){
            createEmployees.setVisible(true);
        }else if(e.getSource() == createDepartment){

        }else if(e.getSource() == createProject){

        }else if(e.getSource() == showEmployees){

        }else if(e.getSource() == showDepartments){

        }else if(e.getSource() == showProjects){

        }else if(e.getSource() == saveEmployee){
            employee_Name       = employeeName.getText();
            birth_Date          = birthDate.getText();
            startWorking_Date   = startWorkingDate.getText();
            is_Married          = isMarried.getText();
            numOf_Kids          = numOfKids.getText();
            specialityName      = speciality.getText();
            education_lvl       = speciality.getText();

            int numOFKIDSint    = Integer.parseInt(numOf_Kids.trim());
            int edLevelint      = Integer.parseInt(education_lvl.trim());
            if(employees.add(new Employee(employee_Name, birth_Date, startWorking_Date, is_Married, numOFKIDSint , specialityName, edLevelint))){
                JOptionPane.showMessageDialog(null,"Employee saved successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Employee didn't saved","Warning", JOptionPane.WARNING_MESSAGE);
            }

        }else{
            JOptionPane.showMessageDialog(null,"ERROR", "Warning" ,JOptionPane.WARNING_MESSAGE);
        }
    }


    public static void main(String[] args) {


        File_utilities f = new File_utilities();
        employees = f.readEmployeesFromDir("C:\\Users\\Anastasios\\Desktop\\Company_Cms\\DB\\Employees");
        departments = f.readDepartmentsFromDir("C:\\Users\\Anastasios\\Desktop\\Company_Cms\\DB\\Departments");
        all_projects = f.readProjectsFromDir("C:\\Users\\Anastasios\\Desktop\\Company_Cms\\DB\\Projects");

        f.setProjectsToEmployees("C:\\Users\\Anastasios\\Desktop\\Company_Cms\\DB\\Employees", employees, all_projects);
        f.setDepartmentsToEmployees("C:\\Users\\Anastasios\\Desktop\\Company_Cms\\DB\\Departments", employees, departments);

        CompanyCMS m = new CompanyCMS();
        m.setVisible(true);

        //Project proj1 = new Project();

        //MoneyUtilities m1 = new MoneyUtilities();
        //EmployeeManipulation man = new EmployeeManipulation();
//
        //Employee e1 = new Employee("Anastasios", "10/05/1997", "20/02/2020", "Y", 2, "Software Engineer", 3);
        //Employee e2 = new Employee("Mitsos", "10/05/1995", "10/02/2020", "Y", 1, "FrontEnd Developer", 1);
//
        //Department d1 = new Department("Software Analysis", "The best dep");
        //Department d2 = new Department("Social Media", "The best dep");
//
        //man.MoveEmployee(e1,d1, "Y", "10/10/2020");
        //man.MoveEmployee(e2,d2,"Y",  "5/10/2020");
        //man.MoveEmployee(e1,d2, "n", "10/10/2020");
//
        //Project Acropolis = new Project("Acropolis", "Acropolis maintenance", "256788", "100000", "20000");
        ////all_projects.add(Acropolis);
        //Acropolis.setEmployeeToProject(e1,"10/05/2020","20/07/2020");
        //Acropolis.setEmployeeToProject(e2,"10/05/2020","20/08/2020");
//
        //Project SNF = new Project("Stavros Niarxos Foundation", "Construction of SNF building", "400000", "5000", "10000");
        ////all_projects.add(SNF);
//
        //e1.setProjectToEmployee(Acropolis);
        //e2.setProjectToEmployee(Acropolis);

        //System.out.println(d2.getDepartment_name()+" total employees salary = "+m1.TotalDepartmentsEmployeesSalary(d2));
        //System.out.println("Total employees salary for the project "+Acropolis.getProject_name()+" is "+Acropolis.getTotalProjectsEmployeesSalary());
        //System.out.println("Total income for a project = "+m1.trueProjectIncome(Acropolis));

       // proj1 = m1.bestProject(all_projects);
        //System.out.println("The best project, based on the total income is "+proj1.getProject_name());


    }


}
