package com.smartequate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smartequate.dto.Sensors;

@Repository
public interface SensorsRepository extends CrudRepository<Sensors, Integer>{
	
	public Sensors findById(int id);

}
