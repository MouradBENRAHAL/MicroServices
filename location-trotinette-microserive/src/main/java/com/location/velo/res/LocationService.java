package com.location.velo.res;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;



@Service
public class LocationService implements LocationIService{

	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private TrottinetteService trottinetteService;
	
	@Override
	public LocationEntity addLocation(LocationEntity LE) {
		return locationRepository.save(LE);
	}

	@Override
	public LocationEntity updateLocation(int id, LocationEntity LE) {
		if(locationRepository.findById(id).isPresent()){
			LocationEntity existingLocation=locationRepository.findById(id).get();
			existingLocation.setDateStart(LE.getDateStart());
			existingLocation.setDateEnd(LE.getDateEnd());
			existingLocation.setUserId(LE.getUserId());
			existingLocation.setTrottinetteId(LE.getTrottinetteId());
			

			
			return locationRepository.save(existingLocation);
		}
		else return null;	}

	@Override
	public boolean deleteLocation(int id) {
		if(locationRepository.findById(id).isPresent()){
			locationRepository.deleteById(id);
			return true;
		}
		return false;	
		}

	@Override
	public LocationEntity getOneLocation(int id) {
		return locationRepository.findById(id).get();
	}

	@Override
	public List<LocationEntity> getAllLocation() {
		return null;
	}

	@Override
	public List<LocationEntity> getLocationsByUser(int id) {
		return locationRepository.findByUserId(id);

	}

	@Override
	public List<LocationEntity> getLocationsByTrottinette(int id) {
		return locationRepository.findByTrottinetteId(id);

	}

	@Override
	public List<LocationDTO> getListLocations(int page, int limit) {
		PageRequest pageable = PageRequest.of(page, limit);

		List<LocationEntity> LE =locationRepository.findAll(pageable).getContent();
		List<LocationDTO> LDTO = new ArrayList<>();
		
		for(LocationEntity l :LE) {
			Trottinette T = trottinetteService.findTroittinetteById(l.getTrottinetteId());
			LocationDTO ld = new LocationDTO();
			ld.setDateStart(l.getDateStart());
			ld.setDateEnd(l.getDateEnd());
			ld.setId(l.getId());
			ld.setUserId(l.getUserId());
			ld.setTrottinette(T);
			ld.setTotalElement(locationRepository.findAll(pageable).getTotalElements());
			LDTO.add(ld);
		}
		return LDTO;
	}
	
	@Override
	public List<Trottinette> getListTrottinette() {
		List<Trottinette> T = trottinetteService.findAllTroittinette();

	return T;
	}

	@Override
	public LocationDTO getLocation(int id) {
		LocationDTO ld = new LocationDTO();
		LocationEntity l = locationRepository.findById(id).orElse(null);
		Trottinette T = trottinetteService.findTroittinetteById(l.getTrottinetteId());
		ld.setDateStart(l.getDateStart());
		ld.setDateEnd(l.getDateEnd());
		ld.setId(l.getId());
		ld.setUserId(l.getUserId());
		ld.setTrottinette(T);
		
		return ld;
	}

}
