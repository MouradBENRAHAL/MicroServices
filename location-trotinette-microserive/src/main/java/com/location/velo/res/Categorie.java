package com.location.velo.res;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idCategorie ;
    private String nomCategorie ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="categorie")
    @JsonIgnore
    private Set<Trottinette> trottinette;
}
