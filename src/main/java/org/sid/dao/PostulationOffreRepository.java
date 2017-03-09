package org.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.sid.entities.Candidat;
import org.sid.entities.Offre;
import org.sid.entities.OffrePostulation;
import org.sid.entities.Recruteur;


public interface PostulationOffreRepository extends JpaRepository<OffrePostulation,Long> {
	
	
	
	@Query("select op from  OffrePostulation op where op.candidat.username=:x1 and op.offre.id_Offre=:x2 ")
	public List<OffrePostulation>  postulationIfExist(@Param("x1") String username,@Param("x2") Long idOffre ) ;
	
	
	@Query("select op from  OffrePostulation op where op.offre.recruteur=:x1 ")
	public List<OffrePostulation>  getPostulation(@Param("x1") Recruteur recrteur) ;
	
   @Query("select COUNT(op) from OffrePostulation op  where op.candidat.username=:x")
	
	public String findCountPostulationUser(@Param("x") String username);
	

}
