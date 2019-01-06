import java.util.*;


public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date() {
		day = 1;
		month = 1;
		year = 2000;
	}
	 public Date(int d, int m, int y) {
		 try {
			 if (getDaysInMonth(m) > d && d >0 && m >0 && m<= 12 && y >0) {
				 day = d;
				 month= m;
				 year = y;
			 }
			 else
				 throw new Exception ("Invalid date");
			 
		 }
		 catch (Exception except){
			 System.out.println(except);
		 }
		 
		
	 }
	 
	 public int getDaysInMonth(int m) {
		 if (m == 1||m == 3||m == 5||m == 7||m == 8 || m == 10|| m == 12)
			 return 31;
		 if (m == 4 || m == 6 ||m == 9||m == 11)
			 return 30;
		 if (m==2) //PT -- you need to know the year for this
			 return 28;
		 return 0;
	 }
	
	 public int getDay() {
		 return day;
	 }
	 public int getMonth() {
		 return month;
	 }
	 public int getYear() {
		 return year;
	 }
	//PT -- return your date object, not the system one. -1
	 public static java.util.Date getTodaysDate() {
		 java.util.Date date = java.util.Calendar.getInstance().getTime();
		 return date;
	 }
	 public int difference(Date d) {
		 //PT -- ??? -5
		 int days = Days.daysBetween(date1, date2).getDays();
		 return days;
	 }
	 
	 public void setDay(int d) {
		 day = d;
	 }
	 public void setMonth(int m) {
		 month = m;
	 }
	 public void setYear(int y) {
		 year = y;
	 }
	 
}
