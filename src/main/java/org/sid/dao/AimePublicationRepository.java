package org.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.sid.entities.Aime;
import org.sid.entities.Commentaire;




public  interface AimePublicationRepository  extends JpaRepository<Aime, Long> {
	
	
	@Query("select u from Aime u where u.user.username=:x  AND u.publication.id=:x1 ")
	public Aime  afficher(@Param("x") String username ,  @Param("x1") Long id );
	
   @Query("select a from Aime a where a.publication.id=:x")
	public List<Aime> findAime(@Param("x") long id);
}