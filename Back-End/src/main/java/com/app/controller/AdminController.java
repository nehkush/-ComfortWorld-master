package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Admin;
import com.app.model.Login;
import com.app.model.User;
import com.app.service.AdminService;
import com.app.service.AdminServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/Admin")
public class AdminController {
	@Autowired
    AdminService adminService;

		


	@PostMapping("/byEmail")
	    public ResponseEntity<Admin> getAdminByEmail(@RequestBody Login login) {
	       Admin admin = adminService.findAdminByEmail(login.getEmail());
	        if (admin != null && admin.getPassword().trim().equals(login.getPassword().trim())) {
	            return ResponseEntity.ok(admin);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
