package org.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sid.entities.Candidat;


public interface CandidatRepository  extends JpaRepository<Candidat, String> {

	@Query("select u from Candidat u where u.username=:x")
	public Candidat findbylogin( @Param("x") String username );
	
	
}
