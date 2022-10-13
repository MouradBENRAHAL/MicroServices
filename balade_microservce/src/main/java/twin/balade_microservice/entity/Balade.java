package twin.balade_microservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
public class Balade {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String description;
	private int nombre;
	private int prix;
	private int distance;
	private String guide_accompagnateur;
	private String disponible;
	
	@JsonIgnore
	@OneToMany(mappedBy="balade",cascade = CascadeType.ALL)
	private List<Participation> participations;
}
