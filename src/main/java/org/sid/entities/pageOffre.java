package org.sid.entities;

import java.io.Serializable;
import java.util.List;

import org.sid.entities.Offre;



public class pageOffre  implements Serializable{
	
	
	private List<Offre> offres;
	private int page;
	private int TotalPage;
	private int Nombreoffre;
	private int Totaloffre;
	public List<Offre> getOffres() {
		return offres;
	}
	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return TotalPage;
	}
	public void setTotalPage(int totalPage) {
		TotalPage = totalPage;
	}
	public int getNombreoffre() {
		return Nombreoffre;
	}
	public void setNombreoffre(int nombreoffre) {
		Nombreoffre = nombreoffre;
	}
	public int getTotaloffre() {
		return Totaloffre;
	}
	public void setTotaloffre(int totaloffre) {
		Totaloffre = totaloffre;
	}


	
	
	
	
	
	

}
