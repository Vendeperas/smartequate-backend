package com.smartequate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartequate.dto.Resolution;
import com.smartequate.repository.ResolutionRepository;

@Service
public class ResolutionService {
	
	@Autowired
	ResolutionRepository resolutionRepo;
	
	public Resolution getResolution(int id) {
		
		Resolution resolution = resolutionRepo.findById(id);
		
		return resolution;
	}
}
