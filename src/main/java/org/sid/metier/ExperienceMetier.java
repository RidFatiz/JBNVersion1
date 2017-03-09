package org.sid.metier;

import java.util.List;

import org.sid.entities.Diplome;
import org.sid.entities.Experience;



public interface ExperienceMetier {
	
	
	public List<Experience> save(Iterable <Experience> e);	
	public List<Experience> getExperience();
    public void delete(long id);
    public void Update(Experience e, long id);
    public List<Experience> Experiencebyusername(String username);	
}
