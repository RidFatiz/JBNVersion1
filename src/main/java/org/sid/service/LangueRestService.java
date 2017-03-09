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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.sid.dao.CandidatRepository;
import org.sid.entities.Candidat;
import org.sid.entities.Langue;
import org.sid.entities.Question;
import org.sid.metier.LangueMetier;
@Secured(value={"ROLE_Candidat"})
@RestController
public class LangueRestService {

	@Autowired
	private LangueMetier langueMetier;
	@Autowired
	private CandidatRepository candidatRepository;
	
	@RequestMapping(value="/langue" ,method=RequestMethod.POST)
	public List<Langue> save(@RequestBody Iterable<Langue> l){
		return langueMetier.save(l);
		
	}
	
	@RequestMapping(value="/langue" ,method=RequestMethod.GET)
	public List<Langue> getLangue() {
		return langueMetier.getLangue();
	}
	@RequestMapping(value="/langue/{username}" ,method=RequestMethod.GET)
	public List<Langue> Languebyusername(@PathVariable String username) {
		return langueMetier.Languebyusername(username);
	}
	@RequestMapping(value="/noteLangue" ,method=RequestMethod.GET)
	public int ifExist(String username,HttpServletRequest httpServletRequest) {
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		username=securityContext.getAuthentication().getName();
		List<Langue> langue=langueMetier.Languebyusername(username);
		
		if(langue.isEmpty())
		{return 0; }
		else { return 25;}
	}
	
	
	
}
