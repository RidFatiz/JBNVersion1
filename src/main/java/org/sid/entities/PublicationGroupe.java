package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
public class PublicationGroupe  implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	private String lien ;
	@Temporal(TemporalType.DATE)
	private Date datePublication;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User  user1 ;
	
	@ManyToOne
	@JoinColumn(name="groupe_id")
	private Groupe groupe1   ;


	
	public PublicationGroupe(String description, String lien, Date datePublication) {
		super();
		this.description = description;
		this.lien = lien;
		this.datePublication = datePublication;
	}
	
	

	public PublicationGroupe() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public User getUser() {
		return user1;
	}

	public void setUser(User user1) {
		this.user1 = user1;
	}
	@JsonIgnore
	public Groupe getGroupe() {
		return groupe1;
	}
	@JsonSetter
	@JsonGetter
	public void setGroupe(Groupe groupe1) {
		this.groupe1 = groupe1;
	}
	
	
	
	
	
	
	

}
