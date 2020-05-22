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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartequate.dto.Phone;
import com.smartequate.service.PhoneService;

@RestController
@CrossOrigin
@RequestMapping("/phones")
public class PhoneController {

	@Autowired
	PhoneService phoneService;
	
	public static final Logger logger = LoggerFactory.getLogger(ComputeController.class);
	
	@GetMapping("/list")
	public ResponseEntity<Page<Phone>> filterPhoneList(
			@RequestParam(name="page") int page,
			@RequestParam(name="size") int size,
			@RequestParam(name="name", required = false) String name,
			@RequestParam(name="brand", required = false) String brand,
			@RequestParam(name="cpu", required = false) String cpu
			) {
		
		Page<Phone> phonePage = phoneService.getAllPageable(name,brand,cpu,PageRequest.of(page, size));
		
		return new ResponseEntity<Page<Phone>>(phonePage, HttpStatus.OK);
	}
	
	@GetMapping("/mostValued")
	public ResponseEntity<List<Phone>> mostValued() {
		
		List<Phone> list = phoneService.getMostValued();
		
		return new ResponseEntity<List<Phone>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/mostVoted")
	public ResponseEntity<List<Phone>> mostVoted() {
		
		List<Phone> list = phoneService.getMostValued();
		
		return new ResponseEntity<List<Phone>>(list, HttpStatus.OK);
	}
}
