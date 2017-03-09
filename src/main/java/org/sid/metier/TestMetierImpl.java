package org.sid.metier;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.sid.dao.TestRepository;
import org.sid.entities.Question;
import org.sid.entities.Reponse;
import org.sid.entities.Test;

@Service
public class TestMetierImpl implements TestMetier {
	@Autowired

	private TestRepository testRepository;
	
	
	@Override
	public Test saveTest(Test t) {
		
		return testRepository.save(t);
	}

	@Override
	public void deleteTest(Long idTest) {
		
		testRepository.delete(idTest);
	}
	@Override
	public List<Test> getTest() {
		return testRepository.findAll();
	}

	@Override
	public List<Test> find(String username) {
		// TODO Auto-generated method stub
		return testRepository.findTestByUser(username);
	}

	@Override
	public List<Question> find(Long id) {
		
		Test test=testRepository.findOne(id);
		
		List<Question> question=test.getQuestions();
		System.out.println(question);
		
		for(int i=0;i<question.size();i++){
			question.listIterator(i).next().getReponse();
			}    
		return  testRepository.findQuestion(test.getIdTest());
	}

	@Override
	public Test findTest(Long id) {
		// TODO Auto-generated method stub
		return testRepository.findOne(id);
	}

}
