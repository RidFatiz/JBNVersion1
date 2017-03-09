package org.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.sid.entities.Competence;
import org.sid.entities.Publication;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {
	
	
	@Query("select u from Competence u where u.candidat.username=:x")
	public List<Competence> findCompetencebyUsername(@Param("x") String  username );
}
