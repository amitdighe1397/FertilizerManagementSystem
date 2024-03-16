package com.example.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Admin;
import com.example.repository.AdminRepository;

@Service
public class AdminServiceImpl {

	@Autowired
	private AdminRepository adminRepository;

	public Admin findUserByUsername(String username, String password) {

		Admin admin = adminRepository.findByUsername(username);

		if (admin != null && admin.getPassword().equals(password)) {
			return admin;
		}
		return null;
	}

	public void saveUser(Admin admin) {

		this.adminRepository.save(admin);
	}

}
