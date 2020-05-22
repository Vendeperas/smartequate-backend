package com.smartequate.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.smartequate.dto.Phone;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Integer>, PagingAndSortingRepository<Phone, Integer>{

	public List<Phone> findAll();
	
	@Query(nativeQuery= true, value="SELECT * FROM phone p, attributes a "
			+ "WHERE name like %:name% "
			+ "AND brand like %:brand% "
			+ "AND a.cpu like %:cpu% "
			+ "AND a.id = p.attributes_id")
	public Page<Phone> findAllByName(
			@Param("name") String name,
			@Param("brand") String brand,
			@Param("cpu") String cpu,
			Pageable pageable);
	
	public List<Phone> findFirst5ByOrderByPointsTotalPointsDesc();
	
	@Query(nativeQuery= true, value="SELECT * FROM phone WHERE id IN "
			+ "(SELECT TOP 5 phone_id FROM vote GROUP BY phone_id ORDER BY COUNT(phone_id) DESC)")
	public List<Phone> findMostVoted();
}
