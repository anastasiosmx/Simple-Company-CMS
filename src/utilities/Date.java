package utilities;
import java.util.Calendar;

public class Date {
    private int day = 1, month = 1, year = 2021;

    public Date(int day, int month, int year){
        setDate(day, month, year);
    }

    public void setDay(int day){
        if(day >= 0 && day <= 31){
            this.day = day;
        }
    }

    public void setMonth(int month){
        if(month >= 0 && month <= 12){
            this.month = month;
        }
    }

    public void setYear(int year){
        int system_year = Calendar.getInstance().get(Calendar.YEAR);
        if(year >= 0 && year <= system_year) {
            this.year = year;
        }
    }

    public void setDate(int day, int month, int year){
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public int getDay(){return day;}

    public int getMonth(){return month;}

    public int getYear(){return year;}
}
