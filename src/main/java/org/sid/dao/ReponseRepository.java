package org.sid.dao;


import java.util.List;

import org.sid.entities.FormationEntreprise;
import org.sid.entities.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReponseRepository  extends JpaRepository<Reponse,Long> {
	
	
}
