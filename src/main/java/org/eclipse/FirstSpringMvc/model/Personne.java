package org.eclipse.FirstSpringMvc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "personnes")
public class Personne implements Serializable {
	@Id
	@GeneratedValue
	private Integer num;
	private String nom;
	private String prenom;
	private static final long serialVersionUID = 1L;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.EAGER)
	private List<Adresse> adresses = new ArrayList<Adresse>();
	
	
	
	
	
	public Personne() {
	}

	
	

	public Integer getNum() {
		return num;
	}




	public void setNum(Integer num) {
		this.num = num;
	}




	public List<Adresse> getAdresses() {
		return adresses;
	}




	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}




	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	

	public Personne(Integer num, String nom, String prenom, List<Adresse> adresses) {
		super();
		this.num = num;
		this.nom = nom;
		this.prenom = prenom;
		this.adresses = adresses;
	}




	public Object getIdPersonne() {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Personne> findBYId(Long num2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void savePersonne(Personne personne) {
		// TODO Auto-generated method stub
		
	}
	
}
