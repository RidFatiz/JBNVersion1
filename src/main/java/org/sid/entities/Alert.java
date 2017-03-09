package org.sid.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity

public class  Alert  implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String secteur;
	
	private String poste;
	private String region;
	private String  email;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	
	@ManyToOne
	@JoinColumn(name="candidat_id")
	private Candidat candidat;


	public Alert(String secteur, String poste, String region, String email,Date date) {
		super();
		this.secteur = secteur;
		this.poste = poste;
		this.region = region;
		this.email = email;
		
		this.date=date;
	}

	public Alert() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getSecteur() {
		return secteur;
	}




	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}




	public String getPoste() {
		return poste;
	}




	public void setPoste(String poste) {
		this.poste = poste;
	}




	public String getRegion() {
		return region;
	}




	public void setRegion(String region) {
		this.region = region;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}



	public Candidat getCandidat() {
		return candidat;
	}




	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}




	public Date getDate() {
		return date;
	}




	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
