package org.sid.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.sid.dao.LangueRepository;
import org.sid.entities.Langue;
@Service
public class LangueMetierImpl implements LangueMetier{

	@Autowired
	private LangueRepository langueRepository;
	
	

	@Override
	public List<Langue> getLangue() {
		// TODO Auto-generated method stub
		return langueRepository.findAll();
	}

	@Override
	public List<Langue> save(Iterable<Langue> l) {
		// TODO Auto-generated method stub
		return langueRepository.save(l) ;
	}

	@Override
	public void delete(long id) {
		langueRepository.delete(id);
	}

	@Override
	public void Update(Langue l, long id) {
		
		Langue l1=langueRepository.findOne(id);
		l1.setNiveau(l.getNiveau());
		l1.setLangue(l.getLangue());
	}

	@Override
	public List<Langue> Languebyusername(String username) {
		// TODO Auto-generated method stub
		return langueRepository.findLanguebyusername(username);
	}
}
	
	


