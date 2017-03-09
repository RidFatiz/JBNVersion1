package org.sid.metier;

import java.util.List;

import org.sid.entities.Candidat;
import org.sid.entities.Offre;
import org.sid.entities.OffrePostulation;
import org.sid.entities.Recruteur;

public interface PostulationOffreMetier {
	
	
	public   OffrePostulation save(OffrePostulation p);
	public List<OffrePostulation> get();
	public   Boolean ifExist(String username , Long idOffre);
	public List<OffrePostulation> getPostulation(Recruteur r);
	
	public String countPostulation(String username);
}
