package com.smartequate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.smartequate.dto.Size;

@Repository
public interface SizeRepository extends CrudRepository<Size, Integer>{

	public Size findById(int id);
}
