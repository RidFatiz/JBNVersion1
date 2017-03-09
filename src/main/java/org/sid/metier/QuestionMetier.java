package org.sid.metier;

import java.util.Date;
import java.util.List;

import org.sid.entities.Question;


public interface QuestionMetier {
	
	
public Question saveQuestion(Question q);
	

public List<Question> getQuestion();

	public void deleteQuestion(Long idQuestion);
	
	
	
	
	
	
	
	
	
	

}
