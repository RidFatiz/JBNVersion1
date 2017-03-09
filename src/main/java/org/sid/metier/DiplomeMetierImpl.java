package org.sid.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.sid.dao.DiplomeRepository;
import org.sid.entities.Competence;
import org.sid.entities.Diplome;
@Service
public class DiplomeMetierImpl implements DiplomeMetier {

	@Autowired
	private DiplomeRepository diplomeRepository;
	@Override
	public List<Diplome> save(Iterable <Diplome> d) {
		
		return diplomeRepository.save(d);
	}

	@Override
	public void delete(long id) {

		diplomeRepository.delete(id);
	}

	@Override
	public List<Diplome> getDiplome() {
		// TODO Auto-generated method stub
		return diplomeRepository.findAll();
	}

	@Override
	public void Update(Diplome d, long id) {
		// TODO Auto-generated method stub
		
		Diplome d1=diplomeRepository.getOne(id);
		d1.setDateDebut(d.getDateDebut());
		
		d1.setDateFin(d.getDateFin());
		
		d1.setDescriptiondiplome(d.getDescriptiondiplome());
		
		d1.setEtablissement(d.getEtablissement());
		
		d1.setNiveauEtude(d.getNiveauEtude());
		
		d1.setTitreDiplome(d.getTitreDiplome());
	}

	@Override
	public List<Diplome> Diplomebyusername(String username) {
	
		return diplomeRepository.findDiplomebyusername(username);
	}

}
