package org.sid.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.sid.dao.AimePublicationRepository;
import org.sid.entities.Aime;


@Service
public class AimeMetierImlp implements AimeMetier  {
	
	@Autowired
	private AimePublicationRepository aimePublicationRepository;

	@Override
	public Aime save(Aime a) {
		// TODO Auto-generated method stub
		return aimePublicationRepository.save(a);
	}

	@Override
	public List<Aime> afficherAime(long id) {
		// TODO Auto-generated method stub
		return  aimePublicationRepository.findAime(id);
	}

	

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		aimePublicationRepository.delete(id);
	}

	@Override
	public Aime afficher(String login,Long id) {
		// TODO Auto-generated method stub
		return aimePublicationRepository.afficher(login,id);
	}

	@Override
	public Boolean aimer(String login, Long id) {
		Aime i=aimePublicationRepository.afficher(login,id);
		
		if(i!=null){
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public Aime afficher(long id) {
		// TODO Auto-generated method stub
		return aimePublicationRepository.getOne(id);
	}

	
	

	
}
