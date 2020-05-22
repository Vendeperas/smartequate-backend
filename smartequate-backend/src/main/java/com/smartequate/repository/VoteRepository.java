package com.smartequate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smartequate.dto.Phone;
import com.smartequate.dto.Vote;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Integer>{

	public Vote findById(int id);
	
	@Query(nativeQuery= true, value="SELECT * FROM phone WHERE id IN "
			+ "(SELECT TOP 5 phone_id FROM vote GROUP BY phone_id )")
	public List<Phone> findMostVoted();
}
