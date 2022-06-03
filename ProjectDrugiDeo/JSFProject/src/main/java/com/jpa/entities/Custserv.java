package com.jpa.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "custserv")
public class Custserv {
	
	@TableGenerator(name = "custserv_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "custserv_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "custserv_gen")
	
    @Column(name = "ID", updatable = false, nullable = false)
	private int id;
	
	@Column(name = "FKcustomer")
	private int fkcustomer;
	
	@Column(name = "FKservice")
	private int fkservice;
	
	@Column(name = "Fixed")
	private String fixed;
	
	@Column(name = "FullPrice")
	private int fullprice;
	
	@Column(name = "Paid")
	private String paid;
	
	public Custserv() {}
	
	public Custserv(int fkcustomer, int fkservice, String fixed, int fullprice, String paid) {
		this.setFkcustomer(fkcustomer);
		this.setFkservice(fkservice);
		this.setFixed(fixed);
		this.setFullprice(fullprice);
		this.setPaid(paid);
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getFkcustomer() {
		return this.fkcustomer;
	}

	public void setFkcustomer(int fkcustomer) {
		this.fkcustomer = fkcustomer;
	}
	
	public int getFkservice() {
		return this.fkservice;
	}

	public void setFkservice(int fkservice) {
		this.fkservice = fkservice;
	}
	
	public String getFixed() {
		return this.fixed;
	}
	
	public void setFixed(String fixed) {
		this.fixed = fixed;
	}
	
	public int getFullprice() {
		return this.fullprice;
	}

	public void setFullprice(int fullprice) {
		this.fullprice = fullprice;
	}
	
	public String getPaid() {
		return this.paid;
	}
	
	public void setPaid(String paid) {
		this.paid = paid;
	}
}
