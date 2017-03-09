package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


@Entity
public class  Groupe  implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idGroupe;
	private String nomGroupe;
	private String typeGroupe;
	@Temporal(TemporalType.DATE)
	private Date dateCretion;
	
	@ManyToOne
	@JoinColumn(name="admin")
	private User admin;
	
	@OneToMany(mappedBy="groupe",fetch = FetchType. LAZY)
    private Collection<GroupeUser> groupeuser;
	
	@OneToMany(mappedBy="groupe1",fetch = FetchType. LAZY)
    private Collection<PublicationGroupe> publicationgroupe;
	
	public Groupe(Date dateCretion, String nomGroupe, String typeGroupe) {
		super();
		this.dateCretion = dateCretion;
		this.nomGroupe = nomGroupe;
		this.typeGroupe = typeGroupe;
	}
	public Groupe() {
		super();
	}


	public Long getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(Long idGroupe) {
		this.idGroupe = idGroupe;
	}

	public Date getDateCretion() {
		return dateCretion;
	}

	public void setDateCretion(Date dateCretion) {
		this.dateCretion = dateCretion;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public String getTypeGroupe() {
		return typeGroupe;
	}

	public void setTypeGroupe(String typeGroupe) {
		this.typeGroupe = typeGroupe;
	}
	

	public Collection<GroupeUser> getGroupeuser() {
		return groupeuser;
	}
	
	public void setGroupeuser(Collection<GroupeUser> groupeuser) {
		this.groupeuser = groupeuser;
	}

	public Collection<PublicationGroupe> getPublicationgroupe() {
		return publicationgroupe;
	}
	
	public void setPublicationgroupe(Collection<PublicationGroupe> publicationgroupe) {
		this.publicationgroupe = publicationgroupe;
	}
	
	
	
	
	
}

