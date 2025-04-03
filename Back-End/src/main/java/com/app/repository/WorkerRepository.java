package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

	Optional<Worker> findByEmail(String email);

}
