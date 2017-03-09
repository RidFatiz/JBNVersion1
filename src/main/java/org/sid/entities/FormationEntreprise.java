package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity 
public class FormationEntreprise  implements Serializable{

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idFormation;
private String description ;
private Date Horaire;
private String prix;
private String lieu;
private String ville;
private String pays;	


@ManyToOne 
@JoinColumn(name="reruteur_id")
private Recruteur recruteur;
	

@ManyToMany
@JoinTable(	name="candidat_formation" )
private Collection<Candidat> candidat;





public FormationEntreprise(String description, Date horaire, String prix, String lieu, String ville, String pays) {
	super();
	this.description = description;
	Horaire = horaire;
	this.prix = prix;
	this.lieu = lieu;
	this.ville = ville;
	this.pays = pays;
}


public FormationEntreprise() {
	super();
}


public Long getIdFormation() {
	return idFormation;
}


public void setIdFormation(Long idFormation) {
	this.idFormation = idFormation;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public Date getHoraire() {
	return Horaire;
}


public void setHoraire(Date horaire) {
	Horaire = horaire;
}


public String getPrix() {
	return prix;
}


public void setPrix(String prix) {
	this.prix = prix;
}


public String getLieu() {
	return lieu;
}


public void setLieu(String lieu) {
	this.lieu = lieu;
}


public Recruteur getRecruteur() {
	return recruteur;
}


public void setRecruteur(Recruteur recruteur) {
	this.recruteur = recruteur;
}


public Collection<Candidat> getCandidat() {
	return candidat;
}


public void setCandidat(Collection<Candidat> candidat) {
	this.candidat = candidat;
}


public String getVille() {
	return ville;
}


public void setVille(String ville) {
	this.ville = ville;
}


public String getPays() {
	return pays;
}


public void setPays(String pays) {
	this.pays = pays;
}
	
	






	
	

}
