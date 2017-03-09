package org.sid.entities;

import java.io.Serializable;

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
public class Loisir implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLoisir;
	
	private String typeLoisir;
	private String description;



	@ManyToOne
	@JoinColumn(name="candidat_id")
	private Candidat candidat;
	
	
	
	
	public Loisir() {
		super();
	}
	
	
	public Loisir(String typeLoisir, String description) {
		super();
		this.typeLoisir = typeLoisir;
		this.description = description;
	}


	public String getTypeLoisir() {
		return typeLoisir;
	}

	public void setTypeLoisir(String typeLoisir) {
		this.typeLoisir = typeLoisir;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public Long getIdLoisir() {
		return idLoisir;
	}
    public void setIdLoisir(Long idLoisir) {
		this.idLoisir = idLoisir;
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
