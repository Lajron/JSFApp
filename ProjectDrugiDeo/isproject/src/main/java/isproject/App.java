package isproject;

import java.net.*;
import java.util.List;
import java.io.*;

import javax.persistence.*;

public class App {
//	private static EntityManager em;

	public static void main(String[] args) {
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AutoServisPU");
//		em = emf.createEntityManager();
		
//		Customer obj = new Customer("Milos", "dmilos@elfak.rs", "069420666", "Opel", "L33T");
//		CustomerServiceImpl m = new CustomerServiceImpl();
//		
//		m.updateCustomer(3, "Milos", "dmilos@elfak.rs", "069420666", "Opel", "L33T");
		
//		Custserv obj = new Custserv(3,1,"Yes", 32100, "No");		
//		
//		service.addCustserv(obj);
//		ServisServiceImpl service = new ServisServiceImpl();
//		Servis obj = service.getServis(2);
		
		CustomerServiceImpl m = new CustomerServiceImpl();
		List<Customer> arr = m.ListOfCustomers();
		
		for(Customer c : arr)
			System.out.println(c);
		
//		final String USER_AGENT = "Mozilla/5.0";
//		try {
//		URL obj = new URL("http://localhost:8081/Pay/500/100");
//		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//		con.setRequestMethod("GET");
//		con.setRequestProperty("User-Agent", USER_AGENT);
//		int responseCode = con.getResponseCode();
//		System.out.println("GET Response Code :: " + responseCode);
//		if (responseCode == HttpURLConnection.HTTP_OK) { // success
//			BufferedReader in = new BufferedReader(new InputStreamReader(
//					con.getInputStream()));
//			String inputLine;
//			StringBuffer response = new StringBuffer();
//
//			while ((inputLine = in.readLine()) != null) {
//				response.append(inputLine);
//			}
//			in.close();
//			System.out.println(response.toString());
//		} else {
//			System.out.println("Couldn't connect");
//		}
//		} catch (Exception eeeeeeeeeeeee) {
//			eeeeeeeeeeeee.printStackTrace();
//		}

		
		System.out.println("I am an APP");

	}

}
