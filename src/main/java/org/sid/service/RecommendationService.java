package org.sid.service;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sid.dao.UserRepository;
import org.sid.entities.Recommendation;
import org.sid.entities.User;
import org.sid.metier.RecommendationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationService {
	
	@Autowired
	private RecommendationMetier recommendationMetier;
	
	@Autowired
	private UserRepository   userRepository ;
	

	@RequestMapping(value="/recommendation/{recepeteur}",method=RequestMethod.POST)
	public Recommendation save( @RequestBody Recommendation p,HttpServletRequest httpServletRequest ,@PathVariable User recepeteur) {
		
		
		HttpSession session=httpServletRequest.getSession(true);
	    SecurityContext securityContext=(SecurityContext) session
			          .getAttribute("SPRING_SECURITY_CONTEXT");
	
	    String login=securityContext.getAuthentication().getName();
	    User destinataire= userRepository.getUser(login);	
	 
	    p.setDateRecommandation(new Date());
	    p.setDestinataire(destinataire);
	    p.setRecepteur(recepeteur);
	 
		return recommendationMetier.save(p);
	}

	@RequestMapping(value="/recommendation/{username}",method=RequestMethod.GET)
	public List<Recommendation> find(@PathVariable String username) {
		
		return recommendationMetier.find(username);
		
	}
	
	
	
	

}
