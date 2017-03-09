package org.sid.metier;

import java.util.List;

import org.sid.entities.GroupeUser;

public interface GroupeUserMetier {
	
	public GroupeUser save(GroupeUser groupeuser);
	public  GroupeUser AccepterUser(Long id );
	public List<GroupeUser> findUserGroupe(String username);
	public void deleteInvitation(Long id);
	public String  groupeInvitationExists(Long id,String username);
	
	

}
