package com.ukrsuch.ukrsuch.service.impl;

import java.sql.Blob;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ukrsuch.ukrsuch.dao.ArticleDao;
import com.ukrsuch.ukrsuch.model.ArticleModel;
import com.ukrsuch.ukrsuch.model.CommentArticleModel;
import com.ukrsuch.ukrsuch.model.UserArticleModel;
import com.ukrsuch.ukrsuch.model.UserModel;
import com.ukrsuch.ukrsuch.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	private ArticleDao articleDao;
	
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	@Override
	@Transactional
	public List<ArticleModel> getWishListForUserById(int id) {
		return this.articleDao.getWishListForUserById(id);
	}

	@Override
	@Transactional
	public void removeArticleFromUserWishListById(int id_user, int id_article) {
		this.articleDao.removeArticleFromUserWishListById(id_user, id_article);
	}

	@Override
	@Transactional
	public ArticleModel getArticleById(int id) {
		return this.articleDao.getArticleById(id);
	}

	@Override
	@Transactional
	public List<ArticleModel> listArticles() {
		return this.articleDao.listArticles();
	}

	@Override
	@Transactional
	public void addArticleToWishList(UserModel user, int id_article) {
		this.articleDao.addArticleToWishList(user, id_article);

	}

	@Override
	@Transactional
	public List<UserArticleModel> getAllUserArticles() {
		return this.articleDao.getAllUserArticles();
	}
	
	@Override
	@Transactional
	public List<CommentArticleModel> getCommentListByArticleId(int articleId) {
		return this.articleDao.getCommentListByArticleId(articleId);
	}

	@Override
	@Transactional
	public List<UserModel> getCommentUsersListByArticleId(int comment_id) {
		return this.articleDao.getCommentUsersListByArticleId(comment_id);
	}

	@Override
	@Transactional
	public void addCommentToArticle(CommentArticleModel comment) {
		this.articleDao.addCommentToArticle(comment);
	}
	
	@Override
	@Transactional
	public Map<ArticleModel, Boolean> boolAtriclesMapForUser(UserModel user) {
		return articleDao.boolAtriclesMapForUser(user);
	}

	@Override
	@Transactional
	public Blob getBlobFromMultipartFile(MultipartFile file) {
		return articleDao.getBlobFromMultipartFile(file);
	}

	@Override
	@Transactional
	public void addArticleADMIN(ArticleModel article) {
		articleDao.addArticleADMIN(article);
	}

	@Override
	@Transactional
	public Blob loadArticleImgById(int articleId) {
		return articleDao.loadArticleImgById(articleId);
	}

}
