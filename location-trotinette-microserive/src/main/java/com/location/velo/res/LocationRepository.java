package com.location.velo.res;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;



public interface LocationRepository extends PagingAndSortingRepository<LocationEntity,Integer>{

	List<LocationEntity> findByUserId(int id);
	List<LocationEntity> findByTrottinetteId(int id);
	
	Page<LocationEntity> findAll(Pageable pageable);

}
