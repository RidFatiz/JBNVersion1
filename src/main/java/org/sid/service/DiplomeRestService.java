package org.sid.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sid.dao.CandidatRepository;
import org.sid.entities.Candidat;
import org.sid.entities.Diplome;
import org.sid.metier.DiplomeMetier;

@RestController

public class DiplomeRestService {
	
	@Autowired
	private DiplomeMetier diplomeMetier;
	@Autowired
	private CandidatRepository candidatRepository;

	@RequestMapping(value="/diplome" ,method=RequestMethod.POST)
	public List<Diplome> save(@RequestBody Iterable <Diplome> d) {
		return diplomeMetier.save(d);
	}
	@RequestMapping(value="/diplome" ,method=RequestMethod.GET)
	public List<Diplome> getDiplome() {
		return diplomeMetier.getDiplome();
	}
	@RequestMapping(value="/diplome/{username}" ,method=RequestMethod.GET)
	public List<Diplome> Diplomebyusername(@PathVariable String username) {
		return diplomeMetier.Diplomebyusername(username);
	}
	
	@RequestMapping(value="/noteDiplome" ,method=RequestMethod.GET)
	public int note(String username,HttpServletRequest httpServletRequest) {
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		username=securityContext.getAuthentication().getName();
		
		Candidat c=candidatRepository.findbylogin(username);
		
		List<Diplome> diplome=diplomeMetier.Diplomebyusername(username);
		if(diplome.isEmpty())
		{
		return 0;
	}else { return 25;}
	
	}
	
	

}
