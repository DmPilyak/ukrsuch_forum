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

import com.ukrsuch.ukrsuch.dao.ComicsDao;
import com.ukrsuch.ukrsuch.dao.UserDao;
import com.ukrsuch.ukrsuch.model.ComicsArticleModel;
import com.ukrsuch.ukrsuch.model.CommentComicsModel;
import com.ukrsuch.ukrsuch.model.UserModel;

@Repository
public class ComicsDaoImpl implements ComicsDao {
	
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
	public ComicsArticleModel getComicsArticleById(int id) {
		ComicsArticleModel comicsArticle = this.sessionFactory.getCurrentSession().get(ComicsArticleModel.class, id);
		return comicsArticle;
	}
	
	@Override
	@Transactional
	public Map<ComicsArticleModel, Boolean> boolComicsAtriclesMapForUser(UserModel user) {
		List<ComicsArticleModel> comicsArticlesWishList = getComicsWishListForUserById(user.getId());
		List<ComicsArticleModel> allComicsArticles = listComicsArticles();
		Map<ComicsArticleModel, Boolean> boolComicsArticlesMap = new HashMap<ComicsArticleModel, Boolean>();
		for (ComicsArticleModel cArt : allComicsArticles) {
			if (comicsArticlesWishList.contains(cArt)) {
				boolComicsArticlesMap.put(cArt, true);
			} else
				boolComicsArticlesMap.put(cArt, false);
		}
		return boolComicsArticlesMap;
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<ComicsArticleModel> listComicsArticles() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ComicsArticleModel> comicsArticlesList = session.createQuery("from ComicsArticleModel").list();
		Collections.reverse(comicsArticlesList);
		return comicsArticlesList;
	}

	@Override
	@Transactional
	public List<ComicsArticleModel> getComicsWishListForUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		String REQEST = "SELECT id, Title, Description, autor_name FROM forum_test_db.comics JOIN forum_test_db.user_comics_wish_lists ON user_comics_wish_lists.id_comics = comics.id WHERE id_user="
				+ id;
		Query query = session.createSQLQuery(REQEST);
		List<Object[]> rows = query.list();
		List<ComicsArticleModel> commicsWishListForUser = new ArrayList<ComicsArticleModel>();
		for (Object[] row : rows) {
			ComicsArticleModel comics = new ComicsArticleModel();
			comics.setId(Integer.valueOf(row[0].toString()));
			comics.setTitle(row[1].toString());
			comics.setDescription(row[2].toString());
			comics.setAutorName(row[3].toString());

			commicsWishListForUser.add(comics);
		}
		return commicsWishListForUser;
	}

	@Override
	@Transactional
	public void removeComicsFromUserWishListById(int id_user, int id_comics) {
		Session session = sessionFactory.getCurrentSession();
		String REQEST = "DELETE FROM forum_test_db.user_comics_wish_lists WHERE (id_user = " + id_user
				+ " AND id_comics = " + id_comics + ");";
		session.createSQLQuery(REQEST).executeUpdate();
	}
	
	@Override
	@Transactional
	public void addComicsArticleToWishList(UserModel user, int id_comics) {
		Session session = sessionFactory.getCurrentSession();
		String REQEST = "INSERT INTO forum_test_db.user_comics_wish_lists (id_user, id_comics) VALUES (" + user.getId()
				+ ", " + id_comics + ");";
		session.createSQLQuery(REQEST).executeUpdate();
	}

	@Override
	@Transactional
	public List<CommentComicsModel> getComicsCommentListByComicsId(int comicsId) {
		Session session = this.sessionFactory.getCurrentSession();
		String REQEST = "SELECT * FROM forum_test_db.comment_comics WHERE comics_id = " + comicsId + ";";
		Query query = session.createSQLQuery(REQEST);
		List<Object[]> rows = query.list();
		List<CommentComicsModel> comicsCommentList = new ArrayList<CommentComicsModel>();
		for (Object[] row : rows) {
			CommentComicsModel comment = new CommentComicsModel();
			comment.setCommentId(Integer.valueOf(row[0].toString()));
			comment.setCommentContent(row[1].toString());
			comment.setComicsId(Integer.valueOf(row[2].toString()));
			comment.setAutorId(Integer.valueOf(row[3].toString()));

			comicsCommentList.add(comment);
		}
		Collections.reverse(comicsCommentList);
		return comicsCommentList;
	}
	
	@Override
	@Transactional
	public void addCommentToComics(CommentComicsModel comment) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(comment);
	}
	
	@Override
	@Transactional
	public List<UserModel> getComicsCommentUsersListByComicsId(int comicsId) {
		List<CommentComicsModel> comicsCommentList = getComicsCommentListByComicsId(comicsId);
		List<UserModel> users = new ArrayList<UserModel>();
		for (CommentComicsModel comment : comicsCommentList) {
			UserModel user = userDao.getUserById(comment.getAutorId());
			users.add(user);
		}
		return users;
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
	public void addComicsADMIN(ComicsArticleModel comics) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(comics);
	}

	@Override
	@Transactional
	public Blob loadComicsImgById(int comicsId) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(ComicsArticleModel.class, comicsId).getImg();
	}

}
