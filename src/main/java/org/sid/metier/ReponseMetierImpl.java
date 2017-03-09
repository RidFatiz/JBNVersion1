package org.sid.metier;

import java.util.Iterator;
import java.util.List;


import org.sid.dao.ReponseRepository;
import org.sid.entities.Reponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReponseMetierImpl  implements ReponseMetier{

	@Autowired
	private ReponseRepository  reponseRepositoy;

	@Override
	public List<Reponse> getReponse() {
		// TODO Auto-generated method stub
		return reponseRepositoy.findAll();
	}

	@Override
	public void deleteReponse(Long idReponse) {
		// TODO Auto-generated method stub
		reponseRepositoy.delete(idReponse);
	}

	@Override
	public List<Reponse> save(List<Reponse> r) {
		// TODO Auto-generated method stub
		return reponseRepositoy.save(r);
	}

	

}
