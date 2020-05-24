package com.smartequate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartequate.repository.VoteRepository;

@Service
public class VoteService {

	@Autowired
	VoteRepository voteRepo;

	public int getPhoneVotes(int id) {
		return voteRepo.findVoted(id);
	}
}
