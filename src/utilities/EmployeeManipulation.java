package utilities;
import company_objects.Department;
import company_objects.Employee;


public class EmployeeManipulation {
    public void MoveEmployee(Employee employee, Department department){employee.set_Department(department);}

    public String toDateString(Date other){
        String date = other.getDay()+"/"+ other.getMonth()+"/"+ other.getYear();
        return date;
    }

    public String toDateStringReversed(Date other){
        String date;
        if((other.getMonth() < 10) && (other.getDay() < 10)){
            date = other.getYear()+"-0"+other.getMonth()+"-0"+other.getDay();
        }else if((other.getMonth() < 10) && (other.getDay() > 9)){
            date = other.getYear()+"-0"+other.getMonth()+"-"+other.getDay();
        }else if((other.getMonth() > 9) && (other.getDay() < 10)){
            date = other.getYear()+"-"+other.getMonth()+"-0"+other.getDay();
        }else{
            date = other.getYear()+"-"+other.getMonth()+"-"+other.getDay();
        }

        return date;
    }
}
