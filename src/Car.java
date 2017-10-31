import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

public class Car {
	
	public enum GoodKinds {
		coal, copper, tin, magnesium, uranium, iron, magnesite
	}
	private GoodKinds goodKinds;
	private double load;
	private int counterNum;
	public static int counter = 0; //additional field in order to count the cars
	public Car(GoodKinds k, double x) {
		counter++;
		this.goodKinds = k;
		this.load = x;
		counterNum = counter;
	}
	@Override
	public String toString() {
		Locale currentLocale = Locale.getDefault();
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(currentLocale);
		otherSymbols.setDecimalSeparator('.');
		String formatString = "0.00";
		DecimalFormat df = new DecimalFormat(formatString, otherSymbols);
		
		
		
		
		Double d = this.load;
	    String formatted = df.format(d); //formatted to display 2 digits after decimal point
		return "\nCar no." + counterNum + " has " + formatted + "kg of " + goodKinds;
	}
	public GoodKinds getGoodKinds() {
		return goodKinds;
	}
	public double getLoad() {
		return load;
	}
	
	public static ArrayList<Car> readCars(String filename) {
		ArrayList<Car> train = new ArrayList<Car>();
		try {
		     BufferedReader in = new BufferedReader(new FileReader(filename));
		     String str;
		     
		     while ((str = in.readLine()) != null) {
		    	String [] parts = str.split(",");
		    	double x = Double.parseDouble(parts[1]);	        	
		        Car a = new Car(Car.GoodKinds.valueOf(parts[0]), x);
		        train.add(a);
		     }
		     in.close();
		     
		  } catch (IOException e) {
		  	}
		return train;
		}
	public static void writeCars(ArrayList<Car> train, String filename) {
		//formating of strings printing
		Locale currentLocale = Locale.getDefault();
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(currentLocale);
		otherSymbols.setDecimalSeparator('.');
		String formatString = "0.00"; //can change it to "0.00000" in order not to lose digits after 2nd digit after decimal point
		DecimalFormat df = new DecimalFormat(formatString, otherSymbols);
		String[] parts = new String[2];
	try {
			
			BufferedWriter out = new BufferedWriter(new FileWriter(filename));
			for(int i=0; i<train.size(); i++) {
				parts [0] = train.get(i).getGoodKinds().name();
				Double d = (train.get(i).getLoad());
				parts[1] = df.format(d);
				out.write(parts[0] + "," + parts[1] + "\n");  //writes in appropriate format to trainC.txt
				}
		         out.close();
	      }
	      catch (IOException e) {
	         System.out.println("exception occoured"+ e);
	      }
	}
	
}
