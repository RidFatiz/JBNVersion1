package org.sid.dao;


import java.util.List;

import org.sid.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository  extends JpaRepository<User, String>{

	
	@Query("select u from User u where u.username=:x")
	public User getUser(@Param("x") String username);
	
	@Query("select u from User u where u.email=:x")
	public User getUserByEmail(@Param("x") String email);
	
	@Query("select  u   from  User u   ")
		
	public List <Object> get();
	
	
	
	
	@Query("select u from User u where u.nom like CONCAT('%',:x, '%')"
			+ " OR u.prenom like CONCAT('%',:x, '%')"
			+ " OR  CONCAT(u.nom ,' ', u.prenom) like CONCAT('%',:x, '%')")
	public User findUserByMC(@Param("x") String motcle);
	
	@Query("UPDATE  User u  SET photo=null WHERE u.username=:x")
	public  void UserPhoto(@Param("x") String username);
	
}
