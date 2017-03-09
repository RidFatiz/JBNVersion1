package org.sid.metier;

import java.util.Date;
import java.util.List;

import org.sid.entities.Recruteur;

public interface RecruteurMetier {
	

	
    public Recruteur save(Recruteur r);
    public List<Recruteur> getRecruteur();

	public  void Update(Recruteur recruteur,String username);
	
	public void delete(String email);
	

}
