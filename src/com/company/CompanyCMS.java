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
import javax.swing.JTable;


public class CompanyCMS extends JFrame implements ActionListener{
    //SHMEIWSH: Ta grafika doulevun opws kai oi sunartiseis mesa stin ActionPerformed apla dimiourgite problima me to borderLayout kai de fainonte, deite parakatw shmeiwsh gia lusi
    String employee_Name = "", birth_Date = "", startWorking_Date = "", is_Married = "", numOf_Kids = "", specialityName = "", education_lvl = "";
    String department_Name = "", department_descr = "";
    String project_Name = "", project_description = "", gross_revenue = "", general_expenses = "", operational_expenses = "";
    String employee_name_search = "";

    static ArrayList<Employee> employees;       //apothikeusi olwn twn employees se mia lista
    static ArrayList<Department> departments;   //apothikeusi olwn twn departments se mia lista
    static ArrayList<Project> all_projects;     //apothikeusi olwn twn projects se mia lista

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
        createProjects.setLayout(new FlowLayout());
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

        createEmployees.add(createEmployee);
        createEmployees.add(employeeName);
        createEmployees.add(birthDate);
        createEmployees.add(startWorkingDate);
        createEmployees.add(isMarried);
        createEmployees.add(numOfKids);
        createEmployees.add(speciality);
        createEmployees.add(educationLevel);
        createEmployees.add(educationInfo);
        createEmployees.add(saveEmployee);


        createDepartments.add(createDepartment);
        createDepartments.add(createProject);
        createDepartments.add(showEmployees);
        createDepartments.add(showDepartments);
        createDepartments.add(showProjects);
        createDepartments.add(info);

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

        setLayout(new BorderLayout());
        add(menu,BorderLayout.NORTH);
        add(centerDiv, BorderLayout.SOUTH);
        add(createEmployees, BorderLayout.CENTER);
        add(createDepartments, BorderLayout.CENTER);
        add(createProjects, BorderLayout.CENTER);
        add(showOneEmployees, BorderLayout.CENTER);
        //PROSOXI: O logos gia ton opoion den ektupwnete se kathe parathyro ta epimerus panels einai epeidi mporw na exw mono ena apo auta sto CENTER kai oxi olla mazi. [Den prolaba na brw lush gia auto]
        //pithanon me ti xriis borderlayout mesa se broder layout
        //ean thelete na to dokimasete kathe ena panel xexwrista (epeidi doulevun) apla kratiste mono ena  sto CENTER kai kante ta ypoloipa comment (proosxi thelei kai parakatyw comment)
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
            //parsarisma twn epimerus metablitwn apo ta textareas kai anathesi tous se metablites pou tha perasw argotera stis methodous dimiourgous (omoia sta ypoloipa)
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
                JOptionPane.showMessageDialog(null,"Employee saved successfully", "Info", JOptionPane.INFORMATION_MESSAGE); //parathyro eidopoiisi
                createEmployees.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Employee didn't saved [Try Again]","Warning", JOptionPane.WARNING_MESSAGE); //parathyro eidopoiisi
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

            //anazitw to index tu upalilou gia ton opoio zitaw plirofoires emsa sti kedriki lista me toyus employees moy
            for(int i = 0 ; i< employees.size() ; i++){
                if(Objects.equals(employee_name_search, employees.get(i).getName())){
                    employee_index = i;
                }
            }

            //body tou table 1
            String[][] info1 = {
                    {employees.get(employee_index).getName(),employees.get(employee_index).getBirthDate().getDay()+"/"+employees.get(employee_index).getBirthDate().getMonth()+"/"+employees.get(employee_index).getBirthDate().getYear()
                    ,employees.get(employee_index).getStart_work().getDay()+"/"+employees.get(employee_index).getStart_work().getMonth()+"/"+employees.get(employee_index).getStart_work().getYear()
                    ,String.valueOf(employees.get(employee_index).getMarriedState()), String.valueOf(employees.get(employee_index).getNum_of_kids()), employees.get(employee_index).getEducation_name()}
            };

            //body tou table 2
            String[][] info2 = {
                    {employees.get(employee_index).getDepartment().getDepartment_name(), String.valueOf(employees.get(employee_index).getManagerState()), String.valueOf(employees.get(employee_index).getSalary())}
            };

            //header table1
            String[] header1 = {"Full Name", "Birth Date", "Started Working Date", "Married" , "Number of Kids", "Education Level"};
            //header table2
            String[] header2 = {"Department", "Manager state", "Total Salary"};

            JTable employeeTable1 = new JTable(info1,header1);
            JTable employeeTable2 = new JTable(info2,header2);
            pack();
            showOneEmployees.add(new JScrollPane(employeeTable1));
            showOneEmployees.add(new JScrollPane(employeeTable2));

            newsearch.setVisible(true); //twra emfanizw to koumpi neo search gia na anewsw ta pedia
            employee_name.setVisible(false);
            applyEmployee.setVisible(false);
        }else if(e.getSource() == newsearch){
            //kanw removeall gia na kanw clear ta PANELS alla epeii auto tha mu diagrapsei kai ta components tu panel ta xanadimiourgw (kanw xana add)
            showOneEmployees.setVisible(false);

            showOneEmployees.removeAll();

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
        //Prwta diabazw xexwrista olous tous employees, ta dep kai t aprojects kai emta anthetw se ayta tis epimerus leptomeries opws poioi employees einai se poia projects klp
        File_utilities f = new File_utilities();
        employees = f.readEmployeesFromDir("C:\\Users\\Anastasios\\Desktop\\Company_Cms\\DB\\Employees");
        departments = f.readDepartmentsFromDir("C:\\Users\\Anastasios\\Desktop\\Company_Cms\\DB\\Departments");
        all_projects = f.readProjectsFromDir("C:\\Users\\Anastasios\\Desktop\\Company_Cms\\DB\\Projects");

        //edw ousiastika sumplirwnw tis extra plirofories
        f.setProjectsToEmployees("C:\\Users\\Anastasios\\Desktop\\Company_Cms\\DB\\Employees", employees, all_projects);
        f.setDepartmentsToEmployees("C:\\Users\\Anastasios\\Desktop\\Company_Cms\\DB\\Departments", employees, departments);

        CompanyCMS m = new CompanyCMS();
        m.setVisible(true);


        //SHMEIWSH: den prolaba na kanw to write se arxeia alla den einai kati parapanw apo mia bufferwriter mesw miaw system.out.println me anakteythinsi exodou se arxeio.
    }


}
