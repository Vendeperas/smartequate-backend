package com.smartequate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.smartequate.dto.Phone;
import com.smartequate.repository.PhoneRepository;
import com.smartequate.repository.VoteRepository;

@Service
public class PhoneService {

	@Autowired
	private PhoneRepository phoneRepo;
	
	@Autowired
	private VoteRepository voteRepo;
	
	public void savePhone(Phone phone) {
		phoneRepo.save(phone);
	}
	
	public List<Phone> getAllPhones() {
		return phoneRepo.findAll();
	}
	
	public Page<Phone> getAllPageable(
			String name,
			String brand,
			String cpu,
			Pageable page) {
		Page<Phone> allPhones = phoneRepo.findAllByName(name, brand, cpu,page);
		return allPhones;
	}
	
	public List<Phone> getMostValued() {
		return phoneRepo.findFirst5ByOrderByPointsTotalPointsDesc();
	}
	
	public List<Phone> getMostVoted() {
		return phoneRepo.findMostVoted();
	}
}
