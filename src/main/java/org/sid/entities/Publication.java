package org.sid.entities;


import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public  class Publication implements Serializable  {
	
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
	private User  user ;
	
	
	@OneToMany(mappedBy="publication",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	private Collection<Commentaire> commentaire;
	@OneToMany(mappedBy="publication",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	private Collection<Aime> aime;
	
	public Publication() {
		super();
		
	}
	
	public Publication(String description, String lien, Date datePublication) {
		super();
		this.description = description;
		this.lien = lien;
		this.datePublication = datePublication;
		
		
	}


	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getDatePublication() {
		return datePublication;
	}


	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
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

	
   
	public User getUser() {
		return user;
	}

   
	public void setUser(User user) {
		this.user = user;
	}


	public Collection<Commentaire> getCommentaire() {
		return commentaire;
	}

	 
	public void setCommentaire(Collection<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}

	
	public Collection<Aime> getAime() {
		return aime;
	}



	public void setAime(Collection<Aime> aime) {
		this.aime = aime;
	}



}

	
	
	
	
	
