package com.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Long> {
      Admin findAdminByEmail(String email);
}
