package org.sid.metier;

import java.util.Date;
import java.util.List;

import org.sid.entities.Candidat;
import org.sid.entities.User;


public interface CandidatMetier {	
public Candidat save(Candidat c);	
public List<Candidat> getCandidat();
public  void Update(Candidat candidat,String username);	
public void delete(String username);	
public Candidat findcandidat( String username);

	
	
	
	
	
	
	

}
