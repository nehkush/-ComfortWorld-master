package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.ProductIssue;

public interface ProductIssueRepository extends JpaRepository<ProductIssue, Long>
{

	List<ProductIssue> findByCategory(String category);

}
