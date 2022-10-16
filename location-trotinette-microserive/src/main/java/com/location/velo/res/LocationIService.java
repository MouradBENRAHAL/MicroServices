package com.location.velo.res;

import java.util.List;



public interface LocationIService {

	 public LocationEntity addLocation(LocationEntity LE);
		
		public LocationEntity updateLocation(int id,LocationEntity LE);
		
		public boolean deleteLocation(int id);
		
		public LocationEntity getOneLocation(int id);
		
		public List<LocationEntity> getAllLocation();
		
		public List<LocationEntity> getLocationsByUser(int id);
		
		public List<LocationEntity> getLocationsByTrottinette(int id);

		public List<LocationDTO> getListLocations(int page, int limit);
		
		public List<Trottinette> getListTrottinette();
		
		public LocationDTO getLocation(int id);
}
