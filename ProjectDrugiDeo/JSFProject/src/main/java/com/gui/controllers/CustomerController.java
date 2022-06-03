package com.gui.controllers;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import com.ejb.services.*;
import com.jpa.entities.*;

@ManagedBean
public class CustomerController {
	
	private String id;
	private String name;
	private String email;
	private String phone;
	private String carmodel;
	private String carplate;
	
	@EJB
	private CustomerService service;
	
	public String getId() { 
		return id;
	}
	
	public void setId(String id) { 
		this.id = id;
	}
	
	public String getName() { 
		return name;
	}
	
	public void setName(String name) { 
		this.name = name;
	}
	
	public String getEmail() { 
		return email;
	}
	
	public void setEmail(String email) { 
		this.email = email;
	}
	
	public String getPhone() { 
		return phone;
	}
	
	public void setPhone(String phone) { 
		this.phone = phone;
	}
	
	public String getCarmodel() { 
		return carmodel;
	}
	
	public void setCarmodel(String carmodel) { 
		this.carmodel = carmodel;
	}
	
	public String getCarplate() { 
		return carplate;
	}
	
	public void setCarplate(String carplate) { 
		this.carplate = carplate;
	}
	
	public Customer getCustomer(String id) {
		return service.getCustomer(Integer.parseInt(id));
	}
	
	public void addCustomer(String name, String email, String phone, String carmodel, String carplate) {
		Customer obj = new Customer(name, email, phone, carmodel, carplate);
		service.addCustomer(obj);		
	}
	
	public void updateCustomer(String id, String name, String email, String phone, String carmodel, String carplate) {
		service.updateCustomer(Integer.parseInt(id), name, email, phone, carmodel, carplate);
	}
	
	public void deleteCustomer(String id) {
		service.deleteCustomer(Integer.parseInt(id));
	}
	
//	public void clickCustomer(String id) {
//		Customer c = service.getCustomer(Integer.parseInt(id));
//		this.ID = String.valueOf(c.getID());
//		this.Name = c.getName();
//		this.Email = c.getEmail();
//		this.Phone = c.getPhone();
//		this.CarModel = c.getCarModel();
//		this.CarPlate = c.getCarPlate();
//	}
	
	public List<Customer> listOfCustomers() {
		List<Customer> arr = service.listOfCustomers();
		return arr;
	}	
}
