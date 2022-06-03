package isproject;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
@Remote(CustservService.class)
public class CustservServiceImpl implements CustservService {
	private EntityManager em;
	
	public CustservServiceImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AutoServisPU");
		em = emf.createEntityManager();
	}
	
	@Override
	public Custserv getCustserv(int id) {
		Custserv s = em.find(Custserv.class, id);
		return s;
	}
	
	@Override
	public void addCustserv(Custserv obj) {
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();		
	}

	@Override
	public void deleteCustserv(int id) {
		Custserv s = em.find(Custserv.class, id);
		em.getTransaction().begin();
		em.remove(s);
		em.getTransaction().commit();		
	}

	@Override
	public void updateCustserv(int id, int fkcustomer, int fkservice, String fixed, int fullprice, String paid) {
		Custserv s = em.find(Custserv.class, id);
		em.getTransaction().begin();
		s.setFKcustomer(fkcustomer);
		s.setFKservice(fkservice);
		s.setFixed(fixed);
		s.setFullPrice(fullprice);
		s.setPaid(paid);
		em.getTransaction().commit();		
	}

	@Override
	public List<Custserv> ListOfCustserves() {
		List<Custserv> custserves = em.createQuery("SELECT s FROM Custserv s", Custserv.class).getResultList();
		return custserves;
	}

}
