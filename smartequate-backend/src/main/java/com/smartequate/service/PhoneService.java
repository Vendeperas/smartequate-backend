package com.smartequate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.smartequate.dto.CustomSearchBody;
import com.smartequate.dto.Phone;
import com.smartequate.dto.Points;
import com.smartequate.repository.PhoneRepository;
import com.smartequate.repository.VoteRepository;

@Service
public class PhoneService {

	@Autowired
	private PhoneRepository phoneRepo;
	
	@Autowired
	private PointsService pointsService;
	
	
	public Phone getPhoneById(int id) {
		return phoneRepo.findById(id);
	}
	
	public void savePhone(Phone phone) {
		phoneRepo.save(phone);
	}
	
	public Page<Phone> getAllPhones(String name, String brand, String cpu, String battery, Pageable page) {
		return phoneRepo.findAll(name, brand,  battery, cpu, page);
	}
	
	public List<Phone> getAll() {
		return phoneRepo.findAll();
	}
	
	public Page<Phone> getAllPageable(
			String name,
			String brand,
			String cpu,
			String battery,
			CustomSearchBody body,
			Pageable page) {
		
		Page<Phone> allPhones = phoneRepo.findAllByName(name,
				brand,
				cpu,
				battery,
				body.getWeight(),
				body.getSim_tray(),
				body.getMinDisplaySize(),
				body.getMaxDisplaySize(),
				body.isCard_slot(),
				body.getCameraA(),
				body.getCameraB(),
				body.isJack(),
				body.getDisplay_type(),
				body.getRom(),
				body.getRam(),
				body.isMultitouch(),
				body.getPort(),
				page);
		return allPhones;
	}
	
	public List<Phone> getMostValued() {
		return phoneRepo.findFirst5ByOrderByPointsTotalPointsDesc();
	}
	
	public List<Phone> getMostVoted() {
		return phoneRepo.findMostVoted();
	}
	
	public void computeAllPoints( ) {
		List<Phone> phones = getAll();
		
		for (Phone phone: phones) {
			Points phonePoints = pointsService.computePoints(phone.getAttributes());
			phone.setPoints(phonePoints);
			savePhone(phone);
		}
	}
}
