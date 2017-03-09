package org.sid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idQuestion;
	private String Nomquestion;
	
	@OneToMany(mappedBy="question",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Reponse> reponse;
		
		
	@ManyToOne
	@JoinColumn(name="test_id")
	private Test test;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(String Nomquestion) {
		super();
		Nomquestion= Nomquestion;
		
	}


	public Long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(Long idQuestion) {
		this.idQuestion = idQuestion;
	}
	public String getNomquestion() {
		return Nomquestion;
	}
	public void setNomquestion(String nomquestion) {
		Nomquestion = nomquestion;
	}
	@JsonIgnore
	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
	public List<Reponse> getReponse() {
		return reponse;
	}
	public void setReponse(List<Reponse> reponse) {
		this.reponse = reponse;
	}

	

	

}
