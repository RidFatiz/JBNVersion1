package org.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sid.entities.Candidat;
import org.sid.entities.Recruteur;



public interface RecruteurRepository  extends JpaRepository<Recruteur, String>{
	
	
	@Query("select u from Recruteur u where u.username=:x")
	public  Recruteur  findbylogin( @Param("x") String username );

}
