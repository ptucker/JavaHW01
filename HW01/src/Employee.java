
public class Employee {
	private int ID;
	private String name;
	private String hireDate;
	private String currentPosition;
	private String supervisor;
	
	public Employee () {
		ID = 0;
		name = "John Smith";
		hireDate = "January 1 2000";
		currentPosition = "Intern";
		supervisor = "Joe";
	}
	
	public Employee(int id, String Name, String HireDate,String CurrentPosition, String Supervisor) {
		ID = id;
		name = Name;
		hireDate = HireDate;
		currentPosition = CurrentPosition;
		supervisor = Supervisor;
	}
	
	public int getID() {
		return ID;
	};
	public String getName() {
		return name;
	};
	public String getHireDate() {
		return hireDate;
	};
	public String getCurrentPosition() {
		return currentPosition;
	};
	public String getSupervisor() {
		return supervisor;
	};

	public void setID(int id) {
		ID = id;
	};
	public void setName(String Name) {
		name = Name;
	};
	public void setHireDate(String HD) {
		hireDate = HD;
	};
	public void setCurrentPosition(String CurrentPosition) {
		currentPosition = CurrentPosition;
	};
	public void setSupervisor(String Super) {
		supervisor = Super;
	};

	//PT -- consider overloading toString()
}
