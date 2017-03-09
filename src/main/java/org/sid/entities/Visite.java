package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Visite implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="visitant")
	private User visitant;
	@ManyToOne
	@JoinColumn(name="visiteur")
	private User visiteur;
	
	
	public Visite() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getVisitant() {
		return visitant;
	}
	public void setVisitant(User visitant) {
		this.visitant = visitant;
	}
	public User getVisiteur() {
		return visiteur;
	}
	public void setVisiteur(User visiteur) {
		this.visiteur = visiteur;
	}
	
	
	

}
