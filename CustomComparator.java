import java.util.Comparator;

//my costom comparator
public class CustomComparator implements Comparator<Employee> {
	public int compare(Employee a, Employee b){
        int n = a.getdepartment().compareTo(b.getdepartment());
        if(n<0)
        	return -1;
        if(n>0)
        	return 1;
        return n;
	}
}
