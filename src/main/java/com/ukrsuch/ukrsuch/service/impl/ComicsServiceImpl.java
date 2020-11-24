package com.ukrsuch.ukrsuch.service.impl;

import java.sql.Blob;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ukrsuch.ukrsuch.dao.ComicsDao;
import com.ukrsuch.ukrsuch.model.ArticleModel;
import com.ukrsuch.ukrsuch.model.ComicsArticleModel;
import com.ukrsuch.ukrsuch.model.CommentComicsModel;
import com.ukrsuch.ukrsuch.model.UserModel;
import com.ukrsuch.ukrsuch.service.ComicsService;

@Service
public class ComicsServiceImpl implements ComicsService {
	private ComicsDao comicsDao;

	public void setComicsDao(ComicsDao comicsDao) {
		this.comicsDao = comicsDao;
	}
	
	@Override
	@Transactional
	public ComicsArticleModel getComicsArticleById(int id) {
		return this.comicsDao.getComicsArticleById(id);
	}

	@Override
	@Transactional
	public List<ComicsArticleModel> listComicsArticles() {
		return this.comicsDao.listComicsArticles();
	}

	@Override
	@Transactional
	public List<ComicsArticleModel> getComicsWishListForUserById(int id) {
		return this.comicsDao.getComicsWishListForUserById(id);
	}

	@Override
	@Transactional
	public void removeComicsFromUserWishListById(int id_user, int id_comics) {
		this.comicsDao.removeComicsFromUserWishListById(id_user, id_comics);
		
	}

	
	@Override
	@Transactional
	public void addComicsArticleToWishList(UserModel user, int id_comics) {
		comicsDao.addComicsArticleToWishList(user, id_comics);
	}

	@Override
	@Transactional
	public Map<ComicsArticleModel, Boolean> boolComicsAtriclesMapForUser(UserModel user) {
		return comicsDao.boolComicsAtriclesMapForUser(user);
	}

	@Override
	@Transactional
	public List<CommentComicsModel> getComicsCommentListByComicsId(int comicsId) {
		return comicsDao.getComicsCommentListByComicsId(comicsId);
	}
	
	@Override
	@Transactional
	public void addCommentToComics(CommentComicsModel comment) {
		comicsDao.addCommentToComics(comment);
	}
	
	@Override
	@Transactional
	public List<UserModel> getComicsCommentUsersListByComicsId(int comicsId) {
		return comicsDao.getComicsCommentUsersListByComicsId(comicsId);
	}
	
	@Override
	@Transactional
	public Blob getBlobFromMultipartFile(MultipartFile file) {
		return comicsDao.getBlobFromMultipartFile(file);
	}

	@Override
	@Transactional
	public void addComicsADMIN(ComicsArticleModel comics) {
		comicsDao.addComicsADMIN(comics);
	}

	@Override
	@Transactional
	public Blob loadComicsImgById(int comics) {
		return comicsDao.loadComicsImgById(comics);
	}
}
