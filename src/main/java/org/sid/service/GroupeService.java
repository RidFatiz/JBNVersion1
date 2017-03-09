package org.sid.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sid.dao.UserRepository;
import org.sid.entities.Groupe;
import org.sid.entities.User;
import org.sid.metier.GroupeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aicha
 *
 */
@RestController
public class GroupeService {
	
@Autowired
private GroupeMetier groupeMetier;
@Autowired
private UserRepository   userRepository ;
@RequestMapping(value="/Groupe",method=RequestMethod.POST)
public Groupe Save(HttpServletRequest httpServletRequest ,@RequestBody Groupe p) {
	
	 HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		
		String login=securityContext.getAuthentication().getName();
	    User admin= userRepository.getUser(login);
		p.setDateCretion(new Date());
		p.setAdmin(admin);
	return groupeMetier.Save(p);
}
@RequestMapping(value="/Groupe",method=RequestMethod.GET)
public List<Groupe> find( String username,HttpServletRequest httpServletRequest) {
	
	HttpSession session=httpServletRequest.getSession(true);
	SecurityContext securityContext=(SecurityContext) session
			          .getAttribute("SPRING_SECURITY_CONTEXT");
	
	username=securityContext.getAuthentication().getName();
	
	
	return groupeMetier.find(username);
	
}
@RequestMapping(value="/Groupe/{id}",method=RequestMethod.DELETE)
public void delete(@PathVariable Long id) {
	groupeMetier.delete(id);
}
@RequestMapping(value="/GroupeAll",method=RequestMethod.GET)
public List<Groupe> findAllGroupe() {
	return groupeMetier.findAllGroupe();
}
@RequestMapping(value="/GroupeNom/{nom}",method=RequestMethod.GET)
public Groupe findGroupeBynom(@PathVariable String nom) {
	return groupeMetier.findGroupeBynom(nom);
}
@RequestMapping(value="/GroupeId/{id}",method=RequestMethod.GET)
public Groupe findGroupeById(@PathVariable Long id) {
	return groupeMetier.findGroupeById(id);
}






}
