package org.sid.dao;


import java.util.List;

import org.sid.entities.GroupeUser;
import org.sid.entities.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GroupeUserRepository extends JpaRepository<GroupeUser, Long> {

	
	@Query("select gu from GroupeUser gu where   gu.groupe.admin.username=:x and  gu.accept = false")
	public GroupeUser findInvitationRecu(@Param("x") String username);
	
	@Query("select gu.groupe   from GroupeUser gu   where gu.user.username=:x AND gu.accept=true")
	public List<GroupeUser> finduser(@Param("x") String username);
	
	@Query("select gr from GroupeUser gr where gr.groupe.idGroupe=:x1 AND gr.accept = true and gr.user.username=:x")
	public GroupeUser estAmis(@Param("x1") Long id,@Param("x") String username);
	
	@Query("select gu from GroupeUser gu where  gu.groupe.idGroupe=:x1 and   gu.groupe.admin.username=:x and  gu.accept = false")
	public  List<GroupeUser>  findInvitationRecue(@Param("x") String username,@Param("x1") Long id );
	
	@Query("select gu from GroupeUser gu where gu.groupe.idGroupe=:x1 and  gu.user.username=:x")
	public  GroupeUser existsUser(@Param("x1") Long id , @Param("x") String username );
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
