import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class labemployee {

	//main function
	public static void main(String[] args) {
		List<Employee> companyA = new ArrayList<Employee>();
		List<Employee> companyB = new ArrayList<Employee>();
		
		//fill two companies with employees
		for(int x = 0; x < 15; x++)
		{
			companyA.add(new Employee());
		}
		for(int x = 0; x < 15; x++)
		{
			companyB.add(new Employee());
		}
		
		//merge the companies and save in Merged
		List Merged = new merge().mer(companyA, companyB);
		
		//sort Merged using my comparator
		Collections.sort(Merged, new CustomComparator());
		System.out.println(Merged);
		
		//new manager
		Manager Boss = new Manager();
		int n = Merged.size();
		
		//find a place in Merged for Boss
		for(int x = 0; x < Merged.size(); x++){
			if(new CustomComparator().compare((Employee) Merged.get(x), Boss) == 1)
				n = x;
		}
		//print Boss
		System.out.println(Boss);
		
		//add Boss to Merged
		Merged.add(n, Boss);
		
		//print Merged (with Boss)
		System.out.println(Merged);
	}
	
}
