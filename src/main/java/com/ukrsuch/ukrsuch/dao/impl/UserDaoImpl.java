package com.ukrsuch.ukrsuch.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ukrsuch.ukrsuch.dao.ArticleDao;
import com.ukrsuch.ukrsuch.dao.ComicsDao;
import com.ukrsuch.ukrsuch.dao.UserDao;
import com.ukrsuch.ukrsuch.model.CommentComicsModel;
import com.ukrsuch.ukrsuch.model.ForumCommentArticleModel;
import com.ukrsuch.ukrsuch.model.UserArticleModel;
import com.ukrsuch.ukrsuch.model.UserModel;

@Repository
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	private ArticleDao articleDao;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public UserModel getUserByNik(String nik) {
		Session session = sessionFactory.getCurrentSession();
		UserModel user = session.byNaturalId(UserModel.class).using("nik", nik).load();
		return user;
	}

	@Override
	@Transactional
	public UserModel getUserByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		UserModel user = session.byNaturalId(UserModel.class).using("email", email).load();
		return user;
	}

	@Override
	@Transactional
	public UserModel getUserById(int id) {
		UserModel user = this.sessionFactory.getCurrentSession().get(UserModel.class, id);
		return user;
	}

	@Override
	@Transactional
	public void addUser(UserModel user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
	}

}
