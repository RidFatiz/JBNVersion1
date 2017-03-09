package org.sid.dao;


import java.util.List;

import org.sid.entities.Groupe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {
	
	@Query("select g from Groupe g where g.admin.username=:x")
	public List<Groupe> findGroupeByUser(@Param("x") String username);
	
	@Query("select g from Groupe g   where g.nomGroupe=:x ")
	public Groupe findGroupeBynom(@Param("x") String nom);
	
	
	
	
	

	
	
}
