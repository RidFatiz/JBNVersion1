package org.sid.metier;

import java.util.List;

import org.sid.entities.Publication;

public interface PublicationMetier {
	public Publication save(Publication p);
	public List<Publication> find(String username);
	public List<Publication> findbyMembre(String login);
	public  Publication findPublication(Long id);
	public void delete(Long id);
	
	
	
	

}
