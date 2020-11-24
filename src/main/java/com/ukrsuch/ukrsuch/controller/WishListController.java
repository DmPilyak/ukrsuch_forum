package com.ukrsuch.ukrsuch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ukrsuch.ukrsuch.model.UserModel;
import com.ukrsuch.ukrsuch.service.ArticleService;
import com.ukrsuch.ukrsuch.service.ComicsService;
import com.ukrsuch.ukrsuch.service.UserService;

@Controller
@RequestMapping("/wishList")
public class WishListController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ComicsService comicsService;

	@RequestMapping(method = RequestMethod.GET)
	public String wishListArticles(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		model.addAttribute("user", session.getAttribute("user"));
		UserModel user = (UserModel) session.getAttribute("user");
		if (user == null) {
			model.addAttribute("articlesWishList", null);
			model.addAttribute("comicsWishList", null);
		} else {
			model.addAttribute("articlesWishList", articleService.getWishListForUserById(user.getId()));
			model.addAttribute("comicsWishList", comicsService.getComicsWishListForUserById(user.getId()));
		}
		return "wishListPage";
	}

	@RequestMapping(value = "/remove_article/id/{id_article}")
	public String removeArticleFromWishList(@PathVariable(name = "id_article") int id_article, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		articleService.removeArticleFromUserWishListById(user.getId(), id_article);
		return "redirect:/wishList";
	}
	
	@RequestMapping(value = "/remove_comics/id/{id_comics}")
	public String removeComicsFromWishList(@PathVariable(name = "id_comics") int id_comics, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		comicsService.removeComicsFromUserWishListById(user.getId(), id_comics);
		return "redirect:/wishList";
	}

}
