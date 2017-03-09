package org.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.sid.entities.Question;
import org.sid.entities.Test;


public interface TestRepository  extends JpaRepository<Test,Long> {
	@Query("select t from Test t where t.recruteur.username=:x")
	public List<Test> findTestByUser(@Param("x") String username);
	
	
	
	@Query("select distinct  question from Test t , Question question,Reponse reponse  where t.idTest=:x and t.idTest=question.test.idTest ")
	public List<Question> findQuestion(@Param("x") Long id);
}
