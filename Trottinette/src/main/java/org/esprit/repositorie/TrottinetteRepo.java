package org.esprit.repositorie;

import org.esprit.entite.Trottinette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrottinetteRepo extends JpaRepository<Trottinette, Integer> {

}
