package org.sid.metier;

import java.util.Date;
import java.util.List;

import org.sid.dao.RecruteurRepository;
import org.sid.entities.Recruteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruteurMetierImpl implements RecruteurMetier {
	@Autowired
	private RecruteurRepository recruteurRepository;

	@Override
	public Recruteur save(Recruteur r) {
		
		return recruteurRepository.save(r);
	}

	@Override
	public List<Recruteur> getRecruteur() {
		return recruteurRepository.findAll();
	}

	

	@Override
	public void delete(String email) {
		Recruteur u=recruteurRepository.findOne(email);
		recruteurRepository.delete(u);
		
	}

	@Override
	public void Update(Recruteur recruteur, String username) {
		// TODO Auto-generated method stub
		
	}

}
