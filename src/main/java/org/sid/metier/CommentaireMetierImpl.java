package org.sid.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.sid.dao.CommentaireRepository;
import org.sid.entities.Commentaire;


@Service
public class CommentaireMetierImpl implements CommentaireMetier {
	
	
    @Autowired
	private CommentaireRepository commentaireRepository;
	
	
	
	@Override
	public Commentaire save(Commentaire c) {
		// TODO Auto-generated method stub
		return commentaireRepository.save(c);
	}

	@Override
	public List<Commentaire> findCommentaire() {
		// TODO Auto-generated method stub
		return commentaireRepository.findAll();
	}
	@Override
	public List<Commentaire> findCommentaireBypublication(long id) {
		// TODO Auto-generated method stub
		return commentaireRepository.findCommentaire(id);
	}

	

}
