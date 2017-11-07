package lab6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class user {
	
	private long id;
	private String name;
	private String username;
	private String email;
	class address{
		//public String street;

		private class geo{

		};
	};
	private String street;
	private String suite;
	private String city;
	private String zipcode;
	
	private String lat;
	private String lng;
	
	private String phone;
	private String website;
	private class company{

	};
	private String cname; //company name
	private String catchPhrase;
	private String bs;

	public static void main(String[] args) {

		JSONParser jsonParser = new JSONParser();
		Object object;
		
		ArrayList<user> users = new ArrayList<user>();
		
		for(int i=0; i<10; i++) {
			user a = new user();
			users.add(a);
		}
		
		try {

			object = jsonParser.parse(new FileReader("users.json"));
			
			JSONArray jsonArray = (JSONArray) object;
			
			int x = 0; //index of arraylist users
			Iterator iterator = jsonArray.iterator();
			
			    while (iterator.hasNext()) {
			    	JSONObject innerObj = (JSONObject) iterator.next();
			    	users.get(x).id = (long) innerObj.get("id");
			    	users.get(x).name = (String) innerObj.get("name");
			    	users.get(x).username = (String) innerObj.get("username");
			    	users.get(x).email = (String) innerObj.get("email");
			    	JSONObject address = (JSONObject) innerObj.get("address");
			    		users.get(x).street = (String) address.get("street"); //how to make it work with classes
			    		users.get(x).suite = (String) address.get("suite");
			    		users.get(x).city = (String) address.get("city");
			    		users.get(x).zipcode = (String) address.get("zipcode");
			    		JSONObject geo = (JSONObject) address.get("geo"); //inner inner
			    			users.get(x).lat = (String) geo.get("lat");
			    			users.get(x).lng = (String) geo.get("lng");
			    	users.get(x).phone = (String) innerObj.get("phone");
			    	users.get(x).website = (String) innerObj.get("website");
			    	JSONObject company = (JSONObject) innerObj.get("company");
			    		users.get(x).cname = (String) company.get("name");
			    		users.get(x).catchPhrase = (String) company.get("catchPhrase");
			    		users.get(x).bs = (String) company.get("bs");
					
			    System.out.println(users.get(x));
			    		
			    		
			    	//System.out.print(users.get(x).id + " ");
			    	//System.out.print(users.get(x).name + " ");
			    	//System.out.println("Address: Street: " + address.get("street"));
			    	
			    	
			    	
			    	
			        //System.out.println(iterator.next());
			    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", street="
				+ street + ", suite=" + suite + ", city=" + city + ", zipcode=" + zipcode + ", lat=" + lat + ", lng="
				+ lng + ", phone=" + phone + ", website=" + website + ", cname=" + cname + ", catchPhrase="
				+ catchPhrase + ", bs=" + bs + "]";
	}
}