package com.smartequate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartequate.dto.Phone;
import com.smartequate.repository.PhoneRepository;

@Service
public class PhoneService {

	@Autowired
	private PhoneRepository phoneRepo;
	
	public void savePhone(Phone phone) {
		phoneRepo.save(phone);
	}
	
	public List<Phone> getAllPhones() {
		return phoneRepo.findAll();
	}
}
