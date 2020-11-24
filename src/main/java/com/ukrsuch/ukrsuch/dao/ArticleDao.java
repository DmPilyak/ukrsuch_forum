package com.ukrsuch.ukrsuch.dao;

import java.sql.Blob;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ukrsuch.ukrsuch.model.ArticleModel;
import com.ukrsuch.ukrsuch.model.CommentArticleModel;
import com.ukrsuch.ukrsuch.model.UserArticleModel;
import com.ukrsuch.ukrsuch.model.UserModel;

public interface ArticleDao {
	ArticleModel getArticleById(int id);
	List<UserArticleModel> getAllUserArticles();
	List<ArticleModel> getWishListForUserById(int id);
	List<ArticleModel> listArticles();
	List<CommentArticleModel> getCommentListByArticleId(int articleId);
	Map<ArticleModel, Boolean> boolAtriclesMapForUser(UserModel user);
	List<UserModel> getCommentUsersListByArticleId(int articleId);
	Blob getBlobFromMultipartFile(MultipartFile file);
	void removeArticleFromUserWishListById(int id_user, int id_article);
	void addArticleADMIN(ArticleModel article);
	void addArticleToWishList(UserModel user, int id_article);
	void addCommentToArticle(CommentArticleModel comment);
	Blob loadArticleImgById(int articleId);
}

