package com.smartequate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartequate.dto.Sensors;
import com.smartequate.dto.Size;
import com.smartequate.repository.SizeRepository;

@Service
public class SizeService {

	@Autowired
	SizeRepository sizeRepo;
	
	public Size getSize(int id) {
		
		Size size = sizeRepo.findById(id);
		
		return size;
	}
}
