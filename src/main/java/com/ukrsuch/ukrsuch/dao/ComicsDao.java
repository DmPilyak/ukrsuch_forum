package com.ukrsuch.ukrsuch.dao;

import java.sql.Blob;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ukrsuch.ukrsuch.model.ArticleModel;
import com.ukrsuch.ukrsuch.model.ComicsArticleModel;
import com.ukrsuch.ukrsuch.model.CommentComicsModel;
import com.ukrsuch.ukrsuch.model.UserModel;

public interface ComicsDao {
	ComicsArticleModel getComicsArticleById(int id);
	List<ComicsArticleModel> getComicsWishListForUserById(int id);
	List<ComicsArticleModel> listComicsArticles();
	List<CommentComicsModel> getComicsCommentListByComicsId(int comicsId);
	List<UserModel> getComicsCommentUsersListByComicsId(int comicsId);
	Map<ComicsArticleModel, Boolean> boolComicsAtriclesMapForUser(UserModel user);
	void removeComicsFromUserWishListById(int id_user, int id_comics);
	void addComicsArticleToWishList(UserModel user, int id_comics);
	void addCommentToComics(CommentComicsModel comment);
	void addComicsADMIN(ComicsArticleModel comics);
	Blob getBlobFromMultipartFile(MultipartFile file);
	Blob loadComicsImgById(int comicsId);
	

}
