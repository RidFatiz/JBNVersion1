package org.sid.metier;

import java.util.List;

import org.sid.dao.FormationEntrepriseRepository;
import org.sid.dao.InvitationRepository;
import org.sid.entities.FormationEntreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormationEntrepriseMetierImpl  implements FormationEntrepriseMetier {

	@Autowired
	private FormationEntrepriseRepository formationEntrepriseRepository;
	
	@Autowired
	private InvitationRepository invitationRepository ;
	
	
	@Override
	public FormationEntreprise save(FormationEntreprise fe) {
		// TODO Auto-generated method stub
		return formationEntrepriseRepository.save(fe);
	}

	@Override
	public List<FormationEntreprise> findFormationUsername(String username) {
		// TODO Auto-generated method stub
		return formationEntrepriseRepository.findFormation(username) ;
	}

	@Override
	public List<FormationEntreprise> findFormation() {
	
		return formationEntrepriseRepository.findAll();
	}
	
	
	
	
	
	

}
