package org.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.sid.entities.Langue;

public interface LangueRepository extends JpaRepository<Langue, Long>{

	

	@Query("select u from Langue u where u.candidat.username=:x")
	public List<Langue> findLanguebyusername(@Param("x") String username );
	
}
