package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Recommendation implements Serializable  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="destinataire")
	private User destinataire;
	
	
	@ManyToOne
    @JoinColumn(name = "recepteur")
	private User recepteur;
	private String contenu;
	@Temporal(TemporalType.DATE)
    private Date dateRecommandation;
    
    
	public Recommendation(String contenu, Date dateRecommandation) {
		super();
		this.contenu = contenu;
		this.dateRecommandation = dateRecommandation;
	}

	public Recommendation() {
		super();
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	
	public User getDestinataire() {
		return destinataire;
	}

	
	public void setDestinataire(User destinataire) {
		this.destinataire = destinataire;
	}

	
	public User getRecepteur() {
		return recepteur;
	}

	public void setRecepteur(User recepteur) {
		this.recepteur = recepteur;
	}


	public String getContenu() {
		return contenu;
	}


	public void setContenu(String contenu) {
		this.contenu = contenu;
	}


	public Date getDateRecommandation() {
		return dateRecommandation;
	}


	public void setDateRecommandation(Date dateRecommandation) {
		this.dateRecommandation = dateRecommandation;
	}
}
