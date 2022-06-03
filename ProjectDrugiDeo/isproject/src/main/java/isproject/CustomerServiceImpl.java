package isproject;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.Remote;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
@Remote(CustomerService.class)
public class CustomerServiceImpl implements CustomerService {
	private EntityManager em;
	
	public CustomerServiceImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AutoServisPU");
		em = emf.createEntityManager();
	}
	
	@Override
	public Customer getCustomer(int id) {
		Customer s = em.find(Customer.class, id);
		return s;
	}
	
	@Override
	public void addCustomer(Customer obj) {
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}
	
	@Override
	public void deleteCustomer(int ajd) {
		Customer c = em.find(Customer.class, ajd);
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
	}
	
	@Override
	public void updateCustomer(int id, String name, String email, String phone, String carmodel, String carplate) {
		Customer c = em.find(Customer.class, id);
		em.getTransaction().begin();
		c.setName(name);
		c.setEmail(email);
		c.setPhone(phone);
		c.setCarModel(carmodel);
		c.setCarPlate(carplate);
		em.getTransaction().commit();
	}
	
	@Override
	public List<Customer> ListOfCustomers() {
		List<Customer> customers = em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
		return customers;
	}
	
}
