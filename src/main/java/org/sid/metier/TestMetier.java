package org.sid.metier;


import java.util.List;

import org.sid.entities.Publication;
import org.sid.entities.Question;
import org.sid.entities.Test;


public interface TestMetier {
	
	
     public Test saveTest(Test t);
     public List<Test> find(String username);
     public List<Question> find(Long id );
     public Test findTest(Long id );
	 public List<Test> getTest();
     public void deleteTest(Long idTest);
	
	
	
	
	
	
	
	
	
	

}
