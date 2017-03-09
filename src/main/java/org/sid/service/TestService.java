package org.sid.service;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sid.dao.QuestionRepository;
import org.sid.dao.RecruteurRepository;
import org.sid.dao.ReponseRepository;
import org.sid.entities.Question;
import org.sid.entities.Recruteur;
import org.sid.entities.Reponse;
import org.sid.entities.Test;
import org.sid.metier.QuestionMetier;
import org.sid.metier.ReponseMetier;
import org.sid.metier.TestMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {
	
    @Autowired
	private TestMetier testMetier;
   @Autowired
   private RecruteurRepository recruteurRepository;

    @Autowired
	private QuestionRepository questionMetier;
	@Autowired
	private ReponseMetier reponseMetier;
	@Autowired
	private ReponseRepository reponseMetier1;

	@RequestMapping(value="/test",method=RequestMethod.POST)
	public Test saveTest(@RequestBody Test test,HttpServletRequest httpServletRequest) {
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		String login=securityContext.getAuthentication().getName();
		Recruteur recruteur=recruteurRepository.findbylogin(login);
		test.setRecruteur(recruteur);
		test.setDateTest(new Date());
		 return testMetier.saveTest(test);
		
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public List<Test> getTest() {
		return testMetier.getTest();
	}
	@RequestMapping(value="/TestDelete/{idTest}",method=RequestMethod.DELETE)
	public void deleteTest(@PathVariable Long idTest) {
		
		Test test=testMetier.findTest(idTest);
		
		 List<Question> listquestion=test.getQuestions();
		 
		 for(int i=0;i<=listquestion.size();i++)
		 {		
			 System.out.println("i"+i);
			 List<Reponse> reponses=listquestion.get(i).getReponse();

			
				 reponseMetier1.delete(reponses.get(i));
				 questionMetier.delete(listquestion.get(i));
			     
			 testMetier.deleteTest(test.getIdTest());
	     }
		 
		 
		
	}
	@RequestMapping(value="/testRecruteur",method=RequestMethod.GET)
	public List<Test> find(String username,HttpServletRequest httpServletRequest) {
		HttpSession session=httpServletRequest.getSession(true);
		SecurityContext securityContext=(SecurityContext) session
				          .getAttribute("SPRING_SECURITY_CONTEXT");
		username=securityContext.getAuthentication().getName();
		return testMetier.find(username);
	}
	
	@RequestMapping(value="/testQuestion/{id}",method=RequestMethod.GET)
	public List<Question> find(@PathVariable  Long id) {
		return testMetier.find(id);
	}
	@RequestMapping(value="/testId/{id}",method=RequestMethod.GET)
	public Test findTest(@PathVariable Long id) {
		return testMetier.findTest(id);
	}
	
	
	
	
	
	
	
	
	
	

}