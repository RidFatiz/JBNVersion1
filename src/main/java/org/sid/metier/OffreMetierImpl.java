package org.sid.metier;



import java.util.Date;
import java.util.List;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import org.sid.dao.OffreRepository;
import org.sid.entities.Offre;
import org.sid.entities.pageOffre;

@Service
public  class OffreMetierImpl implements OffreMetier {
@Autowired
	private OffreRepository offreRepository;
	@Override
	public Offre save(Offre f) {
		f.setDate(new Date());
		return offreRepository.save(f);
	}

	@Override
	public void delete(long id) {
		offreRepository.delete(id);
		
	}

	@Override
	public void update(long id, Offre f) {
		Offre f1=offreRepository.findOne(id);
		f1.setDescription(f.getDescription());
		f1.setDate(f.getDate());
		f1.setLieu(f.getLieu());
		f1.setDateDebut(f.getDateDebut());
		f1.setDateFin(f.getDateFin());
		f1.setTypecontrant(f.getTypecontrant());
		offreRepository.saveAndFlush(f1);
		
		
	}

	
	
	@Override
	public Offre getoffre(long id) {
		return offreRepository.findOne(id);
		
	}

	@Override
	public Offre getOffrePost(String poste) {
		
		return offreRepository.findbypost(poste);
	}

	@Override
	public Offre findbyville(String ville) {
		// TODO Auto-generated method stub
		return offreRepository.findbyVille(ville);
	}

	@Override
	public Offre findbySecteur(String secteur) {
		// TODO Auto-generated method stub
		return offreRepository.findbySecteur(secteur);
	}

	@Override
	public pageOffre  listoffre( int page, int size) {
		// TODO Auto-generated method stub
	
     Page<Offre> offre=offreRepository.findAll(new PageRequest(page, size))	;
		
	
    pageOffre pageOffre=new pageOffre();
   pageOffre.setOffres(offre.getContent());

   pageOffre.setNombreoffre(offre.getNumberOfElements());

pageOffre.setPage(offre.getNumber());
pageOffre.setTotalPage(offre.getTotalPages());




    // TODO Auto-generated method stub
     return pageOffre;
}
	@Override
	public pageOffre getOffre1(String ville, String secteur, String poste, int page, int size) {
		
		
			
		Page<Offre> offre=offreRepository.findByOffre1(ville, secteur, poste,new PageRequest(page, size) );
		
		pageOffre pageOffre=new pageOffre();
		pageOffre.setOffres(offre.getContent());
		
		pageOffre.setNombreoffre(offre.getNumberOfElements());
		
		pageOffre.setPage(offre.getNumber());
		pageOffre.setTotalPage(offre.getTotalPages());
		
		
	
		
		// TODO Auto-generated method stub
		return pageOffre;
	}

	@Override
	public List<Offre> findOffre(String ville, String secteur, String poste) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public pageOffre getOffre2(String ville, String secteur, String poste, int page, int size) {

Page<Offre> offre=offreRepository.findByOffre2(ville, secteur, poste,new PageRequest(page, size) );
		
		pageOffre pageOffre=new pageOffre();
		pageOffre.setOffres(offre.getContent());
		
		pageOffre.setNombreoffre(offre.getNumberOfElements());
		
		pageOffre.setPage(offre.getNumber());
		pageOffre.setTotalPage(offre.getTotalPages());
		
		
	
		
		// TODO Auto-generated method stub
		return pageOffre;
	}

	@Override
	public pageOffre getOffre3(String ville, String secteur, String poste, int page, int size) {
Page<Offre> offre=offreRepository.findByOffre3(ville, secteur, poste,new PageRequest(page, size) );
		
		pageOffre pageOffre=new pageOffre();
		pageOffre.setOffres(offre.getContent());
		
		pageOffre.setNombreoffre(offre.getNumberOfElements());
		
		pageOffre.setPage(offre.getNumber());
		pageOffre.setTotalPage(offre.getTotalPages());
		
		
	
		
		// TODO Auto-generated method stub
		return pageOffre;
	}

	@Override
	public List<Offre> findOffreByUsername(String username) {
		
		return offreRepository.findOffreByUsername(username) ;
	}


	}


