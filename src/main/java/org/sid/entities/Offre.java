package org.sid.entities;


import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
@Entity
@Inheritance(strategy=InheritanceType.JOINED)

@DiscriminatorColumn(name="type")
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")
@JsonSubTypes({

	   @Type(name="Stage",value=Stage.class),
	  
	   @Type(name="Emploi",value=Emploi.class),
		})
public class Offre implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_Offre")
	private  long id_Offre;
	@Column(columnDefinition = "TEXT")
	private String description;
	private String secteur;
	private String poste;
	private String lieu;
	private String ville;
	private String pays;
	private String  Typecontrant;
	@Column(columnDefinition = "TEXT")
	private String ProfilSouhaite;
	@Temporal(TemporalType.DATE)
	private Date date;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	
	
	
	
	
	/*@ManyToMany
	@JoinTable(	name="offre_Postulation" ,
	           joinColumns = @JoinColumn(name = "idOffre"),
	           inverseJoinColumns = @JoinColumn(name = "id_postulation") )
	private Collection<Postulation> postulation;
	*/
	
	@ManyToOne
	@JoinColumn(name="recruteur_id")
	private Recruteur recruteur;
	
	@OneToMany(mappedBy="offre" ,fetch = FetchType.LAZY)
	private List<OffrePostulation> offrepostulation;
	
	

	public Offre(String description, String lieu, String typecontrant, Date datePostulation,
			Date dateDebut, Date dateFin,String poste,String ProfilSouhaite,String secteur,String ville,String pays) {
		super();
		this.description = description;
		this.ville = ville;
		this.pays = pays;
		
		this.Typecontrant = typecontrant;
		this.date = datePostulation;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.poste= poste;
		this.secteur=secteur;
		this.lieu= lieu;
		
	}

	public Offre() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public long getId_Offre() {
		return id_Offre;
	}

	public void setId_Offre(long id_Offre) {
		this.id_Offre = id_Offre;
	}
	public String getDescription() {
		return description;
	}

	public void  setDescription(String description) {
		this.description = description;
	}

	public String getLieu() {
		return lieu;
	}

	public void  setLieu(String lieu) {
		this.lieu = lieu;
	}

	
	public String getTypecontrant() {
		return Typecontrant;
	}

	public void  setTypecontrant(String typecontrant) {
		this.Typecontrant = typecontrant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
	@Column(name="recruteur")
	public Recruteur getRecruteur() {
		return recruteur;
	}

	public void setRecruteur(Recruteur recruteur) {
		this.recruteur = recruteur;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getProfilSouhaite() {
		return ProfilSouhaite;
	}

	public void  setProfilSouhaite(String profilSouhaite) {
		ProfilSouhaite = profilSouhaite;
	}

	
	@JsonIgnore
	public List<OffrePostulation> getOffrepostulation() {
		return offrepostulation;
	}

	public void setOffrepostulation(List<OffrePostulation> offrepostulation) {
		this.offrepostulation = offrepostulation;
	}

	public String getSecteur() {
		return secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
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
