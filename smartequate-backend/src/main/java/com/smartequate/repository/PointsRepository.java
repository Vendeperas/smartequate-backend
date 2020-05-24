package com.smartequate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.smartequate.dto.Phone;
import com.smartequate.dto.Points;


public interface PointsRepository extends CrudRepository<Points, Integer>{

}
