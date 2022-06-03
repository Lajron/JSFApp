package isproject;
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
	private int ID;
	
	@Column(name = "FKcustomer")
	private int FKcustomer;
	
	@Column(name = "FKservice")
	private int FKservice;
	
	@Column(name = "Fixed")
	private String Fixed;
	
	@Column(name = "FullPrice")
	private int FullPrice;
	
	@Column(name = "Paid")
	private String Paid;
	
	public Custserv() {}
	
	public Custserv(int fkcustomer, int fkservice, String fixed, int fullprice, String paid) {
		this.setFKcustomer(fkcustomer);
		this.setFKservice(fkservice);
		this.setFixed(fixed);
		this.setFullPrice(fullprice);
		this.setPaid(paid);
	}
	
	public int getID() {
		return this.ID;
	}
	
	public int getFKcustomer() {
		return this.FKcustomer;
	}

	public void setFKcustomer(int fkcustomer) {
		this.FKcustomer = fkcustomer;
	}
	
	public int getFKservice() {
		return this.FKservice;
	}

	public void setFKservice(int fkservice) {
		this.FKservice = fkservice;
	}
	
	public String getFixed() {
		return this.Fixed;
	}
	
	public void setFixed(String fixed) {
		this.Fixed = fixed;
	}
	
	public int getFullPrice() {
		return this.FullPrice;
	}

	public void setFullPrice(int fullprice) {
		this.FullPrice = fullprice;
	}
	
	public String getPaid() {
		return this.Paid;
	}
	
	public void setPaid(String paid) {
		this.Paid = paid;
	}
	
	@Override
	public String toString() {
		return FKcustomer + " - " + FKservice + " - " + FullPrice + " - " + Fixed + " - " + Paid;
	}

}
