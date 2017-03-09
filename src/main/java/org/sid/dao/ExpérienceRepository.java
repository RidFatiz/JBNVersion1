package org.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.sid.entities.Experience;



public interface ExpérienceRepository extends JpaRepository<Experience, Long>  {
	
	
	
	@Query("select u from Experience u where u.candidat.username=:x")
	public List<Experience> findExperiencebyusername(@Param("x") String username );
	

}
