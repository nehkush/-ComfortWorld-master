package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.WashingMachine;

public interface WashingMachineRepository extends JpaRepository<WashingMachine, Long>
{

	List<WashingMachine> findByBrand(String brand);

}
