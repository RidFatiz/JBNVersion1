package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Competence implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

    private long idCompetence;
	@Column(columnDefinition = "TEXT")
	private String description_Competence;
	private String typeCompetence;
	
	@ManyToOne
	@JoinColumn(name="candidat_id")
	private Candidat candidat;
	
	
	public Competence(String description_Competence, String typeCompetence) {
		super();
		this.description_Competence = description_Competence;
		this.typeCompetence = typeCompetence;
	}
	
	
	public Competence() {
		super();
	}


	public long getIdCompetence() {
		return idCompetence;
	}


	public void setIdCompetence(long idCompetence) {
		this.idCompetence = idCompetence;
	}


	public String getDescription_Competence() {
		return description_Competence;
	}


	public void setDescription_Competence(String description_Competence) {
		this.description_Competence = description_Competence;
	}


	public String getTypeCompetence() {
		return typeCompetence;
	}


	public void setTypeCompetence(String typeCompetence) {
		this.typeCompetence = typeCompetence;
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
