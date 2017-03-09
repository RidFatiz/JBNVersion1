package org.sid.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import scala.Boolean;

import org.sid.dao.CandidatRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Candidat;
import org.sid.entities.Competence;
import org.sid.entities.User;
import org.sid.metier.CompetenceMetier;

@Secured(value={"ROLE_Candidat"})
@RestController

public class CompetenceRestService {
	
	@Autowired
	public CompetenceMetier competenceMetier;
	
	@Autowired
	private UserRepository   userRepository ;
	@Autowired
	private CandidatRepository candidatRepository;
	@RequestMapping(value="/competence" ,method=RequestMethod.POST)
	public List<Competence> save(@RequestBody Iterable<Competence> c ) {
		
	
		return competenceMetier.save(c);
	}

	@RequestMapping(value="/competence" ,method=RequestMethod.GET)
	public List<Competence> getCompetence() {
		return competenceMetier.getCompetence();
	}
	
	@RequestMapping(value="/competence/{idCompetence}" ,method=RequestMethod.DELETE)
	public void delete( @PathVariable long idCompetence) {
		competenceMetier.delete(idCompetence);
	}
	
	@RequestMapping(value="/competence/{idCompetence}" ,method=RequestMethod.PUT)
	public void update(@PathVariable long idCompetence,@RequestBody Competence c) {
		competenceMetier.update(idCompetence,c);
	}
	
	
	@RequestMapping(value="/competence/{username}" ,method=RequestMethod.GET)
	public List<Competence> getCompetencebyusername(@PathVariable String username) {
		return competenceMetier.Competencebyusername(username);
	}
	
	@RequestMapping(value="/notecompetence" ,method=RequestMethod.GET)
	public int note(String username,HttpServletRequest httpServletRequest) {
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		username=securityContext.getAuthentication().getName();
		
		List<Competence> competence=competenceMetier.Competencebyusername(username);
		if(competence.isEmpty())
		{
		return 0;
		}else  {
		return 25;
		}
		
	
	}
}
