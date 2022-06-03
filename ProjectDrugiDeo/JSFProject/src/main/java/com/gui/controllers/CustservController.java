package com.gui.controllers;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import com.ejb.services.*;
import com.jpa.entities.*;

@ManagedBean
public class CustservController {
	private String id;
	private String fkcustomer;
	private String fkservice;
	private String fixed;
	private String fullprice;
	private String paid;
	
	@EJB
	CustservService service;
	
	public String getId() { 
		return id;
	}
	
	public void setId(String id) { 
		this.id = id;
	}
	
	public String getFkcustomer() { 
		return fkcustomer;
	}
	
	public void setFkcustomer(String fkcustomer) { 
		this.fkcustomer = fkcustomer;
	}
	
	public String getFkservice() { 
		return fkservice;
	}
	
	public void setFkservice(String fkservice) { 
		this.fkservice = fkservice;
	}
	
	public String getFixed() { 
		return fixed;
	}
	
	public void setFixed(String fixed) { 
		this.fixed = fixed;
	}
	
	public String getFullprice() { 
		return fullprice;
	}
	
	public void setFullprice(String fullprice) { 
		this.fullprice = fullprice;
	}
	
	public String getPaid() { 
		return paid;
	}
	
	public void setPaid(String paid) { 
		this.paid = paid;
	}
	
	public Custserv getCustserv(String id) {
		return service.getCustserv(Integer.parseInt(id));
	}
	
	public void addCustserv(String fkcustomer, String fkservice, String fixed, String fullprice, String paid) {
		Custserv obj = new Custserv(Integer.parseInt(fkcustomer), Integer.parseInt(fkservice), fixed, Integer.parseInt(fullprice), paid);
		service.addCustserv(obj);
	}
	
	public void updateCustserv(String id, String fkcustomer, String fkservice, String fixed, String fullprice, String paid) {
		service.updateCustserv(Integer.parseInt(id), Integer.parseInt(fkcustomer), Integer.parseInt(fkservice), fixed, Integer.parseInt(fullprice), paid);
	}
	
	public void deleteCustserv(String id) {
		service.deleteCustserv(Integer.parseInt(id));
	}
	
//	public void clickCustserv(String id) {
//		Custserv c = service.getCustserv(Integer.parseInt(id));
//		this.ID = String.valueOf(c.getID());
//		this.FKcustomer = String.valueOf(c.getFKcustomer());
//		this.FKservice = String.valueOf(c.getFKservice());
//		this.Fixed = c.getFixed();
//		this.FullPrice = String.valueOf(c.getFullPrice());
//		this.Paid = c.getPaid();
//	}
	
	public List<Custserv> listOfCustserves() {
		List<Custserv> arr = service.listOfCustserves();
		return arr;
	}
	
	public void isFixed(int id) {
		service.isFixed(id);
	}
	
	public void isPaid(int id) {
		service.isPaid(id);
	}	
}
