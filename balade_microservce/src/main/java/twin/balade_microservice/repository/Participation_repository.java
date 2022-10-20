package twin.balade_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import twin.balade_microservice.entity.Participation;

@Repository
public interface Participation_repository extends JpaRepository<Participation, Long> {

	
}
