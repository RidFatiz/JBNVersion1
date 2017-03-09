package org.sid.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.sid.dao.InvitationRepository;
import org.sid.entities.Invitation;
import org.sid.entities.User;

@Service
public class InvitationMetierImpl  implements InvitationMetier {
	
	@Autowired
	private InvitationRepository invitationRepository ;

	@Override
	public Invitation save(Invitation p) {
		// TODO Auto-generated method stub
		return invitationRepository.save(p);
	}
	
	@Override
	public void supprimerInv(Long idInvitation) {
		invitationRepository.delete(idInvitation);
	}

	@Override
	public List<Invitation> find() {
		// TODO Auto-generated method stub
		return invitationRepository.findAll();
	}

	@Override
	public List<Invitation> findInvEnvoyer(String username) {
		// TODO Auto-generated method stub
		return invitationRepository.findInvitationEnvoye(username);
	}

	@Override
	public List<Invitation> findInvRecu(String username) {
		// TODO Auto-generated method stub
		return invitationRepository.findInvitationRecu(username);
	}

	@Override
	public List<Invitation> findInvAccepter(String username) {
		// TODO Auto-generated method stub
		return invitationRepository.findInvitationAccepte(username);
	}

	@Override
	public void etreAmis(Long idInvitation) {
		Invitation i =invitationRepository.findOne(idInvitation);
		 i.setAccept(true);
		 i.setDateAjout(new Date());
		 invitationRepository.saveAndFlush(i);
	}

	@Override
	public Boolean invitationExist(String usernamedes, String usernamerec) {
		Invitation i=invitationRepository.invitationExist(usernamedes, usernamerec);
		if(i!=null){
			 return true;
		}else{
			return false;
		}
		
	}

	@Override
	public Invitation findInvitation(Long idInvitation) {
		// TODO Auto-generated method stub
		return invitationRepository.findOne(idInvitation);
	}

	@Override
	public Boolean estAmis(String usernamedes, String usernamerec) {
		Invitation i=invitationRepository.estAmis(usernamedes, usernamerec);
		if(i!=null){
			 return true;
		}else{
			return false;
		}
		
	}

	@Override
	public Boolean invitationEnvoyeeExist(String usernamedes, String usernamerec) {
		Invitation i=invitationRepository.invitationExistEnvoye(usernamedes,usernamerec);
		if(i!=null){
			 return true;
		}else{
			return false;
		}
	}

	@Override
	public Boolean invitationRecueExist(String usernamedes, String usernamerec) {
		Invitation i=invitationRepository.invitationExistRecu(usernamedes, usernamerec);
		if(i!=null){
			 return true;
		}else{
			return false;
		}
	}

	@Override
	public String CountAmis(String username) {
		// TODO Auto-generated method stub
		return invitationRepository.findInvitationAmis(username);
	}

	
	
	

}
