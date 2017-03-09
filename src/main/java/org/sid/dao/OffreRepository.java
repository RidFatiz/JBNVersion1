package org.sid.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.sid.entities.Offre;
public interface OffreRepository extends JpaRepository<Offre, Long> {

	@Query("select u from Offre u where u.poste=:x3")
	public Offre findbypost(@Param("x3") String post);
	
	
	@Query("select u from Offre u where u.ville=:x")
	public Offre findbyVille(@Param("x") String ville);
	
	
	@Query("select u from Offre u where u.secteur=:x")
	public Offre findbySecteur(@Param("x") String secteur);
	
/*	@Query("select u from Offre u where u.secteur=:x and u.ville:x1")
	public Offre findbySecteurVille(@Param("x") String secteur, @Param("x1") String ville);
	
	@Query("select u from Offre u where u.secteur=:x and u.poste=:x2")
	public Offre findbySecteurPoste(@Param("x") String secteur,@Param("x2")  String poste);*/
	
	//@Query("select u from Offre u where u.secteur=:x and u.poste=:x2 and u.ville:=x1")
	//public Offre findbySecteurByvilleByPoste(@Param("x") String secteur,@Param("x1") String ville,@Param("x2")  String poste);
	
	
	@Query("select u from Offre u where u.poste like ?1")
	public Offre findbyMotcle();
	
	@Query("select u from Offre u where (u.ville=:x) OR (u.secteur=:x1) OR (u.poste=:x2)  ")
	public Page<Offre> findByOffre1(@Param("x") String ville,@Param("x1") String secteur,@Param("x2") String poste,Pageable pageable);
	
	
	@Query("select u from Offre u where  (u.ville=:x AND u.secteur=:x1) OR  (u.secteur=:x1 AND u.poste=:x2) OR (u.ville=:x AND u.poste=:x2) ")
	public Page<Offre> findByOffre2(@Param("x") String ville,@Param("x1") String secteur,@Param("x2") String poste,Pageable pageable);
	
	
	@Query("select u from Offre u where  u.ville=:x AND u.secteur=:x1 AND u.poste=:x2 ")
	public Page<Offre> findByOffre3(@Param("x") String ville,@Param("x1") String secteur,@Param("x2") String poste,Pageable pageable);
	
	
	
	
	@Query("select u from Offre u where (u.ville=:x OR 1=:x) AND "
			+ "(u.secteur=:x1 OR 1=:x1) AND "
			+ "(u.poste=:x2 OR 1=:x2)")
	public List<Offre> findOffre(@Param("x") String ville,@Param("x1") String secteur,@Param("x2") String poste);
	
	
	@Query("select f from Offre f  ORDER BY f.date DESC ")
	public Page<Offre> findBypage(Offre f,Pageable pageable);
	
	@Query("select f from Offre f  where f.recruteur.username=:x1 ")
	public List<Offre> findOffreByUsername(@Param("x1") String username );
	
	
}
