package com.ukrsuch.ukrsuch.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ukrsuch.ukrsuch.dao.ForumDao;
import com.ukrsuch.ukrsuch.model.ForumCommentArticleModel;
import com.ukrsuch.ukrsuch.model.UserArticleModel;
import com.ukrsuch.ukrsuch.model.UserModel;
import com.ukrsuch.ukrsuch.service.ForumService;

@Service
public class ForumServiceImpl implements ForumService {
	
private ForumDao forumDao;
	
	public void setForumDao(ForumDao forumDao) {
		this.forumDao = forumDao;
	}
	
	@Override
	@Transactional
	public void addUserArticleToForum(UserArticleModel userArticle) {
		this.forumDao.addUserArticleToForum(userArticle);
	}


	@Override
	@Transactional
	public Map<Integer, List<ForumCommentArticleModel>> getAllForumCommentMap() {
		return this.forumDao.getAllForumCommentMap();
	}

	@Override
	@Transactional
	public Map<Integer, UserModel> getForumCommentUsersListByArticleId() {
		return this.forumDao.getForumCommentUsersListByArticleId();
	}

	@Override
	@Transactional
	public List<ForumCommentArticleModel> getForumCommentListByArticleId(int articleId) {
		return this.forumDao.getForumCommentListByArticleId(articleId);
	}

	@Override
	@Transactional
	public void addForumCommentToUserArticle(ForumCommentArticleModel comment) {
		this.forumDao.addForumCommentToUserArticle(comment);
	}
}
