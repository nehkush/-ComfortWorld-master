package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Microwave;

public interface MicrowaveRepository extends JpaRepository<Microwave, Long>
{

	List<Microwave> findByBrand(String brand);

}
