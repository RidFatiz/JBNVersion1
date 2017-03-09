package org.sid.metier;

import java.util.List;

import org.sid.entities.Experience;
import org.sid.entities.Langue;
import org.sid.entities.Loisir;

public interface LoisirMetier {
	
	
	public List<Loisir> save(Iterable<Loisir> l);	
	public List<Loisir> getLoisir();
	public void delete(long id);
	public void Update(Loisir l, long id);
	public List<Loisir> Loisirbyusername(String username);	

}
