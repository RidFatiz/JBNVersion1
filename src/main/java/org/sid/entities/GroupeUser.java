package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class GroupeUser  implements Serializable  {	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Temporal(TemporalType.DATE)
	private Date date;
	private boolean accept;
	
	 @ManyToOne
	 @JoinColumn(name="groupe_id")
	 private Groupe groupe;
	 
	 @ManyToOne
	 @JoinColumn(name="user_id")
	 private  User user;
	public GroupeUser(Date date, boolean accept) {
		super();
		this.date = date;
		this.accept = accept;
	}
	public GroupeUser() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isAccept() {
		return accept;
	}
	public void setAccept(boolean accept) {
		this.accept = accept;
	}
	@JsonGetter
	@JsonIgnore
	@JsonSetter
	public Groupe getGroupe() {
		return groupe;
	}
	@JsonSetter
	
	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
