package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("emploi")


public class Emploi extends Offre {

	public Emploi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emploi(String description, String lieu, String typecontrant, Date datePostulation, Date dateDebut,
			Date dateFin, String poste, String ProfilSouhaite, String secteur, String ville, String pays) {
		super(description, lieu, typecontrant, datePostulation, dateDebut, dateFin, poste, ProfilSouhaite, secteur, ville,
				pays);
		// TODO Auto-generated constructor stub
	}
	
	

}
