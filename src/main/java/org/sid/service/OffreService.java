package org.sid.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.sid.dao.RecruteurRepository;
import org.sid.entities.Offre;
import org.sid.entities.Recruteur;
import org.sid.entities.pageOffre;
import org.sid.metier.OffreMetier;
import org.sid.metier.RecruteurMetier;



@RestController
public class OffreService {
	
	
	
	@Autowired
	 private OffreMetier offreMetier;
	
	@Autowired
	private RecruteurRepository recruteurRepository; 
	
	@RequestMapping(value="/offre",method=RequestMethod.GET)
	public pageOffre listoffre(
			
			@RequestParam("page") int page, 
			@RequestParam("size") int size) {
		return offreMetier.listoffre(page, size);
	}
	@Secured(value={"ROLE_Recruteur"})
	@RequestMapping(value="/offre",method=RequestMethod.POST)
	public Offre save(@RequestBody Offre f) {
		return offreMetier.save(f);
	}
	
	@RequestMapping(value="/offre/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		offreMetier.delete(id);
	}
	@RequestMapping(value="/offre/{id}",method=RequestMethod.PUT)
	public void update(@PathVariable long id, @RequestBody Offre f) {
		offreMetier.update(id, f);
	}
	
	
	@RequestMapping(value="/offreposte/{poste}",method=RequestMethod.GET)
	public Offre getOffrePost(@PathVariable("poste") String poste){
		
		
		return offreMetier.getOffrePost(poste);
		
		
	}
	
	@RequestMapping(value="/offreId/{id}",method=RequestMethod.GET)
	public Offre getoffre(@PathVariable("id") long id) {
		return offreMetier.getoffre(id);
	}
	@RequestMapping(value="/offre/{ville}",method=RequestMethod.GET)
	public Offre findbyville(@PathVariable("ville") String ville) {
		return offreMetier.findbyville(ville);
	}
	@RequestMapping(value="/offre/{secteur}",method=RequestMethod.GET)
	public Offre findbySecteur(@PathVariable("secteur") String secteur) {
		return offreMetier.findbySecteur(secteur);
	}
	
	@RequestMapping(value="/offres1",method=RequestMethod.GET)
	public pageOffre getOffre1(String ville, String secteur, String poste, int page, int size) {
		return offreMetier.getOffre1(ville, secteur, poste, page, size);
	}

	@RequestMapping(value="/offres2",method=RequestMethod.GET)
	public pageOffre getOffre2(String ville, String secteur, String poste, int page, int size) {
		return offreMetier.getOffre2(ville, secteur, poste, page, size);
	}
	@RequestMapping(value="/offres3",method=RequestMethod.GET)
	public pageOffre getOffre3(String ville, String secteur, String poste, int page, int size) {
		return offreMetier.getOffre3(ville, secteur, poste, page, size);
	}
	
	@RequestMapping(value="/OffreRecruteur",method=RequestMethod.GET)
	public List<Offre> findOffreByUsername(HttpServletRequest httpServletRequest) {
		
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		String username=securityContext.getAuthentication().getName();
		Recruteur recruteur=recruteurRepository.findbylogin(username);
		return offreMetier.findOffreByUsername(username);
		
		
		
	}
	
	
}
