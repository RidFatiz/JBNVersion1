package org.sid.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sid.dao.ReponseRepository;
import org.sid.entities.Question;
import org.sid.entities.Reponse;
import org.sid.entities.Test;
import org.sid.metier.QuestionMetier;
import org.sid.metier.ReponseMetier;
import org.sid.metier.TestMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionService {
	
	@Autowired
	private QuestionMetier questionMetier;
	@Autowired
	private ReponseMetier reponseMetier;
	@Autowired
	private ReponseRepository reponseMetier1;
	
	@Autowired
	private TestMetier testMetier;
	
	@RequestMapping(value="/question/{test}/{nomquestion}",method=RequestMethod.POST)
	@ResponseBody  void saveQuestion(@PathVariable String nomquestion ,@PathVariable Test test , @RequestBody List<Reponse> r ) {
		
		Question question=new Question();
		question.setTest(test);
		test.setNomTest(test.getNomTest());
		
		question.setNomquestion(nomquestion);
		for(int i=0;i<r.size();i++)
		{
		r.listIterator(i).next().setQuestion(question);
		}
	
	   questionMetier.saveQuestion(question);
		reponseMetier.save(r);
		
	}
	public List<Question> getQuestion() {
		return questionMetier.getQuestion();
	}
	public void deleteQuestion(Long idQuestion) {
		questionMetier.deleteQuestion(idQuestion);
	}
	
	public List<Reponse> getReponse() {
		return reponseMetier.getReponse();
	}
	public void deleteReponse(Long idReponse) {
		reponseMetier.deleteReponse(idReponse);
	}
	
	
	
	
	
	
	

}

