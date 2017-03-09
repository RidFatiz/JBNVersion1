package org.sid.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sid.entities.Recruteur;
import org.sid.entities.User;
import org.sid.entities.Visite;
import org.sid.metier.TestMetier;
import org.sid.metier.UserMetier;
import org.sid.metier.VisiteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisiteService {
	
	@Autowired
	private VisiteMetier visiteMetier;
	@Autowired
	private UserMetier userMetier;
	@RequestMapping(value="/visite/{visiteur}",method=RequestMethod.POST)
	public void save(@RequestBody Visite v,  @PathVariable User visiteur, HttpServletRequest httpServletRequest) {
		
		
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		String login=securityContext.getAuthentication().getName();
		User user1=userMetier.findUser(login);
		v.setVisitant(user1);
		v.setVisiteur(visiteur);
		visiteMetier.save(v, visiteur);
		System.out.println("hhhh");
	
	}
	@RequestMapping(value="/visite",method=RequestMethod.GET)
	public List<Visite> findVisiteur(String username,HttpServletRequest httpServletRequest) {
		
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		username=securityContext.getAuthentication().getName();
		return visiteMetier.findVisiteur(username);
	}
	@RequestMapping(value="/visiteall",method=RequestMethod.GET)
	public List<Visite> findAll() {
		return visiteMetier.findAll();
	}
	
	
	
	
	
	
	
	

}
