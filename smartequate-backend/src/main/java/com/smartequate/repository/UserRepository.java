package com.smartequate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smartequate.dto.Size;
import com.smartequate.dto.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	public User findById(int id);
	
	public User findByUsername(String username);

}
