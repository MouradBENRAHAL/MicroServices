package org.esprit.entite;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Categorie {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idCategorie ;
    private String nomCategorie ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="categorie")
    @JsonIgnore
    private Set<Trottinette> trottinette;
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public Set<Trottinette> getTrottinette() {
		return trottinette;
	}
	public void setTrottinette(Set<Trottinette> trottinette) {
		this.trottinette = trottinette;
	}
	
	
	public Categorie(int idCategorie, String nomCategorie, Set<Trottinette> trottinette) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.trottinette = trottinette;
	}
	
	public Categorie() {
	
	}
	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nomCategorie=" + nomCategorie + ", trottinette="
				+ trottinette + ", getIdCategorie()=" + getIdCategorie() + ", getNomCategorie()=" + getNomCategorie()
				+ ", getTrottinette()=" + getTrottinette() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
    
    

    	
}
