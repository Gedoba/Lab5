import java.util.*;
public class TestCar {

	public static void main(String[] args) throws Exception {
		ArrayList<Car> trainA = Car.readCars("D:\\Documents and Settings\\JavaProgramms\\Lab5\\bin\\trainA.txt");
		ArrayList<Car> trainB = Car.readCars("D:\\Documents and Settings\\JavaProgramms\\Lab5\\bin\\trainB.txt");		
		System.out.println(trainA);
		System.out.println(trainB);
		
		ArrayList<Car> trainC = new ArrayList<Car>();
		trainC.addAll(trainA);
		trainC.addAll(trainB);
		trainA.clear();
		trainB.clear();
		Car.writeCars(trainC, "D:\\Documents and Settings\\JavaProgramms\\Lab5\\bin\\trainC.txt"); //writes trainC to trainC.txt
			//System.out.println(trainC);
	}
}
