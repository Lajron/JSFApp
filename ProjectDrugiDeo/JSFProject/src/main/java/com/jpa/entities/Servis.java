package com.jpa.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "service")
public class Servis {
	
	@TableGenerator(name = "service_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "service_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "service_gen")
	
    @Column(name = "ID", updatable = false, nullable = false)
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Price")
	private int price;
	
	@Column(name = "Parts")
	private int parts;
	
	public Servis() {}
	
	public Servis(String name, int price, int parts) {
		this.setName(name);
		this.setPrice(price);
		this.setParts(parts);		
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
	
	public int getPrice() {
		return this.price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getParts() {
		return this.parts;
	}
	
	public void setParts(int parts) {
		this.parts = parts;
	}	
}
