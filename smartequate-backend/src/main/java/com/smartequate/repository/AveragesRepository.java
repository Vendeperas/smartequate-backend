package com.smartequate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.smartequate.dto.Averages;

@Repository
public interface AveragesRepository extends CrudRepository<Averages, Integer>{

	 public Averages findByLast(boolean last);
	
}
