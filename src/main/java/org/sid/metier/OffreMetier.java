package org.sid.metier;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.sid.entities.Offre;
import org.sid.entities.pageOffre;

public interface OffreMetier {
	
public Offre save(Offre f);
public void delete(long id);
public pageOffre listoffre(int page,int size);
public Offre getoffre(long id);
public Offre getOffrePost(String poste);
public void update(long id,Offre f);
public Offre findbyville( String ville);
public Offre findbySecteur( String secteur);
public pageOffre getOffre1(String ville,String secteur ,String poste,int page,int size);
public pageOffre getOffre2(String ville,String secteur ,String poste,int page,int size);

public pageOffre getOffre3(String ville,String secteur ,String poste,int page,int size);

public List<Offre> findOffre(String ville,String secteur ,String poste);



public List<Offre> findOffreByUsername(String username);

}
