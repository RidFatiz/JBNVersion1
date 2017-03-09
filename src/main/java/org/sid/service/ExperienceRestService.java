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
import org.sid.metier.ExperienceMetier;
@Secured(value={"ROLE_Candidat"})
@RestController
public class ExperienceRestService {
	@Autowired
	private ExperienceMetier experienceMetier;
	@Autowired
	private CandidatRepository candidatRepository;

	@RequestMapping(value="/experience" ,method=RequestMethod.POST)
	public List<Experience> save( @RequestBody Iterable<Experience> e) {
		return experienceMetier.save(e);
	}

	@RequestMapping(value="/experience" ,method=RequestMethod.GET)
	public List<Experience> getExperience() {
		return experienceMetier.getExperience();
	}

	@RequestMapping(value="/experience/{username}" ,method=RequestMethod.GET)
	public List<Experience> Experiencebyusername(@PathVariable String username) {
		return experienceMetier.Experiencebyusername(username);
	}
	@RequestMapping(value="/noteExperience" ,method=RequestMethod.GET)
	public int ifExist(String username,HttpServletRequest httpServletRequest) {
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		username=securityContext.getAuthentication().getName();
		
		Candidat c=candidatRepository.findbylogin(username);
		List<Experience> experience=experienceMetier.Experiencebyusername(username);
		if(experience.isEmpty())
		{ return 0 ; }
		else {return 25;}
	}
	
	

}
