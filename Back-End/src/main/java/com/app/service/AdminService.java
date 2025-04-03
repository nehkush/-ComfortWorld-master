package com.app.service;

import com.app.model.Admin;

public interface AdminService {
     Admin findAdminByEmail(String email);
}
