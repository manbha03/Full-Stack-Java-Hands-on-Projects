package com.medicare.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.model.Admin;
import com.medicare.repository.AdminRepository;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/admin/{username}")
	public boolean verifyAdminLogin(@RequestBody Map loginData, @PathVariable(name = "username") String username, HttpSession session) {
		String tempUsername=(String) loginData.get("username");
		String tempPassword=(String) loginData.get("password");
		Admin admin = adminRepository.findByusername(username);
		if(admin!=null && admin.getUsername().equals(tempUsername) && admin.getPassword().equals(tempPassword)) {
			session.setAttribute("adminUsername", tempUsername);
			return true;
		}else {
			return false;
		}
	}
	
}
