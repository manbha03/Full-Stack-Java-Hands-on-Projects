package com.simplilearn.dao;

import com.simplilearn.beans.Admin;

public interface AdminDao {
	Integer addAdmin(Admin admin);
	Admin searchByEmail(String email);
	boolean validate(Admin admin);
	void updatePassword(String email,String password);

}
