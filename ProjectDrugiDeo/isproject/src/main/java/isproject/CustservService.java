package isproject;
import java.util.List;

public interface CustservService {
	public Custserv getCustserv(int id);
	public void addCustserv(Custserv obj);
	public void deleteCustserv(int id);
	public void updateCustserv(int id, int fkcustomer, int fkservice, String fixed, int fullprice, String paid);
	public List<Custserv> ListOfCustserves();
}
