package com.smartequate.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.smartequate.dto.Phone;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Integer>{

	public List<Phone> findAll();
}
