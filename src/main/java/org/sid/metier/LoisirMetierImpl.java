package org.sid.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.sid.dao.LoisirsRepository;
import org.sid.entities.Experience;
import org.sid.entities.Loisir;

@Service
public class LoisirMetierImpl implements LoisirMetier  {

	@Autowired
	private LoisirsRepository loisirsRepository;
	
	@Override
	public List<Loisir> getLoisir() {
		// TODO Auto-generated method stub
		return loisirsRepository.findAll();
	}

	@Override
	public List<Loisir> save(Iterable<Loisir> l) {
		// TODO Auto-generated method stub
		return loisirsRepository.save(l);
	}

	@Override
	public void delete(long id) {
		loisirsRepository.delete(id);
		
	}

	@Override
	public void Update(Loisir l, long id) {
		Loisir l1=loisirsRepository.findOne(id);
		l1.setDescription(l.getDescription());
		l1.setTypeLoisir(l.getTypeLoisir());
	}

	@Override
	public List<Loisir> Loisirbyusername(String username) {
		// TODO Auto-generated method stub
		return loisirsRepository.findloisirbyusername(username);
	}

}
