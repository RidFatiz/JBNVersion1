package org.sid.metier;

import java.util.List;

import org.sid.entities.Candidat;
import org.sid.entities.Competence;

public interface CompetenceMetier {
	
	
	public List<Competence> save(Iterable <Competence>  c);
	public List<Competence> getCompetence();
	public void delete(long idCompetence );
	public void update(long idCompetence,Competence c);
	public List<Competence> Competencebyusername(String username);

}
