package org.sid.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sid.dao.FormationEntrepriseRepository;
import org.sid.dao.RecruteurRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.FormationEntreprise;
import org.sid.entities.Recruteur;
import org.sid.entities.User;
import org.sid.metier.FormationEntrepriseMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormationEntrepriseService {

	
	@Autowired 
	private FormationEntrepriseMetier formationEntrepriseMetier;
	
	@Autowired 
	private FormationEntrepriseRepository  formationEntrepriseRepository;
	
	@Autowired
	private RecruteurRepository recruteurRepository;
	@RequestMapping(value="/formationEntreprise" ,method=RequestMethod.POST)
	public FormationEntreprise save(@RequestBody FormationEntreprise fe ,HttpServletRequest httpServletRequest) {
		
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		
		String username=securityContext.getAuthentication().getName();
		Recruteur user= recruteurRepository.findbylogin(username);
		fe.setRecruteur(user);	
		return formationEntrepriseMetier.save(fe);
	}
	@RequestMapping(value="/PubFormation" ,method=RequestMethod.GET)
	public List<FormationEntreprise> findFormationCandidat(String username,HttpServletRequest httpServletRequest) {
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		
		username=securityContext.getAuthentication().getName();
		return formationEntrepriseRepository.findFormationRecruteurAmis(username);
	}
	
	
	@RequestMapping(value="/FormationRecruteur" ,method=RequestMethod.GET)
	
	public List<FormationEntreprise> findFormationUsername(String username,HttpServletRequest httpServletRequest) {
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		
		username=securityContext.getAuthentication().getName();
		return formationEntrepriseMetier.findFormationUsername(username);
	}
	@RequestMapping(value="/formationAll" ,method=RequestMethod.GET)
	public List<FormationEntreprise> findFormation() {
		return formationEntrepriseMetier.findFormation();
	}
	
	
	
	
	
	
}
