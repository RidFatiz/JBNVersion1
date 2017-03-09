package org.sid.entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

@DiscriminatorValue("Recruteur")
public class Recruteur  extends User{
	
	
	private String fonction;
	private String nom_entreprise;
	private String  secteur;
	private String site_entreprise; 
	private String Numero_telephone ;
	private String photoEntrprise;
	private String addresse;
	
	
	@OneToMany(mappedBy="recruteur")
	
	private List<Offre> offre;
	
    @OneToMany(mappedBy="recruteur")
	
	private List<FormationEntreprise> formationentreprise;
	
	
	
	
	public Recruteur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Recruteur(String email, Date dateCreation, boolean active, boolean visibilité, String role, Genre genre,
			String password, String photo, String username, String nom, String prenom, Date dateNaissance, String tel,
			String nationalite, String pays, String codePostale, String ville, Collection<Publication> publication,
			Collection<Commentaire> commentaire, String fonction, String nom_entreprise, String secteur,
			String site_entreprise, String numero_telephone, String photoEntrprise,String addresse) {
		super(email, dateCreation, active, visibilité, role, genre, password, photo, username, nom, prenom,
				dateNaissance, tel, nationalite, pays, codePostale, ville, publication, commentaire);
		this.fonction = fonction;
		this.nom_entreprise = nom_entreprise;
		this.secteur = secteur;
		this.site_entreprise = site_entreprise;
		Numero_telephone = numero_telephone;
		this.photoEntrprise = photoEntrprise;
		this.addresse=addresse;
	}

	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public String getNom_entreprise() {
		return nom_entreprise;
	}
	public void setNom_entreprise(String nom_entreprise) {
		this.nom_entreprise = nom_entreprise;
	}
	public String getSecteur() {
		return secteur;
	}
	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}
	public String getSite_entreprise() {
		return site_entreprise;
	}
	public void setSite_entreprise(String site_entreprise) {
		this.site_entreprise = site_entreprise;
	}
	public String getNumero_telephone() {
		return Numero_telephone;
	}
	public void setNumero_telephone(String numero_telephone) {
		Numero_telephone = numero_telephone;
	}

	public String getPhotoEntrprise() {
		return photoEntrprise;
	}

	public void setPhotoEntrprise(String photoEntrprise) {
		this.photoEntrprise = photoEntrprise;
	}
	@JsonIgnore
	public List<Offre> getOffre() {
		return offre;
	}

	public void setOffre(List<Offre> offre) {
		this.offre = offre;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	@JsonIgnore
	public List<FormationEntreprise> getFormationentreprise() {
		return formationentreprise;
	}

	public void setFormationentreprise(List<FormationEntreprise> formationentreprise) {
		this.formationentreprise = formationentreprise;
	}
	
	
	
}
