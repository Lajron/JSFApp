package com.ejb.services;
import java.util.List;
import com.jpa.entities.*;

public interface CustomerService {
	public Customer getCustomer(int id);
	public void addCustomer(Customer obj);
	public void deleteCustomer(int id);
	public void updateCustomer(int id, String name, String email, String phone, String carmodel, String carplate);
	public List<Customer> listOfCustomers();
}
