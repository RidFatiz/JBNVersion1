package org.sid.metier;

import java.util.List;

import org.sid.entities.Aime;

public interface AimeMetier {
	
	
	
	public Aime save(Aime a);
	public Aime afficher(long id);
	public List<Aime> afficherAime(long id);
	
	public void delete(Long id);
	
	public  Aime afficher(String login,Long id);

	public  Boolean aimer(String login,Long id);

	

}
