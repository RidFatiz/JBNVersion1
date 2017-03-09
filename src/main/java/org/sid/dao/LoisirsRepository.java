package org.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.sid.entities.Loisir;

public interface LoisirsRepository extends JpaRepository<Loisir, Long>  {

	@Query("select u from Loisir u where u.candidat.username=:x")
	public List<Loisir> findloisirbyusername(@Param("x") String username );
	
	
	
	
}
