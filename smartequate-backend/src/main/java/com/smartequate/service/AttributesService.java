package com.smartequate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartequate.dto.Attributes;
import com.smartequate.dto.Averages;
import com.smartequate.repository.AttributesRepository;
import com.smartequate.util.Constants;

@Service
public class AttributesService {

	@Autowired
	private AttributesRepository attRepo;
	
	@Autowired
	private AveragesService avgService;
	
	private Constants constants;
	
	
	public void saveAttributes(Attributes att) {
		attRepo.save(att);
		avgService.recalculateAverages();
	}
	
	public List<Attributes> getAllAttributes() {
		List<Attributes> atts = attRepo.findAll();
		
		return atts;
	}
	/*
	 * this.size = size;
		this.weight = weight;
		this.sim_tray = sim_tray;
		this.cpu = cpu;
		this.display_size = display_size;
		this.card_slot = card_slot;
		this.camera_a = camera_a;
		this.camera_b = camera_b;
		this.jack = jack;
		this.display_type = display_type;
		this.rom = rom;
		this.ram = ram;
		this.resolution = resolution;
		this.battery = battery;
		this.sensors = sensors;
		this.port = port;
		this.multitouch = multitouch;*/
	/*public int computePoints(Attributes att) {
		
		Averages averages = avgService.getLastAverages();
		int points = 0;
		
		if (att.getSize().getHeight() == )
		
	}*/
	
	public Attributes getLowestHeight( ) {
		return attRepo.findFirstByOrderBySizeHeightAsc();
	}
	
	public Attributes getHighestHeight( ) {
		return attRepo.findFirstByOrderBySizeHeightDesc();
	}
	
	public Attributes getLowestWeight( ) {
		return attRepo.findFirstByOrderByWeightAsc();
	}
	
	public Attributes getHighestWeight( ) {
		return attRepo.findFirstByOrderByWeightDesc();
	}
	
	public Attributes getLowestDisplaySize( ) {
		return attRepo.findFirstByOrderByDisplaySizeAsc();
	}
	
	public Attributes getHighestDisplaySize( ) {
		return attRepo.findFirstByOrderByDisplaySizeDesc();
	}
	
	public Attributes getLowestCameraA( ) {
		return attRepo.findFirstByOrderByCameraAAsc();
	}
	
	public Attributes getHighestCameraA( ) {
		return attRepo.findFirstByOrderByCameraADesc();
	}
	
	public Attributes getLowestCameraB( ) {
		return attRepo.findFirstByOrderByCameraBAsc();
	}
	
	public Attributes getHighestCameraB( ) {
		return attRepo.findFirstByOrderByCameraBDesc();
	}
	
	public Attributes getLowestRom( ) {
		return attRepo.findFirstByOrderByRomAsc();
	}
	
	public Attributes getHighestRom( ) {
		return attRepo.findFirstByOrderByRomDesc();
	}
	
	public Attributes getLowestRam( ) {
		return attRepo.findFirstByOrderByRamAsc();
	}
	
	public Attributes getHighestRam( ) {
		return attRepo.findFirstByOrderByRamDesc();
	}
	
	public Attributes getLowestBattery( ) {
		return attRepo.findFirstByOrderByBatteryAsc();
	}
	
	public Attributes getHighestBattery( ) {
		return attRepo.findFirstByOrderByBatteryDesc();
	}
}
