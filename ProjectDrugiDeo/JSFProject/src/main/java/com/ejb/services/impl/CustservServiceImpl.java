package com.ejb.services.impl;
import com.jpa.entities.*;
import com.ejb.services.CustservService;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CustservServiceImpl implements CustservService {
	@PersistenceContext(name = "JSFProject")
	private EntityManager em;
	
//	public CustomerServiceImpl() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AutoServisPU");
//		em = emf.createEntityManager();
//	}
	
	@Override
	public Custserv getCustserv(int id) {
		Custserv s = em.find(Custserv.class, id);
		return s;
	}
	
	@Override
	public void addCustserv(Custserv obj) {
//		em.getTransaction().begin();
		em.persist(obj);
//		em.getTransaction().commit();		
	}

	@Override
	public void deleteCustserv(int id) {
		Custserv s = em.find(Custserv.class, id);
//		em.getTransaction().begin();
		em.remove(s);
//		em.getTransaction().commit();		
	}

	@Override
	public void updateCustserv(int id, int fkcustomer, int fkservice, String fixed, int fullprice, String paid) {
		Custserv s = em.find(Custserv.class, id);
//		em.getTransaction().begin();
		s.setFkcustomer(fkcustomer);
		s.setFkservice(fkservice);
		s.setFixed(fixed);
		s.setFullprice(fullprice);
		s.setPaid(paid);
//		em.getTransaction().commit();		
	}

	@Override
	public List<Custserv> listOfCustserves() {
		List<Custserv> custserves = em.createQuery("SELECT s FROM Custserv s", Custserv.class).getResultList();
		return custserves;
	}
	
	@Override
	public void isFixed(int id) {
		Custserv s = em.find(Custserv.class, id);
		if (s.getFixed().toLowerCase().equals("no")) {			
			Servis objS = em.find(Servis.class, s.getFkservice());
			
			final String USER_AGENT = "Mozilla/5.0";
			try {
			URL obj = new URL("http://localhost:8081/Money/"+ objS.getPrice() +"/"+ objS.getParts());
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);
			int responseCode = con.getResponseCode();
			System.out.println("GET Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
	
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				s.setFullprice(Integer.parseInt(response.toString()));
				s.setFixed("YES");
				s.setPaid("PAY");
			} else {
				System.out.println("Couldn't connect");
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			s.setFixed("NO");
			s.setFullprice(0);
			s.setPaid("WAIT");
		}
	}
	
	@Override
	public void isPaid(int id) {
		Custserv s = em.find(Custserv.class, id);
		if(s.getPaid().equals("PAY")) {
			s.setPaid("PAID");
		} else if(s.getPaid().equals("WAIT"))
			s.setPaid("WAIT");
		else 
			s.setPaid("PAY");			
	}
}
