package org.sid.metier;

import java.util.List;

import org.sid.entities.Invitation;

public interface InvitationMetier {
	
	public Invitation save(Invitation p);
	public List<Invitation> find();
	public List<Invitation> findInvEnvoyer(String username);
	public List<Invitation> findInvRecu(String username);
	public List<Invitation> findInvAccepter(String username);
	public void supprimerInv(Long idInvitation);
	public void etreAmis(Long idInvitation);
	public Boolean invitationExist(String usernamedes ,String usernamerec);
	public Boolean invitationEnvoyeeExist(String usernamedes ,String usernamerec);
	public Boolean invitationRecueExist(String usernamedes ,String usernamerec);
	public Boolean estAmis(String usernamedes ,String usernamerec);
	public Invitation findInvitation(Long idInvitation);
	public String CountAmis(String username);

	
	
	
	
	
	

}
