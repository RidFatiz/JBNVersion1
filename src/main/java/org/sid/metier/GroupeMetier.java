package org.sid.metier;

import java.util.List;

import org.sid.entities.Groupe;
import org.sid.entities.User;

public interface GroupeMetier {
public Groupe Save(Groupe p);
public List<Groupe> find(String username);
public List<Groupe> findAllGroupe();
public void delete(Long id);
public Groupe  findGroupeBynom(String nom);
public Groupe  findGroupeById(Long id);
	
}
