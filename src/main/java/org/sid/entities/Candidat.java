package org.sid.entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity

@DiscriminatorValue("Candidat")
public class Candidat extends User{
	
	private String status;
	private String adresse;
	private String TitreCv;
	private String lienCv;
	private String lettreMotiv;
	
	
	@OneToMany(mappedBy="candidat",fetch=FetchType.LAZY)
	private Collection<Competence> competence;
	
	
	
	@OneToMany(mappedBy="candidat",fetch=FetchType.LAZY)
	private Collection<Diplome> diplome;
	
	@OneToMany(mappedBy="candidat",fetch=FetchType.LAZY)
	private Collection<Loisir> loisir;
	
	@OneToMany(mappedBy="candidat",fetch=FetchType.LAZY)
	private Collection<Experience> experience;
	
	@OneToMany(mappedBy="candidat",fetch=FetchType.LAZY)
	private Collection<Langue> langue;
	
	
	
    @ManyToMany
    @JoinTable(	name="candidat_offre" )
    private Collection<Offre> offre;
////////////////////////////////////////////////////////////////////
    @OneToMany(mappedBy="candidat",fetch = FetchType.LAZY)
    private List<OffrePostulation> offrepostulation;
    

    
	

	public Candidat(String email, Date dateCreation, boolean active, boolean visibilité, String role, Genre genre,
		String password, String photo, String username, String nom, String prenom, Date dateNaissance, String tel,
		String nationalite, String pays, String codePostale, String ville, Collection<Publication> publication,
		Collection<Commentaire> commentaire, String status, String adresse, String titreCv, String lienCv,
		String lettreMotiv) {
	super(email, dateCreation, active, visibilité, role, genre, password, photo, username, nom, prenom, dateNaissance,
			tel, nationalite, pays, codePostale, ville, publication, commentaire);
	this.status = status;
	this.adresse = adresse;
	TitreCv = titreCv;
	this.lienCv = lienCv;
	this.lettreMotiv = lettreMotiv;
}

	public Candidat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	@JsonIgnore
	public Collection<Offre> getOffre() {
		return offre;
	}
	
	public void setOffre(Collection<Offre> offre) {
		this.offre = offre;
	}
 
	public Collection<Competence> getCompetence() {
		return competence;
	}
  
	public void setCompetence(Collection<Competence> competence) {
		this.competence = competence;
	}
	public Collection<Diplome> getDiplome() {
		return diplome;
	}
	public void setDiplome(Collection<Diplome> diplome) {
		this.diplome = diplome;
	}
	public Collection<Loisir> getLoisir() {
		return loisir;
	}
	public void setLoisir(Collection<Loisir> loisir) {
		this.loisir = loisir;
	}
	public Collection<Experience> getExperience() {
		return experience;
	}
	public void setExperience(Collection<Experience> experience) {
		this.experience = experience;
	}
	public Collection<Langue> getLangue() {
		return langue;
	}
	public void setLangue(Collection<Langue> langue) {
		this.langue = langue;
	}
	public String getTitreCv() {
		return TitreCv;
	}
	public void setTitreCv(String titreCv) {
		TitreCv = titreCv;
	}
	
	@JsonIgnore
	public List<OffrePostulation> getOffrepostulation() {
		return offrepostulation;
	}
	
	public void setOffrepostulation(List<OffrePostulation> offrepostulation) {
		this.offrepostulation = offrepostulation;
	}


	public String getLienCv() {
		return lienCv;
	}


	public void setLienCv(String lienCv) {
		this.lienCv = lienCv;
	}


	public String getLettreMotiv() {
		return lettreMotiv;
	}


	public void setLettreMotiv(String lettreMotiv) {
		this.lettreMotiv = lettreMotiv;
	}

	
}
