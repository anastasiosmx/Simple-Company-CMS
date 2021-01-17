package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import company_objects.Employee;
import company_objects.Department;
import company_objects.Project;
import utilities.File_utilities;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class CompanyCMS extends JFrame implements ActionListener{
    String employee_Name = "", birth_Date = "", startWorking_Date = "", is_Married = "", numOf_Kids = "", specialityName = "", education_lvl = "";
    String department_Name = "", department_descr = "";
    String project_Name = "", project_description = "", gross_revenue = "", general_expenses = "", operational_expenses = "";
    String employee_name_search = "";

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
    JButton saveDepartment      = new JButton("Save");
    JButton saveProject         = new JButton("Save");
    JButton applyEmployee       = new JButton("Apply");
    JButton newsearch           = new JButton("New search");

    JTextArea info              = new JTextArea("Company CMS is a program that helps you organize, create and watch all employees, departments and projects of this company. (C) Dimitris Mantis");
    JTextArea employeeName      = new JTextArea("Employee name");
    JTextArea birthDate         = new JTextArea("Date of Birth");
    JTextArea startWorkingDate  = new JTextArea("Start working fate");
    JTextArea isMarried         = new JTextArea("Married status (y/n)");
    JTextArea numOfKids         = new JTextArea("Number of kids");
    JTextArea speciality        = new JTextArea("Speciality");
    JTextArea educationLevel    = new JTextArea("EducationLevel [See Info Bellow]");
    JTextArea educationInfo     = new JTextArea("1 --> High School\n2 --> University\n3 --> Postgraduate\n4 --> Doctorate");
    JTextArea department_name   = new JTextArea("Department name");
    JTextArea department_description = new JTextArea("Description");
    JTextArea project_name      = new JTextArea("Project name");
    JTextArea project_desc      = new JTextArea("Description");
    JTextArea gross_rev         = new JTextArea("Gross Revenue (amount)");
    JTextArea gen_exp           = new JTextArea("General Expenses (amount)");
    JTextArea op_exp            = new JTextArea("Operational Expenses (amount)");
    JTextArea employee_name     = new JTextArea("Employee Name");

    JPanel menu                 = new JPanel();
    JPanel centerDiv            = new JPanel();
    JPanel createEmployees      = new JPanel();
    JPanel createDepartments    = new JPanel();
    JPanel createProjects       = new JPanel();
    JPanel showOneEmployees     = new JPanel();

    public CompanyCMS(){
        super("Company CMS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,200);

        menu.setLayout(new FlowLayout());
        centerDiv.setLayout(new FlowLayout());
        createEmployees.setLayout(new FlowLayout());
        createDepartments.setLayout(new FlowLayout());
        showOneEmployees.setLayout(new FlowLayout());

        createEmployee.addActionListener(this);
        createDepartment.addActionListener(this);
        createProject.addActionListener(this);
        showEmployees.addActionListener(this);
        showDepartments.addActionListener(this);
        showProjects.addActionListener(this);
        saveEmployee.addActionListener(this);
        saveDepartment.addActionListener(this);
        saveProject.addActionListener(this);
        applyEmployee.addActionListener(this);
        newsearch.addActionListener(this);

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

        createDepartments.add(department_name);
        createDepartments.add(department_description);
        createDepartments.add(saveDepartment);

        createProjects.add(project_name);
        createProjects.add(project_desc);
        createProjects.add(gross_rev);
        createProjects.add(gen_exp);
        createProjects.add(op_exp);
        createProjects.add(saveProject);

        showOneEmployees.add(employee_name);
        showOneEmployees.add(applyEmployee);
        showOneEmployees.add(newsearch);

        createEmployees.setVisible(false);
        createDepartments.setVisible(false);
        createProjects.setVisible(false);
        showOneEmployees.setVisible(false);

        setLayout(new BorderLayout());
        add(menu,BorderLayout.NORTH);
        add(centerDiv, BorderLayout.SOUTH);
        add(createEmployees, BorderLayout.CENTER);
        add(createDepartments, BorderLayout.CENTER);
        add(createProjects, BorderLayout.CENTER);
        add(showOneEmployees, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == createEmployee){
            createEmployees.setVisible(true);
        }else if(e.getSource() == createDepartment){
            createDepartments.setVisible(true);
        }else if(e.getSource() == createProject){
            createProjects.setVisible(true);
        }else if(e.getSource() == showEmployees){
            newsearch.setVisible(false);
            showOneEmployees.setVisible(true);
        }else if(e.getSource() == showDepartments){


        }else if(e.getSource() == showProjects){


        }else if(e.getSource() == saveEmployee){
            employee_Name       = employeeName.getText();
            birth_Date          = birthDate.getText();
            startWorking_Date   = startWorkingDate.getText();
            is_Married          = isMarried.getText();
            numOf_Kids          = numOfKids.getText();
            specialityName      = speciality.getText();
            education_lvl       = educationLevel.getText();

            int numOFKIDSint    = Integer.parseInt(numOf_Kids.trim());
            int edLevelint      = Integer.parseInt(education_lvl.trim());

            if(employees.add(new Employee(employee_Name, birth_Date, startWorking_Date, is_Married, numOFKIDSint , specialityName, edLevelint))){
                JOptionPane.showMessageDialog(null,"Employee saved successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
                createEmployees.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Employee didn't saved [Try Again]","Warning", JOptionPane.WARNING_MESSAGE);
            }
        }else if(e.getSource() == saveDepartment){
            department_Name     = department_name.getText();
            department_descr    = department_description.getText();

            if(departments.add(new Department(department_Name, department_descr))){
                JOptionPane.showMessageDialog(null,"Department saved successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
                createDepartments.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Department didn't saved [Try Again]","Warning", JOptionPane.WARNING_MESSAGE);
            }

        }else if(e.getSource() == saveProject){
            project_Name            = project_name.getText();
            project_description     = project_desc.getText();
            gross_revenue           = gross_rev.getText();
            general_expenses        = gen_exp.getText();
            operational_expenses    = op_exp.getText();

            if(all_projects.add(new Project(project_Name, project_description, gross_revenue, general_expenses, operational_expenses))){
                JOptionPane.showMessageDialog(null,"Project saved successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
                createProjects.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Project didn't saved [Try Again]","Warning", JOptionPane.WARNING_MESSAGE);
            }
        }else if(e.getSource() == applyEmployee){
            employee_name_search = employee_name.getText();
            int employee_index = 0;

            System.out.println(employees.size());

            for(int i = 0 ; i< employees.size() ; i++){
                if(Objects.equals(employee_name_search, employees.get(i).getName())){
                    employee_index = i;
                }
            }

            String[][] info1 = {
                    {employees.get(employee_index).getName(),employees.get(employee_index).getBirthDate().getDay()+"/"+employees.get(employee_index).getBirthDate().getMonth()+"/"+employees.get(employee_index).getBirthDate().getYear()
                    ,employees.get(employee_index).getStart_work().getDay()+"/"+employees.get(employee_index).getStart_work().getMonth()+"/"+employees.get(employee_index).getStart_work().getYear()
                    ,String.valueOf(employees.get(employee_index).getMarriedState()), String.valueOf(employees.get(employee_index).getNum_of_kids()), employees.get(employee_index).getEducation_name()}
            };

            String[][] info2 = {
                    {employees.get(employee_index).getDepartment().getDepartment_name(), String.valueOf(employees.get(employee_index).getManagerState()), String.valueOf(employees.get(employee_index).getSalary())}
            };

            String[] header1 = {"Full Name", "Birth Date", "Started Working Date", "Married" , "Number of Kids", "Education Level"};

            String[] header2 = {"Department", "Manager state", "Total Salary"};

            JTable employeeTable1 = new JTable(info1,header1);
            JTable employeeTable2 = new JTable(info2,header2);
            pack();
            showOneEmployees.add(new JScrollPane(employeeTable1));
            showOneEmployees.add(new JScrollPane(employeeTable2));

            newsearch.setVisible(true);
            employee_name.setVisible(false);
            applyEmployee.setVisible(false);
        }else if(e.getSource() == newsearch){
            showOneEmployees.setVisible(false);

            //showOneEmployees.removeAll();

            showOneEmployees.add(employee_name);
            showOneEmployees.add(applyEmployee);
            showOneEmployees.add(newsearch);

            showOneEmployees.setVisible(true);
            employee_name.setVisible(true);
            applyEmployee.setVisible(true);
            newsearch.setVisible(false);
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
