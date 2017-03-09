package org.sid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sid.entities.FormationEntreprise;
import org.sid.entities.Publication;

public interface PublicationRepository  extends JpaRepository<Publication,Long> {
	
	
	@Query("select u from Publication  u where u.user.username=:x")
	public List<Publication> findParUser(@Param("x") String username);
	
	
	
	@Query("select COUNT(u) from Publication  u where u.user.username=:x")
	
	public String findCountParUser(@Param("x") String username);
	
	@Query("select pu from Publication  pu , Invitation i , User user1  where user1.username=:x  and i.destinataire.username=user1.username and i.accept=true  and i.recepteur.username=pu.user.username")
	public List<Publication> findPublication(@Param("x") String username);
	
	
	
	
	

}
