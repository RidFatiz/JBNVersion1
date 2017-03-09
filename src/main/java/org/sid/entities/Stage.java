package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Stage")
public class Stage  extends Offre{
	
	
	private String remuneration;

	public Stage() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(String remuneration) {
		this.remuneration = remuneration;
	}
	
	
	
	
	

}
