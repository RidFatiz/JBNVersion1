package org.sid.dao;






import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.sid.entities.Alert;

import org.sid.entities.Offre;

public interface AlerteRepository  extends JpaRepository<Alert, Long> {
	

	@Query("select a  from Offre  o, Alert a  where  o.poste=a.poste AND o.id_Offre=:x ")
	public List<Alert> RechercheAlertparOffre(@Param("x") Long id_Offre);
	
	@Query("select u from Offre  u, Alert a  where  u.poste=a.poste")
	public Offre RechercheOffreparalerte();
	
	@Query("select a  from  Alert a")
	public Alert Recherchealertes();
	
	
	

}
