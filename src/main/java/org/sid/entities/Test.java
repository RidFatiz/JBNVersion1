package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Test implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTest;
	
	private String nomTest;
	private String domaineTest;
	private Date dateTest;
	private Date delaiTest;
	
	@ManyToOne
	@JoinColumn(name="id_recruteur")
	private Recruteur recruteur;
	

	@OneToMany(mappedBy="recruteur",fetch=FetchType.LAZY)
	private Collection<Test> test;
	
	@OneToMany(mappedBy="test",fetch=FetchType.LAZY)
	private List<Question> questions;
	
	
	
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Test(Long idTest, String nomTest, String domaineTest, Date dateTest, Date delaiTest) {
		super();
		this.idTest = idTest;
		this.nomTest = nomTest;
		this.domaineTest = domaineTest;
		this.dateTest = dateTest;
		this.delaiTest = delaiTest;
	}
	public Long getIdTest() {
		return idTest;
	}
	public void setIdTest(Long idTest) {
		this.idTest = idTest;
	}
	public String getNomTest() {
		return nomTest;
	}
	public void setNomTest(String nomTest) {
		this.nomTest = nomTest;
	}
	public String getDomaineTest() {
		return domaineTest;
	}
	public void setDomaineTest(String domaineTest) {
		this.domaineTest = domaineTest;
	}
	public Date getDateTest() {
		return dateTest;
	}
	public void setDateTest(Date dateTest) {
		this.dateTest = dateTest;
	}
	public Date getDelaiTest() {
		return delaiTest;
	}
	public void setDelaiTest(Date delaiTest) {
		this.delaiTest = delaiTest;
	}
	public Recruteur getRecruteur() {
		return recruteur;
	}
	public void setRecruteur(Recruteur recruteur) {
		this.recruteur = recruteur;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public Collection<Test> getTest() {
		return test;
	}
	public void setTest(Collection<Test> test) {
		this.test = test;
	}

}
