package com.smartequate.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartequate.dto.Attributes;
import com.smartequate.dto.Attributes.Cpu;
import com.smartequate.dto.Attributes.Display_type;
import com.smartequate.dto.Attributes.Port;
import com.smartequate.dto.Averages;
import com.smartequate.dto.GenericResponse;
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
@RequestMapping("/compute")
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
	public ResponseEntity<String> ping() {
	
		return new ResponseEntity<String>("pong", HttpStatus.OK);
	}
	
	
	@GetMapping("/points")
	public ResponseEntity<GenericResponse> computePoints() {
		
		avgService.recalculateAverages();
		phoneService.computeAllPoints();
		
		GenericResponse response = new GenericResponse();
		
		response.setStatus("Finished");
		response.setMessage("OK");
		response.setDescription("Process finished succesfully");
		
		return new ResponseEntity<GenericResponse>(response , HttpStatus.OK);
	}

}
