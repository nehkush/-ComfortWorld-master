package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Admin;
import com.app.model.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	User findByEmail(String email);


}
