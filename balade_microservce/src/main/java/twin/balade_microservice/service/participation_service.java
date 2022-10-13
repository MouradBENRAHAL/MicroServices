package twin.balade_microservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import twin.balade_microservice.entity.Balade;
import twin.balade_microservice.entity.Participation;
import twin.balade_microservice.model.ParticipationDTO;
import twin.balade_microservice.model.Trottinette;
import twin.balade_microservice.repository.Participation_repository;

@Service
public class participation_service {
     
	 @Autowired
	 Participation_repository Participation_repository;
	 @Autowired
	 Balade_service Balade_service;
	 @Autowired
	 private TrottinetteService trottinetteService;
	 
		public Participation add_balade (int velo_id,Long balade_id)
		{
			Participation participation=new Participation();
			Balade balade =Balade_service.find_balade_byid(balade_id);
			participation.setUserid(1);
			participation.setBalade(balade);
			participation.setVeloid(velo_id);
			return Participation_repository.save(participation);
		}
		
		public Participation update_participation(Participation participation)
		{
			return Participation_repository.save(participation);
		}
		
		public List<ParticipationDTO> get_all ()
		{
			List<Participation> participations =Participation_repository.findAll();
			
			List<ParticipationDTO> PDTO = new ArrayList<>();
			
			for(Participation p :participations) {
				Trottinette T = trottinetteService.findTroittinetteById(p.getVeloid());
				ParticipationDTO particip = new ParticipationDTO();
				particip.setId(p.getId());;
				particip.setBalade(p.getBalade());
				particip.setTrottinette(T);;
				PDTO.add(particip);
			}
			return PDTO;
		}
			
		
		
		public ParticipationDTO findbyid (Long id)
		{
			Participation p = Participation_repository.findById(id).orElse(null);
			ParticipationDTO participation= new ParticipationDTO();
			Trottinette T = trottinetteService.findTroittinetteById(p.getVeloid());
			participation.setTrottinette(T);
			participation.setId(p.getId());
			participation.setBalade(p.getBalade());
			return participation;
		}
	
	
}
