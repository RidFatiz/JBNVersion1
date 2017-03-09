package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
public class OffrePostulation implements Serializable {
	
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Temporal(TemporalType.DATE)
	private Date datePostulation;

	 @ManyToOne
	 @JoinColumn(name="candidat_id")
	 private Candidat candidat;
	 
	
	 @ManyToOne
	 @JoinColumn(name="id_offre")
	 private  Offre offre;
	 
	 
	 
	public OffrePostulation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OffrePostulation(Date datePostulation) {
		super();
		this.datePostulation = datePostulation;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}



	public Date getDatePostulation() {
		return datePostulation;
	}


	public void setDatePostulation(Date datePostulation) {
		this.datePostulation = datePostulation;
	}


	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}
	
	public void setOffre(Offre offre) {
		this.offre = offre;
	}
	
	public Offre getOffre() {
		return offre;
	}

	public Candidat getCandidat() {
		return candidat;
	}
	
	
	
	
	
	
	
	
	
	
	

}
