package isproject;
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
	private int ID;
	
	@Column(name = "Name")
	private String Name;
	
	@Column(name = "Price")
	private int Price;
	
	@Column(name = "Parts")
	private int Parts;
	
	public Servis() {}
	
	public Servis(String name, int price, int parts) {
		this.setName(name);
		this.setPrice(price);
		this.setParts(parts);		
	}
	
	public int getID() {
		return this.ID;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public void setName(String name) {
		this.Name = name;
	}
	
	public int getPrice() {
		return this.Price;
	}
	
	public void setPrice(int price) {
		this.Price = price;
	}
	
	public int getParts() {
		return this.Parts;
	}
	
	public void setParts(int parts) {
		this.Parts = parts;
	}
	
	@Override
	public String toString() {
		return Name + " - " + Price + " - " + Parts;
	}
	
	
}
