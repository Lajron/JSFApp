package com.ejb.services;
import java.util.List;
import com.jpa.entities.*;

public interface ServisService {
	public Servis getServis(int id);
	public void addServis(Servis obj);
	public void deleteServis(int id);
	public void updateServis(int id, String name, int price, int parts);
	public List<Servis> listOfServises();
}
