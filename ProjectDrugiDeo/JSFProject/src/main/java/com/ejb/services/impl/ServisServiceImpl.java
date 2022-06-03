package com.ejb.services.impl;
import com.jpa.entities.*;
import com.ejb.services.ServisService;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ServisServiceImpl implements ServisService {
	@PersistenceContext(name = "JSFProject")
	private EntityManager em;
	
//	public CustomerServiceImpl() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AutoServisPU");
//		em = emf.createEntityManager();
//	}
	
	@Override
	public Servis getServis(int id) {
		Servis s = em.find(Servis.class, id);
		return s;
	}

	@Override
	public void addServis(Servis obj) {
//		em.getTransaction().begin();
		em.persist(obj);
//		em.getTransaction().commit();		
	}

	@Override
	public void deleteServis(int id) {
		Servis s = em.find(Servis.class, id);
//		em.getTransaction().begin();
		em.remove(s);
//		em.getTransaction().commit();		
	}

	@Override
	public void updateServis(int id, String name, int price, int parts) {
		Servis s = em.find(Servis.class, id);
//		em.getTransaction().begin();
		s.setName(name);
		s.setPrice(price);
		s.setParts(parts);
//		em.getTransaction().commit();		
	}

	@Override
	public List<Servis> listOfServises() {
		List<Servis> servises = em.createQuery("SELECT s FROM Servis s", Servis.class).getResultList();
		return servises;
	}

}
