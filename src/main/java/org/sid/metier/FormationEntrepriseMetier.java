package org.sid.metier;

import java.util.List;

import org.sid.entities.FormationEntreprise;

public interface FormationEntrepriseMetier {

	public FormationEntreprise save(FormationEntreprise fe);
	public List<FormationEntreprise> findFormationUsername(String username);
	public List<FormationEntreprise> findFormation();
	
}
