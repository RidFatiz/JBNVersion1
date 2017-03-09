package org.sid.metier;

import java.util.List;

import org.sid.entities.PublicationGroupe;

public interface PublicationGroupeMetier {
	
	public PublicationGroupe save(PublicationGroupe publicationgroupe);
	
	
	public  List<PublicationGroupe> findAll();
	

}
