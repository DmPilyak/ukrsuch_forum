package com.ukrsuch.ukrsuch.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ukrsuch.ukrsuch.model.ForumCommentArticleModel;
import com.ukrsuch.ukrsuch.model.UserArticleModel;
import com.ukrsuch.ukrsuch.model.UserModel;
import com.ukrsuch.ukrsuch.service.ArticleService;
import com.ukrsuch.ukrsuch.service.ForumService;
import com.ukrsuch.ukrsuch.service.UserService;

@Controller
public class ForumController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ForumService forumService;

	@RequestMapping(value = "/forum_articles", method = RequestMethod.GET)
	public String listAllUserArticles(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		model.addAttribute("user", session.getAttribute("user"));
		List<UserArticleModel> userArticlesList = articleService.getAllUserArticles();
		Collections.reverse(userArticlesList);
		model.addAttribute("listAllUserArticles", userArticlesList);
		List<UserModel> usersList = new ArrayList<UserModel>();
		for (UserArticleModel ua : userArticlesList) {
			UserModel user = userService.getUserById(ua.getAutorId());
			usersList.add(user);
		}
		model.addAttribute("usersList", usersList);
		model.addAttribute("forumUserArticle", new UserArticleModel());
		model.addAttribute("userComment", new ForumCommentArticleModel());
		model.addAttribute("articleReadMore", articleService.getArticleById(1));
		model.addAttribute("mapForumComments", forumService.getAllForumCommentMap());
		model.addAttribute("commentUsers", forumService.getForumCommentUsersListByArticleId());

		return "forumPage";
	}

	@RequestMapping(value = "/forum_articles", method = RequestMethod.POST)
	public String addArticle(@ModelAttribute("forumUserArticle") UserArticleModel userArticle,
			@ModelAttribute("userComment") ForumCommentArticleModel userComment, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		if((userArticle.getDescription() != null) && (userArticle.getTitle() != null)) {
			userArticle.setAutorId(user.getId());
			forumService.addUserArticleToForum(userArticle);
		}
		if((userComment.getCommentContent() != null) && (userComment.getCommentContent() != "")) {
			userComment.setAutorId(user.getId());
			forumService.addForumCommentToUserArticle(userComment);
		}
		model.addAttribute("user", session.getAttribute("user"));
		return "redirect:/forum_articles";
	}
}
