package org.sid.metier;

import java.util.List;


import org.sid.entities.Commentaire;



public interface CommentaireMetier {
	
	
	
	
	public  Commentaire save(Commentaire c);

	
	public List<Commentaire> findCommentaire();
	
	public List<Commentaire> findCommentaireBypublication(long id);
	

}
