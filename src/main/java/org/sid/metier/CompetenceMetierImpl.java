package org.sid.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.sid.dao.CompetenceRepository;
import org.sid.entities.Candidat;
import org.sid.entities.Competence;
@Service
public class CompetenceMetierImpl implements CompetenceMetier {

	
	@Autowired
	
	private CompetenceRepository competenceRepository;
	
	@Override
	public List<Competence> save(Iterable<Competence> c ) {
		
		
		return   competenceRepository.save(c);
		
	}

	@Override
	public List<Competence> getCompetence() {
		// TODO Auto-generated method stub
		return competenceRepository.findAll();
	}

	@Override
	public void delete(long idCompetence) {
		competenceRepository.delete(idCompetence);
		
	}

	@Override
	public void update(long idCompetence,Competence c) {
		Competence c1=competenceRepository.getOne(idCompetence);
		c1.setDescription_Competence(c.getDescription_Competence());
		c1.setTypeCompetence(c.getTypeCompetence());
		competenceRepository.saveAndFlush(c1);
	
	}

	@Override
	public List<Competence> Competencebyusername(String username) {
		// TODO Auto-generated method stub
		return competenceRepository.findCompetencebyUsername(username);
	}
	}
