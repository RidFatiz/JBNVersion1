package org.sid.metier;

import java.util.List;

import org.sid.dao.PostulationOffreRepository;
import org.sid.dao.PublicationGroupeRepository;
import org.sid.entities.PublicationGroupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PublicationGroupeMetierImpl  implements PublicationGroupeMetier{

	
@Autowired
	
	private PublicationGroupeRepository publicationgroupeRepository ;
	@Override
	public PublicationGroupe save(PublicationGroupe publicationgroupe) {
		// TODO Auto-generated method stub
		return publicationgroupeRepository.save(publicationgroupe);
	}

	@Override
	public List<PublicationGroupe> findAll() {
		// TODO Auto-generated method stub
		return publicationgroupeRepository.findAll();
	}

}
