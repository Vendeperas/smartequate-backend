package com.smartequate.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartequate.service.VoteService;

@RestController
@CrossOrigin
@RequestMapping("/votes")
public class VoteController {

	@Autowired
	VoteService voteService;
	
	public static final Logger logger = LoggerFactory.getLogger(PhoneController.class);
	
	@GetMapping("/phones/{id}")
	public ResponseEntity<Integer> getVotes(@PathParam("id") Integer id) {
		
		int votes = voteService.getPhoneVotes(id);
		
		return new ResponseEntity<Integer>(votes, HttpStatus.OK);
	}
}