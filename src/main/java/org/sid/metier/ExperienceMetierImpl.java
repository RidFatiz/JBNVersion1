package org.sid.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.sid.dao.ExpérienceRepository;
import org.sid.entities.Experience;
@Service
public class ExperienceMetierImpl implements ExperienceMetier {

	@Autowired
	private ExpérienceRepository expérienceRepository;
	
	

	@Override
	public List<Experience> getExperience() {
		// TODO Auto-generated method stub
		return expérienceRepository.findAll();
	}



	@Override
	public List<Experience> save(Iterable<Experience> e) {
		// TODO Auto-generated method stub
		return expérienceRepository.save(e);
	}



	@Override
	public void delete(long id) {

		expérienceRepository.delete(id);
	}



	@Override
	public void Update(Experience e, long id) {
		Experience e1=expérienceRepository.findOne(id);
		
		e1.setDateDebut(e.getDateDebut());
		e1.setDateFin(e.getDateFin());
		e1.setDescription_expérience(e.getDescription_expérience());
		e1.setLieu(e.getLieu());
		e1.setPoste(e.getPoste());
		e1.setType(e.getType());
		
	}



	@Override
	public List<Experience> Experiencebyusername(String username) {
		// TODO Auto-generated method stub
		return expérienceRepository.findExperiencebyusername(username);
	}
}
