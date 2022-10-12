package org.esprit.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;



@Entity
public class Trottinette {
	

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String name;
	private String  description;
	private int price;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image ;
	
	 @ManyToOne
	    Categorie categorie;
	
	
	 public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	@Override
		public String toString() {
			return "Trottinette [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
					+ ", image=" + image + ", categorie=" + categorie + ", getClass()=" + getClass() + ", hashCode()="
					+ hashCode() + ", toString()=" + super.toString() + "]";
		}


	public Trottinette(int id, String name, String description, int price, String image, Categorie categorie) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.categorie = categorie;
	}


	public Trottinette() {
	}
	 
	 
	
	
		
}
