package com.ukrsuch.ukrsuch.dao;

import java.util.List;
import java.util.Map;

import com.ukrsuch.ukrsuch.model.ForumCommentArticleModel;
import com.ukrsuch.ukrsuch.model.UserArticleModel;
import com.ukrsuch.ukrsuch.model.UserModel;

public interface ForumDao {
	Map<Integer, List<ForumCommentArticleModel>> getAllForumCommentMap();
	List<ForumCommentArticleModel> getForumCommentListByArticleId(int articleId);
	Map<Integer, UserModel> getForumCommentUsersListByArticleId();
	void addUserArticleToForum(UserArticleModel userArticle);
	void addForumCommentToUserArticle(ForumCommentArticleModel comment);

}
