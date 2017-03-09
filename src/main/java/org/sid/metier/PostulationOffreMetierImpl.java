package org.sid.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.sid.dao.PostulationOffreRepository;
import org.sid.entities.Candidat;
import org.sid.entities.Offre;
import org.sid.entities.OffrePostulation;
import org.sid.entities.Recruteur;
@Service
public class PostulationOffreMetierImpl implements PostulationOffreMetier {
	
	@Autowired
	
	private PostulationOffreRepository postulationOffreRepository ;
	@Override
	public OffrePostulation save(OffrePostulation p) {
		
		return postulationOffreRepository.save(p);
	}
	@Override
	public List<OffrePostulation> get() {
		// TODO Auto-generated method stub
		return postulationOffreRepository.findAll() ;
	}
	@Override
	public Boolean ifExist(String username , Long idOffre) {
	if(postulationOffreRepository.postulationIfExist(username, idOffre).isEmpty() ){
		return true;
	}
	else{
		return false;
	}
	}
	@Override
	public List<OffrePostulation> getPostulation(Recruteur r) {
		
		return  postulationOffreRepository.getPostulation(r);
	}
	@Override
	public String countPostulation(String username) {
		
		return postulationOffreRepository.findCountPostulationUser(username);
	}

}
