package org.sid.metier;

import java.util.List;

import org.sid.dao.GroupeRepository;
import org.sid.dao.GroupeUserRepository;
import org.sid.entities.GroupeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GroupeUserMetierImpl implements GroupeUserMetier  {
	
	
	@Autowired
	private GroupeUserRepository groupeUserRepository;

	
	@Override
	public GroupeUser save(GroupeUser groupeuser) {
		// TODO Auto-generated method stub
		return groupeUserRepository.save(groupeuser);
	}

	@Override
	public GroupeUser AccepterUser(Long id) {
		GroupeUser groupeuser=groupeUserRepository.findOne(id);
		groupeuser.setAccept(true);
		return groupeUserRepository.save(groupeuser);
	}

	/*@Override
	public List<GroupeUser> findUserGroupe(String username) {
		
	
		
		return groupeUserRepository.finduser(username);
	}*/

	@Override
	public void deleteInvitation(Long id) {
		groupeUserRepository.delete(id);
		
	}

	@Override
	public String   groupeInvitationExists(Long id,String username) {
		// TODO Auto-generated method stub
		
				
				if(groupeUserRepository.existsUser(id,username)==null)
				{
					return "inviter";
				}
				else if(groupeUserRepository.estAmis(id,username)!=null) 
				  { return "amis";}
				
				else if (groupeUserRepository.findInvitationRecu(username)!=null)
				return "déja envoyé";
			
				else 
					return "confirmer";
				
		
	}

	@Override
	public List<GroupeUser> findUserGroupe(String username) {
	
		
		
		return  groupeUserRepository.finduser(username)  ;  
	}

	
	
	
	
	

}
