package org.sid.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.sid.dao.QuestionRepository;
import org.sid.entities.Question;

@Service
public class QuestionMetierImpl implements QuestionMetier {
	@Autowired

	private QuestionRepository questionRepository;
	
	
	@Override
	public Question saveQuestion(Question q) {
		
		return questionRepository.save(q);
	}

	@Override
	public void deleteQuestion(Long idQuestion) {
		Question u=questionRepository.findOne(idQuestion);
		questionRepository.delete(u);
	}
	@Override
	public List<Question> getQuestion() {
		
		return questionRepository.findAll();
	}

}
