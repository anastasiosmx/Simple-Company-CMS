package utilities;
import java.io.*;
import java.util.ArrayList;

import company_objects.*;

public class File_utilities {

    public File_utilities(){}

    public ArrayList<Employee> readEmployeesFromDir(String path_to_dir){
        ArrayList<Employee> employees = new ArrayList<Employee>();

        StringManipulation man = new StringManipulation();
        Employee employee;

        try{
            File dir = new File(path_to_dir);
            if(dir.isDirectory()){
                String[] dir_contents = dir.list();

                for(int i = 0 ; i < dir_contents.length; i++){
                    String file_to_read = path_to_dir+"\\"+dir_contents[i];
                    FileReader f = new FileReader(file_to_read);

                    BufferedReader b = new BufferedReader(f);
                    String file_contents_tmp = "";
                    String file_contents = "";

                    while (file_contents_tmp != null){
                        file_contents_tmp = b.readLine();
                        file_contents += file_contents_tmp;
                    }
                    employee = man.EmployeeFromFileTokenized(file_contents);
                    employees.add(employee);
                    b.close();
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return employees;
    }

    public ArrayList<Department> readDepartmentsFromDir(String path_to_dir){
        ArrayList<Department> departments = new ArrayList<Department>();

        StringManipulation man = new StringManipulation();
        Department department;

        try{
            File dir = new File(path_to_dir);
            if(dir.isDirectory()){
                String[] dir_contents = dir.list();

                for(int i = 0 ; i < dir_contents.length; i++){
                    String file_to_read = path_to_dir+"\\"+dir_contents[i];
                    FileReader f = new FileReader(file_to_read);

                    BufferedReader b = new BufferedReader(f);
                    String file_contents_tmp = "";
                    String file_contents = "";

                    while (file_contents_tmp != null){
                        file_contents_tmp = b.readLine();
                        file_contents += file_contents_tmp;
                    }
                    department = man.DepartmentFromFileTokenized(file_contents);
                    departments.add(department);
                    b.close();
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return departments;
    }

    public ArrayList<Project> readProjectsFromDir(String path_to_dir){
        ArrayList<Project> projects = new ArrayList<Project>();

        StringManipulation man = new StringManipulation();
        Project project;

        try{
            File dir = new File(path_to_dir);
            if(dir.isDirectory()){
                String[] dir_contents = dir.list();

                for(int i = 0 ; i < dir_contents.length; i++){
                    String file_to_read = path_to_dir+"\\"+dir_contents[i];
                    FileReader f = new FileReader(file_to_read);

                    BufferedReader b = new BufferedReader(f);
                    String file_contents_tmp = "";
                    String file_contents = "";

                    while (file_contents_tmp != null){
                        file_contents_tmp = b.readLine();
                        file_contents += file_contents_tmp;
                    }
                    project = man.ProjectFromFileTokenized(file_contents);
                    projects.add(project);
                    b.close();
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return projects;
    }

    public void setProjectsToEmployees(String path_to_dir, ArrayList<Employee> employees, ArrayList<Project> projects){
        StringManipulation man = new StringManipulation();

        try{
            File dir = new File(path_to_dir);
            if(dir.isDirectory()){
                String[] dir_contents = dir.list();

                for(int i = 0 ; i < dir_contents.length; i++){
                    String file_to_read = path_to_dir+"\\"+dir_contents[i];
                    FileReader f = new FileReader(file_to_read);

                    BufferedReader b = new BufferedReader(f);
                    String file_contents_tmp = "";
                    String file_contents = "";

                    while (file_contents_tmp != null){
                        file_contents_tmp = b.readLine();
                        file_contents += file_contents_tmp;
                    }
                    man.getProjectsfromEmployees(file_contents, employees, projects);
                    b.close();
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void setDepartmentsToEmployees(String path_to_dir, ArrayList<Employee> employees, ArrayList<Department> departments){
        StringManipulation man = new StringManipulation();

        try{
            File dir = new File(path_to_dir);
            if(dir.isDirectory()){
                String[] dir_contents = dir.list();

                for(int i = 0 ; i < dir_contents.length; i++){
                    String file_to_read = path_to_dir+"\\"+dir_contents[i];
                    FileReader f = new FileReader(file_to_read);

                    BufferedReader b = new BufferedReader(f);
                    String file_contents_tmp = "";
                    String file_contents = "";

                    while (file_contents_tmp != null){
                        file_contents_tmp = b.readLine();
                        file_contents += file_contents_tmp;
                    }
                    man.getDepartmentsToEmployees(file_contents, employees, departments);
                    b.close();
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
