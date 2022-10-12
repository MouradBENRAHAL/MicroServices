package org.esprit.repositorie;

import org.esprit.entite.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategorieRepo extends JpaRepository<Categorie, Integer>{
    public Categorie  findByNomCategorie(String nom);

}
