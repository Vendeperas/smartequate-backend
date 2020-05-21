package com.smartequate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smartequate.dto.Attributes;

@Repository
public interface AttributesRepository extends CrudRepository<Attributes, Long>{

	public List<Attributes> findAll();
	public List<Attributes> findByCpuLike(String cpu);
	public Attributes findFirstByOrderBySizeHeightDesc();
	public Attributes findFirstByOrderBySizeHeightAsc();
	public Attributes findFirstByOrderByWeightAsc();
	public Attributes findFirstByOrderByWeightDesc();
	
	public Attributes findFirstByOrderByDisplaySizeAsc();
	
	public Attributes findFirstByOrderByDisplaySizeDesc();
	
	public Attributes findFirstByOrderByCameraAAsc();
	
	public Attributes findFirstByOrderByCameraADesc();
	
	public Attributes findFirstByOrderByCameraBAsc();

	public Attributes findFirstByOrderByCameraBDesc();
	
	public Attributes findFirstByOrderByRomAsc();
	public Attributes findFirstByOrderByRomDesc();
	public Attributes findFirstByOrderByRamAsc();
	public Attributes findFirstByOrderByRamDesc();
	public Attributes findFirstByOrderByBatteryAsc();
	public Attributes findFirstByOrderByBatteryDesc();
}
