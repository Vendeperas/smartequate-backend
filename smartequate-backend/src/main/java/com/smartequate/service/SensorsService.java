package com.smartequate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartequate.dto.Sensors;
import com.smartequate.repository.SensorsRepository;

@Service
public class SensorsService {

	@Autowired
	SensorsRepository sensorsRepo;
	
	public Sensors getSensors(int id) {
		
		Sensors sensors = sensorsRepo.findById(id);
		
		return sensors;
	}
}
