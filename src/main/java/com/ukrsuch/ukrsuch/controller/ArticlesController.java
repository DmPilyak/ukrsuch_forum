package com.ukrsuch.ukrsuch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ukrsuch.ukrsuch.model.ArticleModel;
import com.ukrsuch.ukrsuch.model.CommentArticleModel;
import com.ukrsuch.ukrsuch.model.UserModel;
import com.ukrsuch.ukrsuch.service.ArticleService;

@Controller
public class ArticlesController {
	@Autowired
	private ArticleService articleService;

	@GetMapping("/articles")
	public String listArticles(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		model.addAttribute("user", session.getAttribute("user"));
		model.addAttribute("listArticle", articleService.listArticles());
		model.addAttribute("articleReadMore", articleService.getArticleById(1));

		UserModel user = (UserModel) session.getAttribute("user");
		if (user != null) {
			model.addAttribute("boolArticle", articleService.boolAtriclesMapForUser(user));
		} else
			model.addAttribute("boolArticle", null);

		return "articlesPage";
	}

	@RequestMapping(value = "/article/id/{id_article}")
	public String article(@PathVariable(name = "id_article") int id_article, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		model.addAttribute("user", session.getAttribute("user"));
		model.addAttribute("comment", new CommentArticleModel());
		model.addAttribute("article", articleService.getArticleById(id_article));
		model.addAttribute("articleReadMore", articleService.getArticleById(1));
		model.addAttribute("comments", articleService.getCommentListByArticleId(id_article));
		session.setAttribute("article", articleService.getArticleById(id_article));
		//System.out.println("blob   "+ userService.getArticleById(id_article).getImg());
		model.addAttribute("usersComment", articleService.getCommentUsersListByArticleId(id_article));
		return "fullArticlePage";
	}

	@RequestMapping(value = "/add_article/id/{id_article}")
	public String addArticle(@PathVariable(name = "id_article") int id_article, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		articleService.addArticleToWishList(user, id_article);
		model.addAttribute("user", session.getAttribute("user"));
		model.addAttribute("article", articleService.getArticleById(id_article));
		return "redirect:/articles";
	}

	@RequestMapping(value = "/add_comment", method = RequestMethod.POST)
	public String addArticle(@ModelAttribute("comment") CommentArticleModel comment, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		System.out.println("     user:   "  + user);
		ArticleModel article = (ArticleModel) session.getAttribute("article");
		comment.setAutorId(user.getId());
		comment.setArticleId(article.getId());
		articleService.addCommentToArticle(comment);
		model.addAttribute("user", session.getAttribute("user"));
		return "redirect:/article/id/" + article.getId();
	}

}
