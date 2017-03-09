package org.sid.dao;

import java.util.List;

import org.sid.entities.Publication;
import org.sid.entities.Visite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface VisiteRepository extends JpaRepository<Visite, Long>  {

	@Query("select distinct v.visiteur from Visite  v where v.visitant.username=:x")
	public List<Visite> findVisiteur(@Param("x") String username);
	
	
	@Query("select v.visiteur , v.visitant from Visite  v where v.visitant.username=:x and v.visiteur.username=:x2 ")
	public List<Visite> ExistsVisiteur(@Param("x") String username1,@Param("x2") String username2);
	
	
}
