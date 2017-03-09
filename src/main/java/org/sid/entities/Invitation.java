package org.sid.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Invitation implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idInvitation;
	
	private boolean accept;
	private Date dateAjout;
	private String reclogin;
	
	@ManyToOne
	@JoinColumn(name="destinataire")
	private User destinataire;
	
	
	@ManyToOne
    @JoinColumn(name = "recepteur")
	private User recepteur;

	public Invitation(boolean accept, Date dateAjout, String reclogin) {
		super();
		this.accept = accept;
		this.dateAjout = dateAjout;
		this.reclogin = reclogin;
	}
	public Invitation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdInvitation() {
		return idInvitation;
	}

	public void setIdInvitation(Long idInvitation) {
		this.idInvitation = idInvitation;
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	
	//@JsonIgnore
	public User getDestinataire() {
		return destinataire;
	}
	@JsonSetter

	public void setDestinataire(User destinataire) {
		this.destinataire = destinataire;
	}
	//@JsonIgnore
	public User getRecepteur() {
		return recepteur;
	}
	@JsonSetter

	public void setRecepteur(User recepteur) {
		this.recepteur = recepteur;
	}

	public String getReclogin() {
		return reclogin;
	}

	public void setReclogin(String reclogin) {
		this.reclogin = reclogin;
	}

	

}

	