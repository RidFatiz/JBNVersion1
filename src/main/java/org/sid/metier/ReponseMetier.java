package org.sid.metier;

import java.util.Iterator;
import java.util.List;

import org.sid.entities.Loisir;
import org.sid.entities.Reponse;



public interface ReponseMetier {
	public List<Reponse> save(List<Reponse> r);
	public List<Reponse> getReponse();
    public void deleteReponse(Long idReponse);
	
	

}
