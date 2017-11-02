
public class Manager extends Employee {
	private boolean bonus;
	//constructor
	public Manager() {
		double r  = Math.random();
		bonus = true;
		if(r > 0.5)
			bonus = false;
	}
}
