package com.ejb.services;
import java.util.List;
import com.jpa.entities.*;

public interface CustservService {
	public Custserv getCustserv(int id);
	public void addCustserv(Custserv obj);
	public void deleteCustserv(int id);
	public void updateCustserv(int id, int fkcustomer, int fkservice, String fixed, int fullprice, String paid);
	public List<Custserv> listOfCustserves();
	public void isFixed(int id);
	public void isPaid(int id);
}
