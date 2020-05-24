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

import com.smartequate.dto.Resolution;
import com.smartequate.service.ResolutionService;

@RestController
@CrossOrigin
@RequestMapping("/resolutions")
public class ResolutionController {

	@Autowired
	ResolutionService resolutionService;
	
	public static final Logger logger = LoggerFactory.getLogger(ResolutionController.class);
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Resolution>> getAllResolutions() {
		List<Resolution> resolutions = resolutionService.getAll();
		
		return new ResponseEntity<List<Resolution>>(resolutions,  HttpStatus.OK);
	}
}
