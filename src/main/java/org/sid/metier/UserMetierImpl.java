package org.sid.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sid.dao.UserRepository;
import org.sid.entities.User;

@Service
public  class UserMetierImpl implements UserMetier {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User u) {
		u.setDateCreation(new Date());
		return userRepository.save(u);
	}
  
	@Override
	@Transactional
	public void Update(User u,String username) {
	 User user=userRepository.findOne(username);
	 
	 user.setDateNaissance(u.getDateNaissance());
	 user.setNationalite(u.getNationalite());
	 user.setPays(u.getPays());
	 user.setTel(u.getTel());
	 user.setVille(u.getVille());
	 user.setGenre(u.getGenre());
	 user.setCodePostale(u.getCodePostale());
	 
     userRepository.saveAndFlush(user);

	}

	@Override
	public void delete(String username) {
		User u=userRepository.findOne(username);
		userRepository.delete(u);
		
	}

	@Override
	public User findUser(String username) {
		// TODO Auto-generated method stub
		return userRepository.getUser(username);
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.getUserByEmail(email);
	}
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
	@Override
	public void activerUser( String username) {
		User u=userRepository.findOne(username);
		 u.setActive(true);
		 userRepository.saveAndFlush(u);
	}

	@Override
	public boolean emailExiste() {
		return false;
	}

	

	

	
	
	
}
