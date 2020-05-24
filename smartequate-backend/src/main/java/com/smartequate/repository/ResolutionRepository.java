package com.smartequate.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smartequate.dto.Resolution;


@Repository
public interface ResolutionRepository extends CrudRepository<Resolution, Integer>{

	 public Resolution findById(int id);
	 
	 public List<Resolution> findAll();
	
	 public Resolution findByWidthAndHeight(int width, int height);
}
