package com.smartequate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartequate.dto.Phone;
import com.smartequate.dto.User;
import com.smartequate.dto.Vote;
import com.smartequate.repository.VoteRepository;

@Service
public class VoteService {

	@Autowired
	VoteRepository voteRepo;

	public Long getPhoneVotes(Integer id) {
		return voteRepo.countByPhoneId(id);
	}
	
	public boolean getVoteByUser(int phoneId, String user) {
		
		List<Vote> votes = voteRepo.findByPhoneId(phoneId);
		
		boolean found = false;
		
		for (Vote vote: votes) {
			if (vote.getUser().getUsername().equals(user)) {
				found = true;
			}
		}
		
		return found;
		
		
	}
	
	public void saveVote(Vote vote) {
		voteRepo.save(vote);
	}
	
	public void deleteVote(User user, Phone phone) {
		
		List<Vote> votes = voteRepo.findByPhoneId(phone.getId());
		
		Vote foundVote = new Vote();
		
		for (Vote vote: votes) {
			if (vote.getUser().getUsername().equals(user.getUsername())) {
				foundVote = vote;
			}
		}
		
		voteRepo.deleteById(foundVote.getId());
	}
	
}
