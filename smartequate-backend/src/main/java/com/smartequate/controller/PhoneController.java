package com.smartequate.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartequate.dto.CustomSearchBody;
import com.smartequate.dto.Phone;
import com.smartequate.service.PhoneService;

@RestController
@CrossOrigin
@RequestMapping("/phones")
public class PhoneController {

	@Autowired
	PhoneService phoneService;
	
	public static final Logger logger = LoggerFactory.getLogger(PhoneController.class);
	
	@PostMapping("/list")
	public ResponseEntity<Page<Phone>> filterPhoneList(
			@RequestParam(name="page") int page,
			@RequestParam(name="size") int size,
			@RequestParam(name="name", required = false) String name,
			@RequestParam(name="brand", required = false) String brand,
			@RequestParam(name="cpu", required = false) String cpu,
			@RequestParam(name="battery", required = false) String battery,
			@RequestParam(name="sort", required = false) String sort,
			@RequestParam(name="direction", required = false) String direction,
			@RequestBody CustomSearchBody body
			) {
		
		Page<Phone> phonePage;

		if (direction.equals(new String("asc"))) {
			System.out.println("entrado a asc");
			phonePage = phoneService.getAllPageable(name,brand,cpu,battery,body,PageRequest.of(page, size, Sort.by(sort)));
		} else {
			System.out.println("entrado a desc");
			phonePage = phoneService.getAllPageable(name,brand,cpu,battery,body,PageRequest.of(page, size, Sort.by(sort).descending()));
		}
		
		
		return new ResponseEntity<Page<Phone>>(phonePage, HttpStatus.OK);
	}
	
	@GetMapping("/mostValued")
	public ResponseEntity<List<Phone>> mostValued() {
		
		List<Phone> list = phoneService.getMostValued();
		
		return new ResponseEntity<List<Phone>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/mostVoted")
	public ResponseEntity<List<Phone>> mostVoted() {
		
		List<Phone> list = phoneService.getMostVoted();
		
		return new ResponseEntity<List<Phone>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Phone> getPhone(@PathVariable("id") int id) {
		
		Phone phone = phoneService.getPhoneById(id);
		
		return new ResponseEntity<Phone>(phone, HttpStatus.OK);
	}
	
	@GetMapping("/compute")
	public ResponseEntity<String> computePoints() {
		
		phoneService.computeAllPoints();
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Page<Phone>> getAllPhones(
			@RequestParam(name="name") String name,
			@RequestParam(name="brand") String brand,
			@RequestParam(name="cpu") String cpu,
			@RequestParam(name="battery") String battery,
			@RequestParam(name="page") int page,
			@RequestParam(name="size") int size) {
		
		Page<Phone> pagePhone = phoneService.getAllPhones(name, brand, cpu, battery,PageRequest.of(page, size));
		
		return new ResponseEntity<Page<Phone>>(pagePhone, HttpStatus.OK); 
		
	}
	
}
