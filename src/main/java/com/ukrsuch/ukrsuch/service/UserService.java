package com.ukrsuch.ukrsuch.service;

import com.ukrsuch.ukrsuch.model.UserModel;

public interface UserService {
	UserModel getUserByNik(String nik);
	UserModel getUserById(int id);
	UserModel getUserByEmail(String email);
	void addUser(UserModel user);
}
