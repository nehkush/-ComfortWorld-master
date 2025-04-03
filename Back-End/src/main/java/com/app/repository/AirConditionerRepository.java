package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.AirConditioner;

public interface AirConditionerRepository extends JpaRepository<AirConditioner, Long>
{

	List<AirConditioner> findByBrand(String brand);

}
