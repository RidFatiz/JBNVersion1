package org.sid.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.sid.dao.CandidatRepository;
import org.sid.dao.PostulationOffreRepository;
import org.sid.dao.RecruteurRepository;
import org.sid.entities.Candidat;
import org.sid.entities.Offre;
import org.sid.entities.OffrePostulation;
import org.sid.entities.Recruteur;
import org.sid.entities.User;
import org.sid.metier.CandidatMetier;
import org.sid.metier.OffreMetier;
import org.sid.metier.PostulationOffreMetier;
import org.sid.metier.UserMetier;

@RestController
public class PostulationOffreService {
	
	@Autowired
	private PostulationOffreMetier postulationOffreMetier;
	@Autowired
	 private OffreMetier offreMetier;
	@Autowired
	private PostulationOffreRepository postulationOffreRepository;
	@Autowired
	private CandidatRepository candidatRepository;
	
	@Autowired
	private UserMetier userMetier;
	
	@Autowired
	private RecruteurRepository recruteurRepository;
	
	@RequestMapping(value="/postuleoffre",method=RequestMethod.GET)
	public List<OffrePostulation> get() {
		return postulationOffreMetier.get();
	}
	@RequestMapping(value="/postuleoffre",method=RequestMethod.POST)
	public Boolean save(HttpServletRequest httpServletRequest,@RequestParam long idOffre) {
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		
		String login=securityContext.getAuthentication().getName();
		
		Candidat c=candidatRepository.findbylogin(login);
		Offre o =offreMetier.getoffre(idOffre);
        OffrePostulation offrepo=new OffrePostulation();
        if(postulationOffreRepository.postulationIfExist(login, idOffre).isEmpty()){
        	offrepo.setOffre(o);
    		offrepo.setCandidat(c);
    		offrepo.setDatePostulation(new Date());
    	    postulationOffreMetier.save(offrepo);
        	return true;
    	
        }else{
        	return  false;
        	
        }
}

	@RequestMapping(value="/getpostuleoffre",method=RequestMethod.GET)
	public List<OffrePostulation> getPostulation(HttpServletRequest httpServletRequest,Recruteur r){
		
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		
		String login=securityContext.getAuthentication().getName();
		 r=recruteurRepository.findbylogin(login);
		List<Offre> o =r.getOffre();
		return postulationOffreMetier.getPostulation(r);
	}
	
	
	
	@RequestMapping(value="/CountPostulationUser/{username}" ,method=RequestMethod.GET)
	public String countPostulation(String username,HttpServletRequest httpServletRequest) {
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		
	username=securityContext.getAuthentication().getName();
	return postulationOffreMetier.countPostulation(username);
	}
	
	
	
}
