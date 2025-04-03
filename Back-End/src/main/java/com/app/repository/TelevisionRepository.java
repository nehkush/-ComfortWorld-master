package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Television;

public interface TelevisionRepository extends JpaRepository<Television, Long>
{

	List<Television> findByBrand(String brand);

}
