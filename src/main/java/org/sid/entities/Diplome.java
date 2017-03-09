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
public class Diplome  implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDiplome;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin ;
	private String etablissement ;
	private String NiveauEtude;
	private String titreDiplome;
	@Column(columnDefinition = "TEXT")
	private String descriptiondiplome;
	
	@ManyToOne
	@JoinColumn(name="candidat_id")
	private Candidat candidat;
	

	
	public Diplome(Date dateDebut, Date dateFin, String etablissement, String niveauEtude, String titreDiplome,
			String descriptiondiplome) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etablissement = etablissement;
		NiveauEtude = niveauEtude;
		this.titreDiplome = titreDiplome;
		this.descriptiondiplome = descriptiondiplome;
	}
	
	public Diplome() {
		super();
	}


	public Long getIdDiplome() {
		return idDiplome;
	}
	public void setIdDiplome(Long idDiplome) {
		this.idDiplome = idDiplome;
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
	public String getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}
	public String getNiveauEtude() {
		return NiveauEtude;
	}
	public void setNiveauEtude(String niveauEtude) {
		NiveauEtude = niveauEtude;
	}
	public String getTitreDiplome() {
		return titreDiplome;
	}
	public void setTitreDiplome(String titreDiplome) {
		this.titreDiplome = titreDiplome;
	}
	public String getDescriptiondiplome() {
		return descriptiondiplome;
	}
	public void setDescriptiondiplome(String descriptiondiplome) {
		this.descriptiondiplome = descriptiondiplome;
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
