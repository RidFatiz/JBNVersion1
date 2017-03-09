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
public class Experience implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idExperience;
	@Temporal(TemporalType.DATE)
	private Date dateDebut ;
	@Temporal(TemporalType.DATE)
	private Date dateFin ;
	private String lieu ;
	private String poste;
	private String type;
	@Column(columnDefinition = "TEXT")
	private String description_experience;
	
	@ManyToOne
	@JoinColumn(name="candidat_id")
	private Candidat candidat;
	

	public Experience(Date dateDebut, Date dateFin, String lieu, String poste, String type,
			String description_experience) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.lieu = lieu;
		this.poste = poste;
		this.type = type;
		this.description_experience = description_experience;
	}
	
	
	public Experience() {
		super();
	}

	
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription_expérience() {
		return description_experience;
	}
	public void setDescription_expérience(String description_experience) {
		this.description_experience = description_experience;
	}


	public long getIdExperience() {
		return idExperience;
	}


	public void setIdExperience(long idExperience) {
		this.idExperience = idExperience;
	}
	@JsonIgnore
	public Candidat getcandidat() {
		return candidat;
	}
	@JsonGetter
	@JsonSetter
	public void setcandidat(Candidat candidat) {
		this.candidat = candidat;
	}



}
