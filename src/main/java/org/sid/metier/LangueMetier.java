package org.sid.metier;

import java.util.List;

import org.sid.entities.Experience;
import org.sid.entities.Langue;



public interface LangueMetier {
	
    public List<Langue> save(Iterable <Langue>  l);
    public List<Langue> getLangue();
    public void delete(long id);
    public void Update(Langue l,long id);
    public List<Langue> Languebyusername(String username);	
}
