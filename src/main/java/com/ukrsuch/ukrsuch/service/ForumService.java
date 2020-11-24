package com.ukrsuch.ukrsuch.service;

import java.util.List;
import java.util.Map;

import com.ukrsuch.ukrsuch.model.ForumCommentArticleModel;
import com.ukrsuch.ukrsuch.model.UserArticleModel;
import com.ukrsuch.ukrsuch.model.UserModel;

public interface ForumService {
	Map<Integer, List<ForumCommentArticleModel>> getAllForumCommentMap();
	List<ForumCommentArticleModel> getForumCommentListByArticleId(int articleId);
	Map<Integer, UserModel> getForumCommentUsersListByArticleId();
	void addUserArticleToForum(UserArticleModel userArticle);
	void addForumCommentToUserArticle(ForumCommentArticleModel comment);
}
