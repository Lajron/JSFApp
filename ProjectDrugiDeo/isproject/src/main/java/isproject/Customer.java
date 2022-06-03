package isproject;
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
	private int ID;
	
	@Column(name = "Name")
	private String Name;
	
	@Column(name = "Email")
	private String Email;
	
	@Column(name = "Phone")
	private String Phone;
	
	@Column(name = "CarModel")
	private String CarModel;
	
	@Column(name = "CarPlate")
	private String CarPlate;
	
	public Customer() {}
	
	public Customer(String name, String email, String phone, String carmodel, String carplate) {
		this.setName(name);
		this.setEmail(email);
		this.setPhone(phone);
		this.setCarModel(carmodel);
		this.setCarPlate(carplate);
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
	
	public String getEmail() {
		return this.Email;
	}
	
	public void setEmail(String email) {
		this.Email = email;
	}
	
	public String getPhone() {
		return this.Phone;
	}
	
	public void setPhone(String phone) {
		this.Phone = phone;
	}
	
	public String getCarModel() {
		return this.CarModel;
	}
	
	public void setCarModel(String carModel) {
		this.CarModel = carModel;
	}
	
	public String getCarPlate() {
		return this.CarPlate;
	}
	
	public void setCarPlate(String carPlate) {
		this.CarPlate = carPlate;
	}
	
	@Override
	public String toString() {
		return Name + " - " + Email + " - " + Phone + " - " + CarModel +" - " + CarPlate ;
	}
}
