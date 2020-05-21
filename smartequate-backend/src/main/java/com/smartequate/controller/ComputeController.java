package com.smartequate.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartequate.dto.Attributes;
import com.smartequate.dto.Attributes.Cpu;
import com.smartequate.dto.Attributes.Display_type;
import com.smartequate.dto.Attributes.Port;
import com.smartequate.dto.Averages;
import com.smartequate.dto.Phone;
import com.smartequate.dto.Points;
import com.smartequate.dto.Resolution;
import com.smartequate.dto.Sensors;
import com.smartequate.dto.Size;
import com.smartequate.service.AttributesService;
import com.smartequate.service.AveragesService;
import com.smartequate.service.PhoneService;
import com.smartequate.service.PointsService;
import com.smartequate.service.ResolutionService;
import com.smartequate.service.SensorsService;
import com.smartequate.service.SizeService;
import com.smartequate.util.Constants;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ComputeController {
	
	@Autowired
	ResolutionService resolutionService;
	
	@Autowired
	SensorsService sensorsService;
	
	@Autowired
	SizeService sizeService;
	
	@Autowired
	AttributesService attService;
	
	@Autowired
	AveragesService avgService;
	
	@Autowired
	PointsService pointsService;
	
	@Autowired
	PhoneService phoneService;
	
	public static final Logger logger = LoggerFactory.getLogger(ComputeController.class);
	
	@GetMapping("/ping")
	public ResponseEntity<Points> ping() {
	
		Sensors sensors = sensorsService.getSensors(43);
		Size size = sizeService.getSize(76);
		Resolution resolution = resolutionService.getResolution(2);
		
		// ---------------- INSERT ATTRIBUTES ------------------------
		Attributes att = new Attributes();
		att.setSize(size);
		att.setWeight(170);
		att.setSim_tray(2);
		att.setCpu(Cpu.snapdragon_855.toString());
		att.setDisplay_size(Float.parseFloat("6.5"));
		att.setCard_slot(true);
		att.setCamera_a(40);
		att.setCamera_b(12);
		att.setJack(true);
		att.setDisplay_type(Display_type.oled.toString());
		att.setRom(64);
		att.setRam(8);
		att.setResolution(resolution);
		att.setBattery(4000);
		att.setSensors(sensors);
		att.setPort(Port.type_c.toString());
		att.setMultitouch(true);

		attService.saveAttributes(att);
		
		Points points = pointsService.computePoints(att);
		
		List<Phone> phones = phoneService.getAllPhones();
		
		for (Phone phone: phones) {
			Points phonePoints = pointsService.computePoints(phone.getAttributes());
			phone.setPoints(phonePoints);
			phoneService.savePhone(phone);
		}
		
		return new ResponseEntity<Points>(points, HttpStatus.OK);
	}

}
