package com.ukrsuch.ukrsuch.dao;

import com.ukrsuch.ukrsuch.model.UserModel;

public interface UserDao {
	UserModel getUserByNik(String nik);
	UserModel getUserById(int id);
	UserModel getUserByEmail(String email);
	void addUser(UserModel user);
}
