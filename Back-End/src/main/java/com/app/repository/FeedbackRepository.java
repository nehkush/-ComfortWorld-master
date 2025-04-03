package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>
{

	List<Feedback> findByName(String userName);

}
