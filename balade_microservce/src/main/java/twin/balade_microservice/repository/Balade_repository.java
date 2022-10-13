package twin.balade_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import twin.balade_microservice.entity.Balade;


@Repository
public interface Balade_repository extends JpaRepository<Balade, Long>  {

	
}
