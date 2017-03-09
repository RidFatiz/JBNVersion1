package org.sid.metier;

import java.util.List;

import org.sid.dao.UserRepository;
import org.sid.dao.VisiteRepository;
import org.sid.entities.User;
import org.sid.entities.Visite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class VisiteMetierImpl implements  VisiteMetier  {


	@Autowired
	private VisiteRepository visiteRepository;

	@Override
	public void save(Visite v, User visiteur) {
		
		if(visiteRepository.ExistsVisiteur(v.getVisitant().getUsername(), visiteur.getUsername()).isEmpty() && visiteur.getUsername()!=v.getVisitant().getUsername())
		
		{ visiteRepository.save(v);}
		}
		
	
	@Override
	public List<Visite> findVisiteur(String username) {
	
		return  visiteRepository.findVisiteur(username);
	}

	@Override
	public List<Visite> findAll() {
		// TODO Auto-generated method stub
		return visiteRepository.findAll();
	}


	
	
}
