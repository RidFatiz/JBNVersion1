package org.sid.service;

import java.util.List;

import org.sid.entities.Question;
import org.sid.entities.Reponse;
import org.sid.metier.ReponseMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReponseService {
	
	@Autowired
	private ReponseMetier  reponseMetier ;
	
	@RequestMapping(value="/reponse",method=RequestMethod.POST)
	public List<Reponse> saveReponse(@RequestBody  List <Reponse> reponse) {
		return reponseMetier.save(reponse);
	}
	
	@RequestMapping(value="/reponse",method=RequestMethod.GET)
	public List<Reponse> getReponse() {
		return reponseMetier.getReponse();
	}
	@RequestMapping(value="/reponse/{id}",method=RequestMethod.DELETE)
	public void deleteReponse(@PathVariable Long idReponse) {
		reponseMetier.deleteReponse(idReponse);
	}	
}
