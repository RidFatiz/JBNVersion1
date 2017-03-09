package org.sid.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.sid.entities.Aime;
import org.sid.entities.User;
import org.sid.metier.AimeMetier;
@Secured(value={"ROLE_Candidat","ROLE_Recruteur"})
@RestController
public class AimePublicationService {
	
	
  @Autowired
	private AimeMetier aimeMetier;

  
  @Autowired
	private UserRepository   userRepository ;
  
  @RequestMapping(value="/aimepublication",method=RequestMethod.POST)
public void save(@RequestBody Aime a, HttpServletRequest httpServletRequest,HttpServletResponse response) {
	  
	  HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		
		String login=securityContext.getAuthentication().getName();
	  
		  User user= userRepository.getUser(login);
		  Aime a1=new Aime();
		  
		  a1.setUser(user);
		  a.setUser(user);
		  
		    aimeMetier.save(a);
			 
		  }	
  
  
  @RequestMapping(value="/aimepublicationAime/{id}",method=RequestMethod.GET)
  public List<Aime> afficherAime(@PathVariable("id") long id) {
	return aimeMetier.afficherAime(id);
}

@RequestMapping(value="/aimepublication/{id}",method=RequestMethod.GET)
public Aime afficher(@PathVariable("id") long id) {
	return aimeMetier.afficher(id);
}
  @RequestMapping(value="/aimepublication/{id}",method=RequestMethod.DELETE)
public void delete( @PathVariable("id")Long id) {
	    
	  aimeMetier.delete(id);
}
@RequestMapping(value="/aime/{id}",method=RequestMethod.GET)

public Aime afficher(String login, @PathVariable("id") Long id,HttpServletRequest httpServletRequest,HttpServletResponse response) {
	
	
	
	HttpSession session=httpServletRequest.getSession(true);
	SecurityContext securityContext=(SecurityContext) session
			          .getAttribute("SPRING_SECURITY_CONTEXT");
	
	 login=securityContext.getAuthentication().getName();
	
     User user= userRepository.getUser(login);
     
     
     Aime a=new Aime();
     a.setUser(user);
   
     
	return aimeMetier.afficher(login,id);
}


@RequestMapping(value="/testaime/{id}",method=RequestMethod.GET)
public String aimer(HttpServletRequest httpServletRequest,@PathVariable("id") Long id,String login) {
	HttpSession session=httpServletRequest.getSession(true);
	SecurityContext securityContext=(SecurityContext) session
			          .getAttribute("SPRING_SECURITY_CONTEXT");
	
	 login=securityContext.getAuthentication().getName();
	

	 if(aimeMetier.aimer(login, id)==true){
		return "Je n'aime pas" ;
			
	      }
	else {
		return "J'aime";
	
	}
}

  
  
  
  
  
  
	
	
	
	
	
	
	
	
}
