package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Langue implements Serializable{
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idLangue;
	
	@Enumerated(EnumType.STRING)
	private TypeLangue niveau;
	
	private String langue;
	
	@ManyToOne
	@JoinColumn(name="candidat_id")
	private Candidat candidat;
	
	

	
	public Langue(TypeLangue niveau, String langue) {
		super();
		this.niveau = niveau;
		this.langue = langue;
	}
	public Langue() {
		super();
	}
	public long getIdLangue() {
		return idLangue;
	}
	public void setIdLangue(long idLangue) {
		this.idLangue = idLangue;
	}
	public TypeLangue getNiveau() {
		return niveau;
	}
	public void setNiveau(TypeLangue niveau) {
		this.niveau = niveau;
	}
	public String  getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
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
