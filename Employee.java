import java.util.Random;

public class Employee {
	private int ID;
	private float Salary;
	private Dep Department;
	private enum Dep {IT, HR, Accounting, Manufacturing, Sales, Maintenance};
	
	//every new employee has next id number
	public static int idcount = 1;
	
	//constructor
	public Employee(){
		ID = idcount;
		idcount++;
		//random salary with two decimal numbers
		Salary = (float) Math.round(Math.random()*10000 * 100) / 100;
		//random department
		Department = Dep.values()[new Random().nextInt(Dep.values().length)];
	}
	@Override
	public String toString() {
		return "Employee [ID=" + ID + ", Salary=" + Salary + ", Department="
				+ Department + "]";
	}
	//obtain name of the Department
	public String getdepartment(){
		return Department.name();
	}
	
}
