package com.ukrsuch.ukrsuch.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ukrsuch.ukrsuch.dao.ArticleDao;
import com.ukrsuch.ukrsuch.dao.ForumDao;
import com.ukrsuch.ukrsuch.dao.UserDao;
import com.ukrsuch.ukrsuch.model.ForumCommentArticleModel;
import com.ukrsuch.ukrsuch.model.UserArticleModel;
import com.ukrsuch.ukrsuch.model.UserModel;

@Repository
public class ForumDaoImpl implements ForumDao {
	
	private SessionFactory sessionFactory;
	private ArticleDao articleDao;
	private UserDao userDao;
	
	@Autowired(required = true)
	@Qualifier(value = "userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "articleDao")
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public void addUserArticleToForum(UserArticleModel userArticle) {
		Session session = sessionFactory.getCurrentSession();
		String REQEST = "INSERT INTO forum_test_db.forum_articles (Title, Description, autor_id, date) VALUES ('"
				+ userArticle.getTitle() + "', '" + userArticle.getDescription() + "', " + userArticle.getAutorId()
				+ ", now());";
		session.createSQLQuery(REQEST).executeUpdate();
	}

	@Override
	@Transactional
	public List<ForumCommentArticleModel> getForumCommentListByArticleId(int articleId) {
		Session session = this.sessionFactory.getCurrentSession();
		String REQEST = "SELECT * FROM forum_test_db.comment_forum_articles WHERE forum_article_id = " + articleId
				+ ";";
		Query query = session.createSQLQuery(REQEST);
		List<Object[]> rows = query.list();
		List<ForumCommentArticleModel> commentList = new ArrayList<ForumCommentArticleModel>();
		for (Object[] row : rows) {
			ForumCommentArticleModel comment = new ForumCommentArticleModel();
			comment.setCommentId(Integer.valueOf(row[0].toString()));
			comment.setCommentContent(row[1].toString());
			comment.setForumArticleId(Integer.valueOf(row[2].toString()));
			comment.setAutorId(Integer.valueOf(row[3].toString()));

			commentList.add(comment);
		}
		return commentList;
	}

	@Override
	@Transactional
	public Map<Integer, List<ForumCommentArticleModel>> getAllForumCommentMap() {
		List<UserArticleModel> articlesList = articleDao.getAllUserArticles();
		Map<Integer, List<ForumCommentArticleModel>> articlesAndCommentMap = new HashMap<Integer, List<ForumCommentArticleModel>>();
		for (UserArticleModel a : articlesList) {
			List<ForumCommentArticleModel> comment = getForumCommentListByArticleId(a.getId());
			articlesAndCommentMap.put(a.getId(), comment);
		}
		return articlesAndCommentMap;
	}

	@Override
	@Transactional
	public Map<Integer, UserModel> getForumCommentUsersListByArticleId() {
		Map<Integer, List<ForumCommentArticleModel>> commentMap = getAllForumCommentMap();
		Collection<List<ForumCommentArticleModel>> commentList = commentMap.values();
		Map<Integer, UserModel> users = new HashMap<Integer, UserModel>();
		for (List<ForumCommentArticleModel> list : commentList) {
			for (ForumCommentArticleModel comment : list) {
				UserModel user = userDao.getUserById(comment.getAutorId());
				users.put(comment.getCommentId(), user);
			}
		}
		return users;
	}

	@Override
	@Transactional
	public void addForumCommentToUserArticle(ForumCommentArticleModel comment) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(comment);
	}
}
