package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.WaterPurifier;

public interface WaterPurifierRepository extends JpaRepository<WaterPurifier, Long>
{

	List<WaterPurifier> findByBrand(String brand);

}
