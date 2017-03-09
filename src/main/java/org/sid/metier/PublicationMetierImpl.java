package org.sid.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.sid.dao.PublicationRepository;
import org.sid.entities.Publication;
@Service
public class PublicationMetierImpl  implements PublicationMetier {
	
	@Autowired
	private PublicationRepository publicationRepository;

	@Override
	public Publication save(Publication p) {
		// TODO Auto-generated method stub
		return publicationRepository.save(p);
	}

	@Override
	public List<Publication> find(String username) {
		// TODO Auto-generated method stub
		return publicationRepository.findPublication(username);
	}

	@Override
	public List<Publication> findbyMembre(String login) {
		// TODO Auto-generated method stub
		return publicationRepository.findParUser(login);
	}

	@Override
	public Publication findPublication(Long id) {
		
		return publicationRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		publicationRepository.delete(id);
		
	}
	
	
	

}
