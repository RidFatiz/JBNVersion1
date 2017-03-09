package org.sid.service;

import java.io.Serializable;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import org.sid.metier.SimpleMessage;
import org.sid.dao.AlerteRepository;
import org.sid.dao.CandidatRepository;
import org.sid.dao.OffreRepository;
import org.sid.entities.Alert;
import org.sid.entities.Candidat;
import org.sid.entities.Offre;
import org.sid.metier.AlertMetier;

@Secured(value={"ROLE_Candidat","ROLE_Recruteur"})
@RestController 
public class AlertService {
	@Autowired
	private AlertMetier  alertMetier;
	@Autowired
	private   SimpleMessage simpleMessage;
	
	@Autowired
	private OffreRepository offreRepository;
	
	@Autowired
	private CandidatRepository candidatRepository;  
	
	@RequestMapping(value="/alert",method=RequestMethod.POST)
	public Alert save(HttpServletRequest httpServletRequest,@RequestBody  Alert a) throws Exception {
		 
		
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		
		String login=securityContext.getAuthentication().getName();
		Candidat c=candidatRepository.findbylogin(login);
		
		
		
		a.setCandidat(c);
		
		a.setEmail(c.getEmail());		
		
		String body = "<h1>bonjour, veuillez confirmer votre inscription à JobNetwork</h1><br/>";
			      
	 
		simpleMessage.send(c.getEmail(), "Mail de confirmation",body );
		
		return alertMetier.save(a);
	}

	
	
	
	@RequestMapping(value="/alertParOffre",method=RequestMethod.GET)

	public List<Alert> rechercherAlerParOffre() {
		return alertMetier.rechercherAlerParOffre(null);
	}

	/*@RequestMapping(value="/OffreParalert",method=RequestMethod.GET)

	public List<Offre> rechercherOffreParAlert() {
		return alertMetier.rechercherOffreParAlert();
	}

	
	*/
	
	
}
