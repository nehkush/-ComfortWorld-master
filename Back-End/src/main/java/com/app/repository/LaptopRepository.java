package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Long>
{

	List<Laptop> findByBrand(String brand);
	

}
