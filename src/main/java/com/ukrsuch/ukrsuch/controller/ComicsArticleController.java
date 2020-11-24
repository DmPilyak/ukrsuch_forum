package com.ukrsuch.ukrsuch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ukrsuch.ukrsuch.model.ComicsArticleModel;
import com.ukrsuch.ukrsuch.model.CommentArticleModel;
import com.ukrsuch.ukrsuch.model.CommentComicsModel;
import com.ukrsuch.ukrsuch.model.UserModel;
import com.ukrsuch.ukrsuch.service.ArticleService;
import com.ukrsuch.ukrsuch.service.ComicsService;

@Controller
@RequestMapping(value = "/comics")
public class ComicsArticleController {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ComicsService comicsService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listAllComicsArticles(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		model.addAttribute("user", session.getAttribute("user"));
		model.addAttribute("listComicsArticle", comicsService.listComicsArticles());
		model.addAttribute("articleReadMore", articleService.getArticleById(1));
		UserModel user = (UserModel) session.getAttribute("user");
		if (user != null) {
			model.addAttribute("boolComicsArticle", comicsService.boolComicsAtriclesMapForUser(user));
		} else
			model.addAttribute("boolComicsArticle", null);

		return "comicsPage";
	}
	
	@RequestMapping(value = "/id/{id_comics}")
	public String article(@PathVariable(name = "id_comics") int id_comics, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		model.addAttribute("user", session.getAttribute("user"));
		
		model.addAttribute("comment", new CommentArticleModel());
		model.addAttribute("comics", comicsService.getComicsArticleById(id_comics));
		model.addAttribute("comments", comicsService.getComicsCommentListByComicsId(id_comics));
		model.addAttribute("articleReadMore", articleService.getArticleById(41));
		session.setAttribute("comics", comicsService.getComicsArticleById(id_comics));
		model.addAttribute("usersComment", comicsService.getComicsCommentUsersListByComicsId(id_comics));
		return "fullComicsPage";
	}
	
	@RequestMapping(value = "/add_comics/id/{id_comics}")
	public String addArticle(@PathVariable(name = "id_comics") int id_comics, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		comicsService.addComicsArticleToWishList(user, id_comics);
		model.addAttribute("user", session.getAttribute("user"));
		model.addAttribute("article", comicsService.getComicsArticleById(id_comics));
		return "redirect:/comics";
	}
	
	@RequestMapping(value = "/add_comment", method = RequestMethod.POST)
	public String addArticle(@ModelAttribute("comment") CommentComicsModel comment, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		ComicsArticleModel comics = (ComicsArticleModel) session.getAttribute("comics");
		comment.setAutorId(user.getId());
		comment.setComicsId(comics.getId());
		comicsService.addCommentToComics(comment);
		model.addAttribute("user", session.getAttribute("user"));
		return "redirect:/comics/id/" + comics.getId();
	}
}
