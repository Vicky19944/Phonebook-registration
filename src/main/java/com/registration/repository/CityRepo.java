package com.registration.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registration.entity.City;

@Repository
public interface CityRepo extends JpaRepository<City, Integer> {

	public List<City> findAllByStateId(Integer stateId);
	
}
