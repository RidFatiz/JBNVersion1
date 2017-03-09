package org.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import  org.sid.entities.Commentaire;


public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

	

	@Query("select c from Commentaire c where c.publication.id=:x")
	
	public List<Commentaire> findCommentaire(@Param("x") long id);
	
	
 


}
