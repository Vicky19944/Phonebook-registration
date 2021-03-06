package com.registration.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.registration.entity.State;

@Repository
public interface StateRepo extends JpaRepository<State, Integer> {

	public List<State> findAllByCountryId(Integer countryId);
}
