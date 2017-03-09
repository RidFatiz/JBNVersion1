package org.sid.metier;



import java.util.List;

import org.sid.entities.Alert;

import org.sid.entities.Offre;

public interface AlertMetier {
	
public Alert save(Alert a);
	
public List<Alert> rechercherAlerParOffre(Long idOffre);

	
public Offre rechercherOffreParAlert();



}
