package org.sid.dao;

import java.util.List;

import org.sid.entities.FormationEntreprise;
import org.sid.entities.GroupeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FormationEntrepriseRepository  extends JpaRepository<FormationEntreprise,Long> {
	
	
	
	@Query("select fe    from FormationEntreprise fe   where fe.recruteur.username=:x ")
	public List<FormationEntreprise> findFormation(@Param("x") String username);
	
	
	
	
	@Query("select fe    from FormationEntreprise fe , Invitation i , Candidat c  where c.username=:x  and i.destinataire.username=c.username and i.accept=true  and i.recepteur.username=fe.recruteur.username  ")
	public List<FormationEntreprise> findFormationRecruteurAmis(@Param("x") String username );
	

}
