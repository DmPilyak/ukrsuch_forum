package com.ukrsuch.ukrsuch.dao.impl;

import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ukrsuch.ukrsuch.dao.ArticleDao;
import com.ukrsuch.ukrsuch.dao.UserDao;
import com.ukrsuch.ukrsuch.model.ArticleModel;
import com.ukrsuch.ukrsuch.model.CommentArticleModel;
import com.ukrsuch.ukrsuch.model.UserArticleModel;
import com.ukrsuch.ukrsuch.model.UserModel;
import com.ukrsuch.ukrsuch.service.ArticleService;

@Repository
public class ArticleDaoImpl implements ArticleDao {
	
	private SessionFactory sessionFactory;
	private UserDao userDao;
	
	@Autowired(required = true)
	@Qualifier(value = "userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public ArticleModel getArticleById(int id) {
		ArticleModel article = this.sessionFactory.getCurrentSession().get(ArticleModel.class, id);
		return article;
	}
	
	@Override
	@Transactional
	public Map<ArticleModel, Boolean> boolAtriclesMapForUser(UserModel user) {
		List<ArticleModel> articlesWishList = getWishListForUserById(user.getId());
		List<ArticleModel> allArticles = listArticles();
		Map<ArticleModel, Boolean> boolArticlesMap = new HashMap<ArticleModel, Boolean>();
		for (ArticleModel art : allArticles) {
			if (articlesWishList.contains(art)) {
				boolArticlesMap.put(art, true);
			} else
				boolArticlesMap.put(art, false);
		}
		return boolArticlesMap;
	}
	
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<ArticleModel> listArticles() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ArticleModel> articlesList = session.createQuery("from ArticleModel").list();
		Collections.reverse(articlesList);
		return articlesList;
	}
	
	@Override
	@Transactional
	public List<ArticleModel> getWishListForUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		String REQEST = "SELECT id, Title, Description, autor_name FROM forum_test_db.articles JOIN forum_test_db.user_wish_lists ON user_wish_lists.id_article = articles.id WHERE id_user="
				+ id;
		Query query = session.createSQLQuery(REQEST);
		List<Object[]> rows = query.list();
		List<ArticleModel> wishListForUser = new ArrayList<ArticleModel>();
		System.out.println(rows.toString());
		for (Object[] row : rows) {
			ArticleModel article = new ArticleModel();
			article.setId(Integer.valueOf(row[0].toString()));
			article.setTitle(row[1].toString());
			article.setDescription(row[2].toString());
			article.setAutorName(row[3].toString());

			wishListForUser.add(article);
		}
		return wishListForUser;
	}
	
	@Override
	@Transactional
	public void removeArticleFromUserWishListById(int id_user, int id_article) {
		Session session = sessionFactory.getCurrentSession();
		String REQEST = "DELETE FROM forum_test_db.user_wish_lists WHERE (id_user = " + id_user + " AND id_article = "
				+ id_article + ");";
		session.createSQLQuery(REQEST).executeUpdate();
	}
	
	@Override
	@Transactional
	public void addArticleToWishList(UserModel user, int id_article) {
		Session session = sessionFactory.getCurrentSession();
		String REQEST = "INSERT INTO forum_test_db.user_wish_lists (id_user, id_article) VALUES (" + user.getId() + ", "
				+ id_article + ");";
		session.createSQLQuery(REQEST).executeUpdate();
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<UserArticleModel> getAllUserArticles() {
		Session session = this.sessionFactory.getCurrentSession();
		List<UserArticleModel> articlesList = session.createQuery("from UserArticleModel").list();
		return articlesList;
	}
	
	@Override
	@Transactional
	public List<CommentArticleModel> getCommentListByArticleId(int articleId) {
		Session session = this.sessionFactory.getCurrentSession();
		String REQEST = "SELECT * FROM forum_test_db.comment_articles WHERE article_id = " + articleId + ";";
		Query query = session.createSQLQuery(REQEST);
		List<Object[]> rows = query.list();
		List<CommentArticleModel> commentList = new ArrayList<CommentArticleModel>();
		for (Object[] row : rows) {
			CommentArticleModel comment = new CommentArticleModel();
			comment.setCommentId(Integer.valueOf(row[0].toString()));
			comment.setCommentContent(row[1].toString());
			comment.setArticleId(Integer.valueOf(row[2].toString()));
			comment.setAutorId(Integer.valueOf(row[3].toString()));

			commentList.add(comment);
		}
		Collections.reverse(commentList);
		return commentList;
	}
	
	@Override
	@Transactional
	public List<UserModel> getCommentUsersListByArticleId(int article_id) {
		List<CommentArticleModel> commentList = getCommentListByArticleId(article_id);
		List<UserModel> users = new ArrayList<UserModel>();
		System.out.println("article id =  " + article_id);
		System.out.println("user:  "+userDao.getUserById(2));
		for (CommentArticleModel comment : commentList) {
			UserModel user = this.userDao.getUserById(comment.getAutorId());
			System.out.println(comment);
			System.out.println(user);
			users.add(user);
		}
		return users;
	}

	@Override
	@Transactional
	public void addCommentToArticle(CommentArticleModel comment) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(comment);
	}
	
	@Override
	@Transactional
	public Blob getBlobFromMultipartFile(MultipartFile file) {
		Session session = sessionFactory.getCurrentSession();
		Blob image = null;
		try {
			image = Hibernate.getLobCreator(session).createBlob(file.getBytes());
			return image;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	@Override
	@Transactional
	public void addArticleADMIN(ArticleModel article) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(article);
	}

	@Override
	@Transactional
	public Blob loadArticleImgById(int articleId) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(ArticleModel.class, articleId).getImg();
	}
}
