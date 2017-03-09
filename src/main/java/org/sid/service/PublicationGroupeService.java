package org.sid.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sid.dao.UserRepository;
import org.sid.entities.Groupe;
import org.sid.entities.PublicationGroupe;
import org.sid.entities.User;
import org.sid.metier.PublicationGroupeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicationGroupeService {
	
	@Autowired
	private PublicationGroupeMetier publicationgroupeMetier;
	@Autowired
	private UserRepository   userRepository ;
	@RequestMapping(value="/publicationgroupe/{groupe}",method=RequestMethod.POST)
	public PublicationGroupe save(@RequestBody PublicationGroupe publicationgroupe,HttpServletRequest httpServletRequest,@PathVariable Groupe groupe) {
		
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		String login=securityContext.getAuthentication().getName();
		User user= userRepository.getUser(login);
		publicationgroupe.setUser(user);
		publicationgroupe.setDatePublication(new Date());
		publicationgroupe.setGroupe(groupe);
		return publicationgroupeMetier.save(publicationgroupe);
	}
	@RequestMapping(value="/publicationgroupe",method=RequestMethod.GET)
	public List<PublicationGroupe> findAll() {
		return publicationgroupeMetier.findAll();
	}

	
	
	
	

}
