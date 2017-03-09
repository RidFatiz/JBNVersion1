package org.sid.metier;

import java.util.List;

import org.sid.entities.Candidat;
import org.sid.entities.User;

public interface UserMetier {
	
	public User saveUser(User u);
		
	public void delete(String username);
	
	public User findUser( String username);

	public User getUserByEmail( String email);
	
	public List<User> findAll();

	public void Update(User u, String username);

	public void activerUser(String username);
	public boolean emailExiste();

	
	
	


}
