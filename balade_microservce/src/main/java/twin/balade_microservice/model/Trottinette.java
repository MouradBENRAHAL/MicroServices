package twin.balade_microservice.model;

import lombok.Data;

@Data
public class Trottinette {
	private Long id;
	private String name;
	private String  Description;
	private int price;
	
	private String image ;

	CategorieDTO categorie;
	 }

