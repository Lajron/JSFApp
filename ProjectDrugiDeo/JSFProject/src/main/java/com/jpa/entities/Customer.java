package com.jpa.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "customer")
public class Customer {
	
	@TableGenerator(name = "customer_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "customer_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "customer_gen")
	
    @Column(name = "ID", updatable = false, nullable = false)
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Phone")
	private String phone;
	
	@Column(name = "Carmodel")
	private String carmodel;
	
	@Column(name = "Carplate")
	private String carplate;
	
	public Customer() {}
	
	public Customer(String name, String email, String phone, String carmodel, String carplate) {
		this.setName(name);
		this.setEmail(email);
		this.setPhone(phone);
		this.setCarmodel(carmodel);
		this.setCarplate(carplate);
	}
		
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getCarmodel() {
		return this.carmodel;
	}
	
	public void setCarmodel(String carModel) {
		this.carmodel = carModel;
	}
	
	public String getCarplate() {
		return this.carplate;
	}
	
	public void setCarplate(String carPlate) {
		this.carplate = carPlate;
	}
}
