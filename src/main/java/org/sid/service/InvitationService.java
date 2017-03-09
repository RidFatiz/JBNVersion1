package org.sid.service;


import java.io.IOException;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;




import org.sid.dao.UserRepository;
import org.sid.entities.Invitation;
import org.sid.entities.User;


import org.sid.metier.InvitationMetier;


@RestController
public class InvitationService {
	
	@Autowired
	private InvitationMetier invitationMetier;
	@Autowired
	private UserRepository   userRepository ;
	
	
	
	
	
	@RequestMapping(value="/invitation/{recepeteur}" ,method=RequestMethod.POST)
	public Invitation saveInvitation(HttpServletRequest httpServletRequest,HttpServletResponse response ,
			   @RequestBody Invitation p, @PathVariable User recepeteur) {
	    HttpSession session=httpServletRequest.getSession(true);
	    SecurityContext securityContext=(SecurityContext) session
			          .getAttribute("SPRING_SECURITY_CONTEXT");
	
	    String login=securityContext.getAuthentication().getName();
	    User destinataire= userRepository.getUser(login);	   
	    p.setDestinataire(destinataire);
	    p.setRecepteur(recepeteur);
	    
		return invitationMetier.save(p);
	}

	@RequestMapping(value="/invitation/{idInvitation}" ,method=RequestMethod.DELETE)
	public void annulerInvitation(@PathVariable Long idInvitation){ 
		invitationMetier.supprimerInv(idInvitation);	
	}
	@RequestMapping(value="/invitationExist" ,method=RequestMethod.GET)
	public Boolean invitationExist(@RequestParam String userdes,@RequestParam String userrec){ 
		
		Boolean i=invitationMetier.invitationExist(userdes,userrec);
		return i;
	}
	
	@RequestMapping(value="/invitation/send" ,method=RequestMethod.GET)
	public List<Invitation> findInvitationEnvoyer(HttpServletRequest httpServletRequest,
                            HttpServletResponse response) {

            HttpSession session=httpServletRequest.getSession(true);
            SecurityContext securityContext=(SecurityContext) session
		          .getAttribute("SPRING_SECURITY_CONTEXT");

            String username=securityContext.getAuthentication().getName();
		
		    return invitationMetier.findInvEnvoyer(username);
	}
	
	@RequestMapping(value="/invitation/receive" ,method=RequestMethod.GET)
	public List<Invitation> findInvitationRecu( HttpServletRequest httpServletRequest,
                         HttpServletResponse response) {

          HttpSession session=httpServletRequest.getSession(true);
          SecurityContext securityContext=(SecurityContext) session
                    .getAttribute("SPRING_SECURITY_CONTEXT");

          String username=securityContext.getAuthentication().getName();
		  return invitationMetier.findInvRecu(username);
	}
	
	
	
	@RequestMapping(value="/amis" ,method=RequestMethod.GET)
	public List<Invitation> findInvitationAccepter( HttpServletRequest httpServletRequest,
            HttpServletResponse response) {
		
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		
		String login=securityContext.getAuthentication().getName();
		
		return invitationMetier.findInvAccepter(login);
	}
	
	@RequestMapping(value="/amis/accepter/{idInvitation}" ,method=RequestMethod.PUT)
	public void etreAmis(HttpServletResponse response,@PathVariable Long idInvitation) {
		invitationMetier.etreAmis(idInvitation);
		
	}
	
	@RequestMapping(value="/invitation" ,method=RequestMethod.GET)
	public List<Invitation> findall() {
		
		return invitationMetier.find();
	}

	@RequestMapping(value="/amiExist" ,method=RequestMethod.GET)
	public Boolean amiExist(@RequestParam String userdes,@RequestParam String userrec){ 
		
		Boolean i=invitationMetier.estAmis(userdes,userrec);
		return i;
	}

	
	@RequestMapping(value="/invitation/{idInvitation}" ,method=RequestMethod.GET)
	public Invitation findInvitation(@PathVariable Long idInvitation) {
		return invitationMetier.findInvitation(idInvitation);
	}

	
	@RequestMapping(value="/test/{userrec}" ,method=RequestMethod.GET)
	public String test(@PathVariable("userrec") String userrec,
			HttpServletRequest httpServletRequest,HttpServletResponse response) {
	    HttpSession session=httpServletRequest.getSession(true);
	    SecurityContext securityContext=(SecurityContext) session
			          .getAttribute("SPRING_SECURITY_CONTEXT");
	
	    String username=securityContext.getAuthentication().getName();
		
		if(invitationMetier.estAmis(username,userrec)){
			return "Amis";			
		}else if (invitationMetier.invitationEnvoyeeExist(username, userrec)) {
			return "déja envoyé";
		}else if (invitationMetier.invitationRecueExist(username, userrec)) {
			return "Confirmer";	
		}else		
		   return "Inviter";		
	}
	@RequestMapping(value="/countAmis/{username}" ,method=RequestMethod.GET)
	public String CountAmis(String username,HttpServletRequest httpServletRequest) {
		HttpSession session=httpServletRequest.getSession(true);
	    SecurityContext securityContext=(SecurityContext) session
			          .getAttribute("SPRING_SECURITY_CONTEXT");
         username=securityContext.getAuthentication().getName();
         User destinataire= userRepository.getUser(username);	   
		return invitationMetier.CountAmis(username);
	}
	
	
	
	
	
	
	
	
 
}
