package org.sid.metier;

import java.util.List;

import org.sid.entities.User;
import org.sid.entities.Visite;

public interface VisiteMetier {

	public void save(Visite v, User visiteur);
	public List<Visite> findVisiteur(String username);
	public List<Visite> findAll();
	

}
