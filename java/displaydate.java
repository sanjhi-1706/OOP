package Hello;


import java.util.Scanner;
class Date {

	int month=12;
    int day=00;
    int year=2004;
    
    public Date() {
       
    }

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void displayDate() {
        System.out.printf("%02d/%02d/%d", month, day, year);
    }
}


public class displaydate {
    public static void main(String[] args) {
        Date date1 = new Date(06, 17, 2004);
        System.out.println("The date is:");
        date1.displayDate();

        date1.setMonth(03);
        date1.setDay(27);
        date1.setYear(2001);

        System.out.println("The updated date is:");
        date1.displayDate();
    }
}


