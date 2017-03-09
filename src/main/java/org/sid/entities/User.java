package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import org.sid.entities.Commentaire;
import org.sid.entities.Genre;
import org.sid.entities.Publication;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
@Table(name="users")

@Inheritance(strategy=InheritanceType.JOINED)

@DiscriminatorColumn(name="typeUser")

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="typeUser")

@JsonSubTypes({

	   @Type(name="Candidat",value=Candidat.class),
	   @Type(name="Recruteur",value=Recruteur.class),
	
		})
public class User  implements Serializable{

	
	@Email
	@Column(unique = true)
	
	private String  email;
	private Date   dateCreation; 
	private boolean  active;
	private boolean  visibilité;
	
	private String role;
	
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	 @NotNull
	private String  password;
	
	
	private String photo;
	@Id
	@Column(unique = true)

	@Size(min=6)
	private String  username;
	
	
	private String nom  ;

	private String prenom;
	
	@Temporal(TemporalType.DATE)
	//@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateNaissance;
	
	
	private String tel;
	
	private String nationalite;
	
	private String pays;
	
	private String codePostale;
	
	private String ville;
	
	
	
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY)
	private Collection<Publication> publication;
	
	@OneToMany(mappedBy="user1",fetch = FetchType.LAZY)
	private Collection<PublicationGroupe> publicationgroupe;
	
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY)
	private Collection<Commentaire> commentaire;
	
	@OneToMany(mappedBy="recepteur",fetch = FetchType.LAZY)
	private Collection<Recommendation> recepteur1;
	
	@OneToMany(mappedBy="destinataire",fetch = FetchType.LAZY)
	private Collection<Recommendation> destinataire1;
	
	 @OneToMany(mappedBy="user",fetch = FetchType.LAZY)
	    private Collection<GroupeUser> groupeuser;
	    
	

	public User() {
		super();
	}

	public User(String email, Date dateCreation, boolean active, boolean visibilité, String role, Genre genre,
			String password, String photo, String username, String nom, String prenom, Date dateNaissance, String tel,
			String nationalite, String pays, String codePostale, String ville, Collection<Publication> publication,
			Collection<Commentaire> commentaire) {
		super();
		this.email = email;
		this.dateCreation = dateCreation;
		this.active = active;
		this.visibilité = visibilité;
		this.role = role;
		this.genre = genre;
		this.password = password;
		this.photo = photo;
		this.username = username;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.tel = tel;
		this.nationalite = nationalite;
		this.pays = pays;
		this.codePostale = codePostale;
		this.ville = ville;
		this.publication = publication;
		this.commentaire = commentaire;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@JsonProperty(value="Nom")
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	

	public String getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}

	
	

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isVisibilité() {
		return visibilité;
	}
	public void setVisibilité(boolean visibilité) {
		this.visibilité = visibilité;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	
	
	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@JsonIgnore
	public Collection<Publication> getPublication() {
		return publication;
	}
	@JsonSetter
	@JsonGetter
	public void setPublication(Collection<Publication> publication) {
		this.publication = publication;
	}
	@JsonIgnore

	public Collection<Commentaire> getCommentaire() {
		return commentaire;
	}
	@JsonGetter
	@JsonSetter
	public void setCommentaire(Collection<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}
	@JsonIgnore
	public Collection<Recommendation> getRecepteur1() {
		return recepteur1;
	}

	public void setRecepteur1(Collection<Recommendation> recepteur1) {
		this.recepteur1 = recepteur1;
	}
	@JsonIgnore
	public Collection<Recommendation> getDestinataire1() {
		return destinataire1;
	}

	public void setDestinataire1(Collection<Recommendation> destinataire1) {
		this.destinataire1 = destinataire1;
	}
	@JsonIgnore
	public Collection<GroupeUser> getGroupeuser() {
		return groupeuser;
	}
	
	public void setGroupeuser(Collection<GroupeUser> groupeuser) {
		this.groupeuser = groupeuser;
	}
@JsonIgnore
	public Collection<PublicationGroupe> getPublicationgroupe() {
		return publicationgroupe;
	}
	@JsonSetter
	@JsonGetter
	public void setPublicationgroupe(Collection<PublicationGroupe> publicationgroupe) {
		this.publicationgroupe = publicationgroupe;
	}
	
	
	
	
	
}

