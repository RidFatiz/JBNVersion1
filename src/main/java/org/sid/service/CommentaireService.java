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
import org.sid.dao.UserRepository;
import org.sid.entities.Commentaire;
import org.sid.entities.User;
import org.sid.metier.CommentaireMetier;
@Secured(value={"ROLE_Candidat","ROLE_Recruteur"})
@RestController 
public class CommentaireService {
	
	
	@Autowired
	private CommentaireMetier commentaireMetier;

	@Autowired
	private UserRepository   userRepository ;
	
	@RequestMapping(value="/commentaire" ,method=RequestMethod.POST)
	public Commentaire save(@RequestBody Commentaire c,HttpServletRequest httpServletRequest ) {
		HttpSession session=httpServletRequest.getSession(true);
	    SecurityContext securityContext=(SecurityContext) session
			          .getAttribute("SPRING_SECURITY_CONTEXT");
	
	    String login=securityContext.getAuthentication().getName();
	    User user= userRepository.getUser(login);	
	    c.setUser(user);
		
		return commentaireMetier.save(c);
	}
	@RequestMapping(value="/commentaire" ,method=RequestMethod.GET)
	public List<Commentaire> findCommentaire() {
		return commentaireMetier.findCommentaire();
	}
	
	@RequestMapping(value="/commentairepublication/{id}" ,method=RequestMethod.GET)
	public List<Commentaire> findCommentaireBypublication( @PathVariable long id) {
		return commentaireMetier.findCommentaireBypublication(id);
	}

	
	
	
	
	
	
	

}
