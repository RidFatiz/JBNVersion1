package org.sid.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.sid.dao.CandidatRepository;
import org.sid.entities.Candidat;

@Service
public class CandidatMetierImpl implements CandidatMetier {
	@Autowired

	private CandidatRepository candidatRepository;
	
	
	@Override
	public Candidat save(Candidat c) {
		
		return candidatRepository.save(c);
	}

	
	@Override
	public List<Candidat> getCandidat() {
		
		return candidatRepository.findAll();
	}


	@Override
	public void Update(Candidat candidat, String username) {
		Candidat c1=candidatRepository.findbylogin(username);
		c1.setActive(candidat.isActive());
		c1.setAdresse(candidat.getAdresse());
		c1.setCodePostale(candidat.getCodePostale());
		c1.setDateNaissance(candidat.getDateNaissance());
		c1.setDateCreation(new Date());
		c1.setEmail(candidat.getEmail());
		c1.setGenre(candidat.getGenre());
		c1.setNationalite(candidat.getNationalite());
		c1.setNom(candidat.getNom());
		c1.setPassword(candidat.getPassword());
		c1.setPays(candidat.getPays());
		c1.setPrenom(candidat.getPrenom());
		c1.setStatus(candidat.getStatus());
		c1.setTel(candidat.getTel());
		c1.setVille(candidat.getVille());
	
		
		
		
	}


	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Candidat findcandidat(String username) {
		
		
		return candidatRepository.findbylogin(username);
	}


	
}
