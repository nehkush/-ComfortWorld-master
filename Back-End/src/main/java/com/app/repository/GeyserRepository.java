package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Geyser;

public interface GeyserRepository extends JpaRepository<Geyser, Long>
{

	List<Geyser> findByBrand(String brand);

}
