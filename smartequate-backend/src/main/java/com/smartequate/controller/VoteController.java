package com.smartequate.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartequate.dto.GenericResponse;
import com.smartequate.dto.Phone;
import com.smartequate.dto.User;
import com.smartequate.dto.Vote;
import com.smartequate.service.PhoneService;
import com.smartequate.service.UserService;
import com.smartequate.service.VoteService;

@RestController
@CrossOrigin
@RequestMapping("/votes")
public class VoteController {

	@Autowired
	VoteService voteService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PhoneService phoneService;
	
	public static final Logger logger = LoggerFactory.getLogger(PhoneController.class);
	
	@GetMapping("/phones/{id}")
	public ResponseEntity<Long> getVotes(@PathVariable("id") Integer id) {
		
		Long votes = voteService.getPhoneVotes(id);
		
		return new ResponseEntity<Long>(votes, HttpStatus.OK);
	}
	
	@GetMapping("/phone/{id}/user/{userName}")
	public ResponseEntity<Boolean> getVotesByUser(@PathVariable("id") Integer id, @PathVariable("userName") String user) {
		
		Boolean found = voteService.getVoteByUser(id, user);
		
		return new ResponseEntity<Boolean>(found, HttpStatus.OK);
	}
	
	
	@PostMapping("/phone/{id}/user/{userName}")
	public ResponseEntity<GenericResponse> saveVote(@PathVariable("id") Integer id, @PathVariable("userName") String userName) {
		
		User user = userService.getUserByName(userName);
		
		Phone phone = phoneService.getPhoneById(id);
		
		Vote vote = new Vote();
		
		vote.setPhone(phone);
		vote.setUser(user);
		
		voteService.saveVote(vote);
		
		GenericResponse response = new GenericResponse();
		
		response.setStatus("Finished");
		response.setMessage("OK");
		response.setDescription("Process finished succesfully");
		
		return new ResponseEntity<GenericResponse>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/phone/{id}/user/{userName}")
	public ResponseEntity<GenericResponse> deleteVote(@PathVariable("id") Integer id, @PathVariable("userName") String userName) {
		
		User user = userService.getUserByName(userName);
		
		Phone phone = phoneService.getPhoneById(id);
		
		voteService.deleteVote(user, phone);
		
		GenericResponse response = new GenericResponse();
		
		response.setStatus("Finished");
		response.setMessage("OK");
		response.setDescription("Process finished succesfully");
		
		return new ResponseEntity<GenericResponse>(response, HttpStatus.CREATED);
	}
}
