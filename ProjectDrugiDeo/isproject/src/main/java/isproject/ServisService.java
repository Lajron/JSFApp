package isproject;
import java.util.List;

public interface ServisService {
	public Servis getServis(int id);
	public void addServis(Servis obj);
	public void deleteServis(int id);
	public void updateServis(int id, String name, int price, int parts);
	public List<Servis> ListOfServises();
}
