package org.sid.metier;

import java.util.List;

import org.sid.dao.ExpérienceRepository;
import org.sid.dao.GroupeRepository;
import org.sid.entities.Groupe;
import org.sid.entities.GroupeUser;
import org.sid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GroupeMetierImpl implements GroupeMetier {


	@Autowired
	private GroupeRepository groupeRepository;
	
	
	@Override
	public Groupe Save(Groupe p) {
		// TODO Auto-generated method stub
		return groupeRepository.save(p);
	}

	@Override
	public List<Groupe> find(String username) {
		// TODO Auto-generated method stub
		
		return groupeRepository.findGroupeByUser(username);
	}

	@Override
	public void delete(Long id) {
		groupeRepository.delete(id);
		
	}

	
	@Override
	public List<Groupe> findAllGroupe() {
		// TODO Auto-generated method stub
		return groupeRepository.findAll();
	}

	@Override
	public Groupe findGroupeBynom(String nom) {
		// TODO Auto-generated method stub
		return groupeRepository.findGroupeBynom(nom);
	}

	@Override
	public Groupe findGroupeById(Long id) {
		// TODO Auto-generated method stub
		return groupeRepository.findOne(id);
	}

	

}
