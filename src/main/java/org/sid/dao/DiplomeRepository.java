package org.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.sid.entities.Competence;
import org.sid.entities.Diplome;



public interface DiplomeRepository extends JpaRepository<Diplome, Long> {

	
	@Query("select d from Diplome d where d.candidat.username=:x")
	public List<Diplome> findDiplomebyusername(@Param("x") String username );
	
	
	
	
}
