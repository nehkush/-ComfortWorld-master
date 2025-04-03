package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Admin;
import com.app.repository.AdminRepository;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	@Override
	public Admin findAdminByEmail(String email) {
		// TODO Auto-generated method stub
		return adminRepository.findAdminByEmail(email);
	}
      
}
