package com.ukrsuch.ukrsuch.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ukrsuch.ukrsuch.dao.UserDao;
import com.ukrsuch.ukrsuch.model.ComicsArticleModel;
import com.ukrsuch.ukrsuch.model.CommentComicsModel;
import com.ukrsuch.ukrsuch.model.ForumCommentArticleModel;
import com.ukrsuch.ukrsuch.model.UserArticleModel;
import com.ukrsuch.ukrsuch.model.UserModel;
import com.ukrsuch.ukrsuch.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public UserModel getUserByNik(String nik) {
		return this.userDao.getUserByNik(nik);
	}

	@Override
	@Transactional
	public UserModel getUserByEmail(String email) {
		return this.userDao.getUserByEmail(email);
	}

	@Override
	@Transactional
	public UserModel getUserById(int id) {
		return this.userDao.getUserById(id);
	}

	@Override
	@Transactional
	public void addUser(UserModel user) {
		this.userDao.addUser(user);
	}
	
}
