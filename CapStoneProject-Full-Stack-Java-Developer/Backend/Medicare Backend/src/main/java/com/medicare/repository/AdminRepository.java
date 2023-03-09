package com.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicare.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, String>{

	Admin findByusername(String username);

}
