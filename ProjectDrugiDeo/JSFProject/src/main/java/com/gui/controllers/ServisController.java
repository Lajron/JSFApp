package com.gui.controllers;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import com.ejb.services.*;
import com.jpa.entities.*;

@ManagedBean
public class ServisController {
	private String id;
	private String name;
	private String price;
	private String parts;
	
	@EJB
	ServisService service;
	
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
	
	public String getPrice() { 
		return price;
	}
	
	public void setPrice(String price) { 
		this.price = price;
	}
	
	public String getParts() { 
		return parts;
	}
	
	public void setParts(String parts) { 
		this.parts = parts;
	}
	
	public Servis getServis(String id) {
		return service.getServis(Integer.parseInt(id));
	}
	
	public void addServis(String name, String price, String parts) {
		Servis obj = new Servis(name, Integer.parseInt(price), Integer.parseInt(parts));
		service.addServis(obj);
	}
	
	public void updateServis(String id, String name, String price, String parts) {
		service.updateServis(Integer.parseInt(id), name, Integer.parseInt(price), Integer.parseInt(parts));
	}
	
	public void deleteServis(String id) {
		service.deleteServis(Integer.parseInt(id));
	}
	
//	public void clickServis(String id) {
//		Servis c = service.getServis(Integer.parseInt(id));
//		this.id = String.valueOf(c.getID());
//		this.name = c.getName();
//		this.price = String.valueOf(c.getPrice());
//		this.parts = String.valueOf(c.getParts());
//	}
	
	public List<Servis> listOfServises() {
		List<Servis> arr = service.listOfServises();
		return arr;
	}
}
