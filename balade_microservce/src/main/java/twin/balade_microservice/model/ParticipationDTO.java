package twin.balade_microservice.model;

import lombok.Data;
import twin.balade_microservice.entity.Balade;

@Data
public class ParticipationDTO {
	private Long id;

	
	private Trottinette trottinette;
	private Balade balade;
}
