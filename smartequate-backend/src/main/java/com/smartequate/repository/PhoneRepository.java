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
			+ "AND a.battery like %:battery% "
			+ "AND a.id = p.attributes_id")
	public Page<Phone> findAll(
			@Param("name") String name,
			@Param("brand") String brand,
			@Param("battery") String battery,
			@Param("cpu") String cpu,Pageable pageable);
	
	public Phone findById(int id);
	
	@Query(nativeQuery= true, value="SELECT * FROM phone p, attributes a "
			+ "WHERE name like %:name% "
			+ "AND brand like %:brand% "
			+ "AND a.cpu like %:cpu% "
			+ "AND a.battery like %:battery% "
			+ "AND a.weight between 0 AND :weight "
			+ "AND a.sim_tray BETWEEN :sim_tray AND 2 "
			+ "AND a.display_size between :minDisplaySize AND :maxDisplaySize "
			+ "AND a.card_slot = :card_slot "
			+ "AND a.camera_a between :cameraA AND 100 "
			+ "AND a.camera_b between :cameraB AND 100 "
			+ "AND a.jack = :jack "
			+ "AND a.display_type like :display_type% "
			+ "AND a.rom between :rom AND 1000 "
			+ "AND a.ram between :ram AND 1000 "
			+ "AND a.port like %:port% "
			+ "AND a.multitouch = :multitouch "
			+ "AND a.id = p.attributes_id")
	public Page<Phone> findAllByName(
			@Param("name") String name,
			@Param("brand") String brand,
			@Param("cpu") String cpu,
			@Param("battery") String battery,
			@Param("weight") float weight,
			@Param("sim_tray") int simtray,
			@Param("minDisplaySize") float mindisplaysize,
			@Param("maxDisplaySize") float maxdisplaysize,
			@Param("card_slot") boolean cardslot,
			@Param("cameraA") float cameraa,
			@Param("cameraB") float camerab,
			@Param("jack") boolean jack,
			@Param("display_type") String displaytype,
			@Param("rom") int rom,
			@Param("ram") int ram,
			@Param("multitouch") boolean multitouch,
			@Param("port") String port,
			Pageable pageable);
	
	public List<Phone> findFirst5ByOrderByPointsTotalPointsDesc();
	
	@Query(nativeQuery= true, value="SELECT * FROM phone WHERE id IN "
			+ "(SELECT TOP 5 phone_id FROM vote GROUP BY phone_id ORDER BY COUNT(phone_id) DESC)")
	public List<Phone> findMostVoted();
	
}
