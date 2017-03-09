package org.sid.metier;

import java.util.List;

import org.sid.entities.Competence;
import org.sid.entities.Diplome;

public interface DiplomeMetier {

public List<Diplome> save(Iterable <Diplome> d);	
public List<Diplome> getDiplome();
public void delete(long id);
public void Update(Diplome d,long id);
public List<Diplome> Diplomebyusername(String username);
}
