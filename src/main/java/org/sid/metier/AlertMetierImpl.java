package org.sid.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.sid.dao.AlerteRepository;
import org.sid.dao.OffreRepository;
import org.sid.entities.Alert;
import org.sid.entities.Offre;

@Service
public class AlertMetierImpl   implements AlertMetier{
	
	
	@Autowired

	public  AlerteRepository alerteRepository;
	
	
	
	@Override
	public Alert save(Alert a) {
		
		a.setDate(new Date());
		
		return (Alert) alerteRepository.save(a);
		
		
	}


	@Override
	public List<Alert> rechercherAlerParOffre(Long idOffre) {
		// TODO Auto-generated method stub
		return alerteRepository.RechercheAlertparOffre(idOffre);
	}

	public Offre rechercherOffreParAlert() {
		// TODO Auto-generated method stub
		return alerteRepository.RechercheOffreparalerte();
	}



}
