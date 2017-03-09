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
import org.sid.entities.Experience;
import org.sid.entities.Loisir;
import org.sid.metier.LoisirMetier;
@Secured(value={"ROLE_Candidat"})
@RestController
public class LoisirRestService {
	@Autowired
	private  LoisirMetier loisirMetier ;
	@Autowired
	private CandidatRepository candidatRepository;

	@RequestMapping(value="/loisir" ,method=RequestMethod.POST) 
	public List<Loisir> save( @RequestBody Iterable<Loisir> l)	{
		return loisirMetier.save(l);
	}
	@RequestMapping(value="/loisir" ,method=RequestMethod.GET)
	public List<Loisir> getLoisir() {
		return loisirMetier.getLoisir();
	}
	@RequestMapping(value="/loisir/{username}" ,method=RequestMethod.GET)
	public List<Loisir> Loisirbyusername(@PathVariable String username) {
		return loisirMetier.Loisirbyusername(username);
	}
	@RequestMapping(value="/noteLoisir" ,method=RequestMethod.GET)
	public int  ifExist(String username,HttpServletRequest httpServletRequest) {
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		username=securityContext.getAuthentication().getName();
		List<Loisir> loisir=loisirMetier.Loisirbyusername(username);
		if( loisir.isEmpty())
		{ return 0;}
		else { return 25;}
	}
	

}
