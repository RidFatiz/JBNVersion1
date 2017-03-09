package org.sid.dao;


	import java.util.List;

	import org.sid.entities.Invitation;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.query.Param;

	public interface InvitationRepository extends JpaRepository<Invitation, Long> {

		
		@Query("select i from Invitation i where i.destinataire.username=:x")
		public List<Invitation> findInvitationEnvoye(@Param("x") String username);
		

		@Query("select i from Invitation i where i.recepteur.username=:x AND i.accept = false")
		public List<Invitation> findInvitationRecu(@Param("x") String username);
		
		
		@Query("select COUNT(i) from Invitation i where i.destinataire.username=:x AND i.accept = true")
		public String findInvitationAmis(@Param("x") String username);
		
		@Query("select i from Invitation i where (i.destinataire.username=:x OR i.recepteur.username=:x) AND i.accept = true")
		public List<Invitation> findInvitationAccepte(@Param("x") String username);
		
		@Query("select i from Invitation i where (i.destinataire.username=:x1 AND i.recepteur.username=:x2) OR (i.destinataire.username=:x2 AND i.recepteur.username=:x1)")
		public Invitation invitationExist(@Param("x1") String usernamedes,@Param("x2") String usernamerec);

		@Query("select i from Invitation i where ((i.destinataire.username=:x1 AND i.recepteur.username=:x2) OR (i.destinataire.username=:x2 AND i.recepteur.username=:x1)) AND i.accept = true")
		public Invitation estAmis(@Param("x1") String usernamedes,@Param("x2") String usernamerec);

		@Query("select i from Invitation i where i.destinataire.username=:x AND i.recepteur.username=:x2")
		public Invitation invitationExistEnvoye(@Param("x") String username,@Param("x2") String usernamerec);
		

		@Query("select i from Invitation i where (i.recepteur.username=:x AND i.destinataire.username=:x2) AND i.accept = false")
		public Invitation invitationExistRecu(@Param("x") String username,@Param("x2") String usernamerec);
		
	}
